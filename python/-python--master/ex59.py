import web

urls = (
    '/', 'index'
)

app = web.application(urls, globals())

class index:
    def GET(self):
        greenting = "Hello World!"
        return greeting
if __name__ == "__main__":
    app.run()
