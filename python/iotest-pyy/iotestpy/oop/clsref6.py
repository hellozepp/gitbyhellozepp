
#! /usr/bin/env python
# -*- coding: utf-8 -*-
import dis
import io


code_str = """
x = 1

y = 1
print(x + y)
print("hello world!")
"""
code_obj = compile(code_str, 'xxx', 'exec')
exec(code_obj)

print(code_obj.co_filename)
print(code_obj.co_name)
print(code_obj.co_code)
print(code_obj.co_consts)
print(code_obj.co_firstlineno)
print(code_obj.co_lnotab)#b'\x06\x02\x06\x01\x0e\x01' 其中\x06\x02\第一个字节是字节码的偏移量
                            # (这里是6字节，加上这之后就到达了我们反汇编之后的第二个 LOAD_CONST )，
                            # 后面是源代码中跳过的行
                            #后面每组都是这个意思

print("="*50+"1")
#===========exec===============================

dis.dis(code_obj)

print("="*50+"2")
#===========exec===============================

def foo(x, y):
    print(x, y)

print(foo.__code__)
print(foo.__code__.co_varnames)
print(foo.__code__.co_argcount)
