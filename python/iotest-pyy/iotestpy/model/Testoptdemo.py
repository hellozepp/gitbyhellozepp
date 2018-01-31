
import site

import sys

import model.org.opttest
opt1=model.org.opttest
print(opt1.add(1,2))


from model.org import opttest
print(opttest.add(1,2))


from model.org.opttest import add
print(add(1,2))

from model.org.opttest import add
myadd=add
print(myadd(1,2))

print(site.getsitepackages())
print(sys.path)

print("======================================================")

site.addsitedir("/opt")
print(sys.path)
