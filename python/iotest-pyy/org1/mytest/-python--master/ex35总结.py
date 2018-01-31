# def 的用法：
def bear_room():
    print("bear_room()")
def cthulhu_room():
    print("cthulhu_room()")
def gold_room():
    print("gold_room()")
def dead(why):
    print(why, "\nGood job!\n")
    exit(0)

def start():
    print("You are in a dark room.\n")
    print("There is a door to your right and left.\n")
    print("Which one do you take?\n")
    print("\n")
    next = input("> ")
    if next == "1":
        bear_room()
    elif next == "right":
        cthulhu_room()
    else:
        dead("You stumble around the room until you starve.")
        
start()

# while 循环（循环前加入停止条件）：

bear_moved = False
    
while True:
    next = input("> ")

    if next == "1":
        dead("1.\n")
    elif next == "2" and not bear_moved:
        print("2.\n")
        bear_moved = True
    elif next == "taunt bear" and  bear_moved:
        dead("The bear gets pissed off and chews your leg off.\n")
    elif next == "open door" and bear_moved:
        gold_room()
    else:
        print("I got no idea what that means.\n")

