import json
import pprint

from django.core.paginator import Paginator, PageNotAnInteger, EmptyPage
from django.db.models.functions import datetime
from django.http import HttpResponse
from django.shortcuts import render, render_to_response, redirect

# Create your views here.
from django.template import RequestContext
from django.views.decorators.csrf import csrf_exempt
from django.db import connection, transaction
from tables import Column

from testapp.constutils import AppContext
from testapp.forms import UserForm
from testapp.models import UserPhoto, User


@csrf_exempt
def page_not_found(request):
 return render_to_response('404.html')

@csrf_exempt
def page_error(request):
 return render_to_response('500.html')

@csrf_exempt
def say_hello(request):
    print("--------------------: "+request.META['HTTP_USER_AGENT'])
    return HttpResponse("<h1>hello world!</h1>")

def red(request):
    return redirect('index.html')

@csrf_exempt
def index(request):
    return render(request, 'index.html')

@csrf_exempt #django为了防止csrf攻击
def doreg(request):
    if request.method == 'POST':
        user = request.POST.get('uname')
        pwd = request.POST.get('upass')

        request.session["xxx"] = user

        sql = "insert into testapp_user(uid,username,password,regtime) values(%s,%s,%s,%s)"
        cursor = connection.cursor()
        transaction.set_autocommit(False,)
        sp1 = transaction.savepoint()
        AppContext.inc+=1
        dt = datetime.datetime.now()
        cursor.execute(sql, (AppContext.inc,user,pwd,dt))

        sp2 = transaction.savepoint()
        AppContext.inc += 1
        dt = datetime.datetime.now()
        cursor.execute(sql, (AppContext.inc, user, pwd, dt))
        transaction.savepoint_rollback(sp2)
        transaction.commit()

        count=cursor.execute("select * from testapp_user")
        raws=[]
        for i in range(0,count):
            raw = cursor.fetchone()
            (uid,unm,pws,dtime)=raw
            mydict={}
            mydict["uid"]=uid
            mydict["unm"] = unm
            mydict["pws"] = pws
            mydict["dtime"] = dtime.strftime('%Y-%m-%d %H:%M:%S')
            raws.append(mydict)
        jsonstr=json.dumps(raws)
        return HttpResponse(jsonstr)
    elif request.method == 'GET':
        user=request.GET.get('uname')
        pwd = request.GET.get('upass')

        pprint.pprint(request.COOKIES)  # 查看cooke
        print(request.get_signed_cookie('k2',salt='uuu',default="NULL"))
        rep = HttpResponse("<h1>get&nbsp;&nbsp;" + user + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + pwd+"</h1><br>"+request.session.get("xxx","NULL"))  # 设置cook 必须在响应里面设置
        rep.set_cookie('k1',123) # 普通的cooke
        rep.set_signed_cookie('k2',666,salt='uuu') # 加密的cookie salt加严
        rep.set_cookie('k999',123,path='/cooke1/') # 添加路径表示只有在当前url下才会生效
        rep.set_cookie('k888',123)


        return rep
    else:
        return render(request, 'index.html')

@csrf_exempt
def register(request):
    if request.method == "POST":
        uf = UserForm(request.POST, request.FILES)
        f=request.FILES.get('headImg')
        fobj = open("./myupload/xxx", 'wb');
        for chrunk in f.chunks():
            fobj.write(chrunk);
        fobj.close();
        if uf.is_valid():
            username = uf.cleaned_data['username']
            headImg = uf.cleaned_data['headImg']
            # 写入数据库
            user = UserPhoto()
            user.username = username
            user.headImg = headImg
            user.headImg
            #=================================增=================================
            user.save()

            # 初始化
            res = ""
            # =================================查=================================
            # 通过objects这个模型管理器的all()获得所有数据行，相当于SQL中的SELECT * FROM
            list = User.objects.all()

            # filter相当于SQL中的WHERE，可设置条件过滤结果
            response2 = User.objects.filter(uid=1)
            response4=User.objects.filter(username__contains="w")

            # 获取单个对象
            response3 = User.objects.get(uid=1)

            # 限制返回的数据 相当于 SQL 中的 OFFSET 0 LIMIT 2;
            list = User.objects.order_by('username')[0:2]

            # 数据排序
            list = User.objects.order_by("uid")

            # 上面的方法可以连锁使用
            list = User.objects.filter(username="www").order_by("uid")

            # 输出所有数据
            for var in list:
                res += var.username + " "
            print("-----: "+res)

            # =================================改=================================
            # 修改其中一个id=1的name字段，再save，相当于SQL中的UPDATE
            u1 = User.objects.get(uid=1)
            u1.username= 'xxx1'
            u1.save()

            # 另外一种方式
            User.objects.filter(uid=1).update(username='xxx2')

            # 修改所有的列
            User.objects.all().update(username='xxx3')

            # =================================删=================================
            # 删除id=1的数据
            u2 = User.objects.get(uid=1)
            u2.delete()

            # 另外一种方式
            User.objects.filter(uid=2).delete()

            # 删除所有数据
            User.objects.all().delete()


            return HttpResponse('upload ok!<br>'+res)
    else:
        uf = UserForm()
    return render_to_response('register.html', {'uf': uf})




@csrf_exempt
def getusers(request):
    user_list = User.objects.filter().all()[2:6]
    return render_to_response("users.html", {'user_list': user_list})
