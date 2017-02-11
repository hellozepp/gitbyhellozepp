from sys import exit

def dead(why):
    print why, "\nGood luck!\n"
    exit(0)
    
def gold_room():
    print "This room is full of gold.\n\nHow much do you take?\n"

    next = raw_input("> ")

    if "0" in next or "1" in next: #暂时解决不了，用其他方式判断是否输入的是数字
        how_much = int(next)
    else:
        dead("Man, learn to type a number.\n")
        
    if how_much < 50:
        print "Nice, you're not greedy, you win!\n"
        exit(0)
    else:
        dead("You greedy bastard!\n")
gold_room()
