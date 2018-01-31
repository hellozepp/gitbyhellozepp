import tornado.web

import views
from settings import settings


def create_app():
    return tornado.web.Application([
        (r"/hello0",views.HelloHandler0),
        (r"/hello1",views.HelloHandler1),
        (r"/hello2",views.HelloHandler2),
        (r"/main",views.MainHandler),
        (r"/index",views.Index),
        (r"/file", views.FileUploadHandler),
        (r".*",views.BaseHandler),

    ],**settings)