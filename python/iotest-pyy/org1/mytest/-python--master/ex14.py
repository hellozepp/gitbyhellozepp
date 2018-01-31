#coding=utf8
from sys import argv

user_name = input("Your name: ")
script, user_name = argv,user_name
prompt = '> '

print("Hi %s, I'm the %s script." % (user_name, script))
print("I'd like to ask you a few questions.")
print("Do you like mev %s ?" % user_name)
#设置提示符
likes = input(prompt)
print("Where do you live %s ?" % user_name)
lives = input(prompt)
print("What kind of computer do you have ?")
computer = input(prompt)
print("""
Alright, so you said %r about liking me.
You live in %r. Not sure where taht is.
And you have a %r computer. Nice.
""" % (likes, lives, computer))
