def application(environ,start_response):
    status = '200 OK'
    response_headers = [('Content-type', 'text/html')]
    start_response(status, response_headers)
    return [u"<b>Hello World!</b>".encode('utf8')]