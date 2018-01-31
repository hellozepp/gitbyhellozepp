from sys import exit

q = "*" * 20

class Game(object):
    def __init__(self,start):
        self.start = start
    
    def bear_room(self):
        print("There is a bear here.\n")
        print("The bear has a bunch of honey.\n")
        print("The fat bear is in front of another door.\n")
        print("How are you going to move the bear?\n")
        print(q, "\n")
        bear_moved = False
    
        while True:
            next = input("> ")
        
            if next == "take honey":
                self.dead("The bear looks at you then slaps your face off.\n")
            elif next == "taunt bear" and not bear_moved:
                print("The bear has moved from the door. You can go through it now.\n")
                bear_moved = True
            elif next == "taunt bear" and  bear_moved:
                self.dead("The bear gets pissed off and chews your leg off.\n")
            elif next == "open door" and bear_moved:
                self.gold_room()
            else:
                print("I got no idea what that means.\n")

    def cthulhu_room(self):
        print("Here you see the great evil Cthulhu.\n")
        print("He, it, whatever stares at you and you go insane.\n")
        print("Do you flee for your life or eat your head?\n")
        print(q,"\n")
    
        next = input("> ")
    
        if "flee" in next:
            self.start()
        elif "head" in next:
            self.dead("Well that was tasty!\n")
        else:
            self.cthulhu_room()

    def gold_room(self):
        print("This room is full of gold. How much do you take?\n")

        next = input("> ")

        if "0" in next or "1" in next: #暂时解决不了，用其他方式判断是否输入的是数字
            how_much = int(next)
        else:
            self.dead("Man, learn to type a number.\n")
        
        if how_much < 50:
            print("Nice, you're not greedy, you win!\n")
            exit(0)
        else:
            self.dead("You greedy bastard!\n")
        
    def dead(why):
        print(why, "\nGood job!\n")
        exit(0)

    def play(self):
        
        print("You are in a dark room.\n")
        print("There is a door to your right and left.\n")
        print("Which one do you take?\n")
        print(q,"\n")
        next = input("> ")
        
        if next =="left":
            self.bear_room(self)
        elif next == "right":
            self.cthulhu_room()
        else:
            self.dead("You stumble around the room until you starve.")
a_game = Game("play")
a_game.play()

