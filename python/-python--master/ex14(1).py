user_name = raw_input("Your name: ")
user_address = raw_input("Your adress:")
user_name = user_name
prompt = '> '

print "Hi %s, I'm the Robot." % user_name
print "I'd like to ask you a few questions."
print "Do you like me, %s ?" % user_name
likes = raw_input(prompt)
print "Where do you live %s ?" % user_address
lives = raw_input(prompt)
print "What kind of computer do you have ?"
computer = raw_input(prompt)
print """
Alright, so you said %r about liking me.
You live in %r. Not sure where taht is.
And you have a %r computer. Nice.
""" % (likes, lives, computer)
