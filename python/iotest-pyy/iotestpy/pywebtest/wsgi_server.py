from wsgiref.simple_server import make_server
from pywebtest.webapp import application

server=make_server(b"",10000,application)
server.serve_forever()