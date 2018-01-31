import os

from tornado_mysql import pools

pools.DEBUG = True
POOL = pools.Pool(dict(host='127.0.0.1', port=3306, user='root', passwd='root', db='py_tornado'),max_idle_connections=1,max_recycle_sec=3,autocommit=False)

settings = {
    "static_path": os.path.join(os.path.dirname(__file__), "static"),
    "template_path" : os.path.join(os.path.dirname(__file__), "template"),
    "cookie_secret": "61oETzKXQAGaYdkL5gEmGeJJFuYh7EQnp2XdTP1o/Vo=",
    "login_url": "index",
    "xsrf_cookies": True,
}