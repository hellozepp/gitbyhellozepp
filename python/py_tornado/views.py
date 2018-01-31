import json
import os
import uuid

import datetime
import tornado.web
import tornado.gen
import tornado.escape
import tornado.httpclient
from tornado_mysql.pools import Transaction

import settings
from constutils import AppContext

dict_session={}

class BaseHandler(tornado.web.RequestHandler):
    def get_current_user(self):
        print("---------")
        session_id=self.get_secure_cookie("session_id")
        print(session_id.decode())
        print(dict_session)
        value=dict_session.get(session_id.decode())
        print(value)
        return value

    def get(self):
        self.write_error(404)

    def write_error(self, status_code, **kwargs):
        if status_code == 404:
            self.render('404.html')
        elif status_code == 500:
            self.render('500.html')
        else:
            self.write('error:' + str(status_code))

#=====================================================================


class HelloHandler0(BaseHandler):
    def get(self, *args, **kwargs):
        self.write("helloworld!")

class HelloHandler1(BaseHandler):
    @tornado.gen.coroutine
    def get(self, *args, **kwargs):
        httpcli = tornado.httpclient.AsyncHTTPClient()
        response=yield httpcli.fetch("http://www.baidu.com")
        self.write(response.body)

class HelloHandler2(BaseHandler):
    @tornado.web.asynchronous
    def get(self, *args, **kwargs):
        httpcli=tornado.httpclient.AsyncHTTPClient()
        httpcli.fetch("http://www.baidu.com",callback=self.xxx)
    def xxx(self,response):
        self.write(response.body)
        self.finish()

#===========================================================================================================

class Index(BaseHandler):
    def get(self, *args, **kwargs):
        print("g==============")
        self.render("index.html")

    @tornado.gen.coroutine
    def post(self, *args, **kwargs):
        print("p==============")
        un=self.get_argument("uname")
        up=self.get_argument("upass")
        session_id=str(uuid.uuid1())
        print(session_id)
        dict_session[session_id]=self.get_argument("uname")
        print(dict_session)
        self.set_secure_cookie("session_id",session_id)
        print("main")
        dt = datetime.datetime.now()
        AppContext.inc+=1

        # cur = yield settings.POOL.execute("insert into testapp_user(uid,username,password,regtime) values(%s,%s,%s,%s)",
        #                                   (AppContext.inc,un,up,dt))
        # print(cur)

        conn=yield settings.POOL.get_conn()
        trs=Transaction(settings.POOL,conn)
        cur = yield trs.execute("insert into testapp_user(uid,username,password,regtime) values(%s,%s,%s,%s)",
                                          (AppContext.inc,un,up,dt))
        if AppContext.inc%2==0:
            yield trs.rollback()
        else:
            yield  trs.commit()

        self.redirect("main")

class MainHandler(BaseHandler):
    @tornado.gen.coroutine
    @tornado.web.authenticated
    def get(self, *args, **kwargs):
        print("m==============")

        cur = yield settings.POOL.execute("select * from testapp_user")
        strj="["
        for r in cur:
            print(r)
            (uid,unm,pws,dtime)=r
            dtime=dtime.strftime('%Y-%m-%d %H-%M-%S')
            strj+="{\"uid\":\""+str(uid)+"\",\"unm\":\""+unm+"\",\"pws\":\""+pws+"\",\"dtime\":\""+dtime+"\"},"

        strj+="]"
        self.write(strj)

class FileUploadHandler(tornado.web.RequestHandler):
    def get(self):
        self.render("upload.html")

    def post(self):
        ret = {'result': self.get_argument("xxx")}
        upload_path = os.path.join(os.path.dirname(__file__), 'files')  # 文件的暂存路径
        file_metas = self.request.files.get('file', None)  # 提取表单中‘name’为‘file’的文件元数据

        if not file_metas:
            ret['result'] = 'Invalid Args'
            return ret

        for meta in file_metas:
            filename =datetime.datetime.now().strftime("%Y-%m-%d %H-%M-%S")+ meta['filename']
            file_path = os.path.join(upload_path, filename)

            with open(file_path, 'wb') as up:
                up.write(meta['body'])
                # OR do other thing

        self.write(json.dumps(ret))

