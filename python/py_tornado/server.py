import tornado
import tornado.ioloop

import urls

if __name__=="__main__":
    app=urls.create_app()
    app.listen(8888)
    tornado.ioloop.IOLoop.current().start()