from django.conf.urls import url

from . import views

urlpatterns = [
    url(r'^sayhello', views.say_hello),
    url(r'^index', views.index),
    url(r'^regist',views.doreg),
    url(r'^disk', views.register),
    url(r'^users', views.getusers),
    url(r'^xxx', views.red),
]