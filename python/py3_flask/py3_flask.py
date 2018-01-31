import os

import time

import MySQLdb
import datetime
import flask
from flask import Flask, render_template, redirect, request, url_for, jsonify, send_from_directory, abort, session, g, \
    _app_ctx_stack, current_app, make_response
from sqlalchemy import pool
from werkzeug.utils import secure_filename, escape

app = Flask(__name__,static_folder="mystatic",template_folder="mytemplates")

@app.errorhandler(404)
def err404(error):
    return render_template("404.html"),404

@app.errorhandler(500)
def err500(error):
    return render_template("500.html"),500


@app.route('/helloworld')
def hello_world():
    return 'Hello World!'


#参数类型有三种：int,float,path(也就是字符串)
@app.route('/sayhello/')
@app.route('/sayhello/<name>/<int:age>/') #注意结尾的分隔符，如果不写，运行sayhello/的时候就会找不到页面了
def sayhello(name="xxx",age=0):
    return 'Hello '+name+'! his age is: '+str(age)


@app.route('/hello')
@app.route('/hello/<name>')
def hello(name="xxx"):
    return render_template("hello.html",name=name)

@app.route('/red')
def red():
    return redirect("sayhello/aaa/22")

#=========================================post get===============================================================
@app.route("/",methods=["GET"])
def index():
    return render_template("index.html")

@app.route("/login",methods=["POST"])
def loginpost():
    if request.method == "POST":
        print(request.stream.read().decode("utf-8"))
        username = request.form.get('username')
        password = request.form.get('password')
        return "<h1>welcome post, %s !</h1>" % username

@app.route("/login",methods=["GET"])
def loginget():
    if request.method == "GET":
        username = request.args.get('username')
        password = request.args.get('password')
        return "<h1>welcome get, %s !</h1>" % username

@app.route('/urlfor')
def urlfor():
    with app.test_request_context():
        print(url_for("index"))
        print(url_for("loginpost"))
        print(url_for("loginget",username="哈哈",password="呵呵"))
    return 'Hello World!'

#==================================file===========================================================================
# 用于测试上传，稍后用到
@app.route('/upload', methods=['GET'])
def upload_test():
    return render_template('upload.html')

UPLOAD_FOLDER='upload'
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
basedir = os.path.abspath(os.path.dirname(__file__))
ALLOWED_EXTENSIONS = set(['txt', 'png', 'jpg', 'xls', 'JPG', 'PNG', 'xlsx', 'gif', 'GIF'])


# 用于判断文件后缀
def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1] in ALLOWED_EXTENSIONS

# 上传文件
@app.route('/upload', methods=['POST'], strict_slashes=False)
def api_upload():
    file_dir = os.path.join(basedir, app.config['UPLOAD_FOLDER'])
    if not os.path.exists(file_dir):
        os.makedirs(file_dir)
    f = request.files['myfile']  # 从表单的file字段获取文件，myfile为该表单的name值
    if f and allowed_file(f.filename):  # 判断是否是允许上传的文件类型
        fname = secure_filename(f.filename)
        print(fname)
        ext = fname.rsplit('.', 1)[1]  # 获取文件后缀
        unix_time = int(time.time())
        new_filename = str(unix_time) + '.' + ext  # 修改了上传的文件名
        f.save(os.path.join(file_dir, new_filename))  # 保存文件到upload目录

        return jsonify({"errno": 0, "errmsg": "上传成功", "new_filename": new_filename})
    else:
        return jsonify({"errno": 1001, "errmsg": "上传失败"})

@app.route('/download/<filename>')
def download(filename):
    if request.method=="GET":
        return send_from_directory('upload',filename,as_attachment=True)

#============================================session==============================================================
@app.route('/se')
def seindex():
    if 'username' in session:
        return 'Logged in as %s' % escape(session['username'])
    return 'You are not logged in'

@app.route('/selogin', methods=['GET', 'POST'])
def selogin():
    if request.method == 'POST':
        session['username'] = request.form['username']
        return redirect(url_for('seindex'))
    return '''
        <form action="/selogin" method="post">
            <p><input type=text name=username>
            <p><input type=submit value=seLogin>
        </form>
    '''

@app.route('/selogout')
def selogout():
    # remove the username from the session if it's there
    session.pop('username', None)
    return redirect(url_for('seindex'))

# set the secret key.  keep this really secret:
app.secret_key = 'A0Zr98j/3yX R~XHH!jmN]LWX/,?RT'

#============================================cookie=================================================================
@app.route('/set_cookie')
def set_cookie():
    response=make_response('Hello World')
    outdate = datetime.datetime.today() + datetime.timedelta(days=30)
    response.set_cookie('Name', 'Hyman', expires=outdate)
    return response

@app.route('/get_cookie')
def get_cookie():
    name=request.cookies.get('Name')
    return name

@app.route('/get_template')
def get_template():
    return render_template('test.html')

@app.route('/del_cookie')
def del_cookie():
    response=make_response('delete cookie')
    response.set_cookie('Name','',expires=0)
    return response

@app.route('/del_cookie2')
def del_cookie2():
    response=make_response('delete cookie2')
    response.delete_cookie('Name')
    return response

#============================================application==============================================================
#ｇ只能在一次请求中传递数据
@app.route('/setg')
def setg():
    g.att1 = 'xxx'
    return g.att1

@app.route('/getg')
def getg():
    n=getattr(g,"att1","None")
    return n

#=====================================钩子==============================================================================
@app.before_first_request
def bf_first_request():
    g.string = 'before_first_request'
    print("bf_first_request: ",g.string)

@app.before_request
def bf_request():
    g.string = 'before_request'
    print("bf_request: ",g.string)

@app.route('/hook')
def hook():
    print("hook: ",g.string)
    return "ok"

@app.after_request
def af_request(param):
    print("af_request: ",param.__dict__)
    return param

@app.teardown_request
def td_request(param):
    print("td_request: ",param)
    return param

#=====================================db==============================================================================




from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String

db_connect_string='mysql://root:root@localhost:3306/sqlalchemy?charset=utf8'
Base = declarative_base()

class Account(Base):
    __tablename__ = u'account'

    id = Column(Integer, primary_key=True)
    user_name = Column(String(50), nullable=False)
    password = Column(String(200), nullable=False)
    title = Column(String(50), nullable=False)
    salary = Column(Integer)

    def is_active(self):
        #"""假设所有用户都是活跃用户."""
        return True

    def get_id(self):
        #"""  返回账号ID, 用方法返回属性值提高了表的封装性."""
        return self.id

    def is_authenticated(self):
        #"""假设已经通过验证"""
        return True

    def is_anonymous(self):
        #"""具有登录名和密码的账号不是匿名用户"""
        return False

    __table_args__ = {
        "mysql_charset": "utf8"
    }



engine = create_engine(db_connect_string, max_overflow=5)
SessionType = scoped_session(sessionmaker(bind=engine,expire_on_commit=False))
def GetSession():
    return SessionType()

@app.route('/db')
def indexdb():
    # con = get_db()
    # cursor = con.cursor(cursorclass=MySQLdb.cursors.DictCursor)
    # rv = cursor.execute('select 1')
    session = GetSession()
    account = Account(user_name="aaa", password="bbb", title="ccc", salary=9999999)
    session.add(account)
    session.commit()

    return str(account.id)+" "+account.user_name

#==================================WTForm===========================================================
from wtforms import Form, BooleanField, TextField, PasswordField, validators

class RegistrationForm(Form):
    username = TextField('Username', [validators.Length(min=4, max=25)])
    email = TextField('Email Address', [validators.Length(min=6, max=35)])
    password = PasswordField('New Password', [
        validators.Required(),
        validators.EqualTo('confirm', message='Passwords must match')
    ])
    confirm = PasswordField('Repeat Password')
    accept_tos = BooleanField('I accept the TOS', [validators.Required()])

@app.route('/register', methods=['GET', 'POST'])
def register():
    form = RegistrationForm(request.form)
    if request.method == 'POST' and form.validate():
        str=form.username.data+form.email.data+form.password.data
        return str
    return render_template('register.html', form=form)


if __name__ == '__main__':
    app.run(host="0.0.0.0",port=8888,debug=False)
