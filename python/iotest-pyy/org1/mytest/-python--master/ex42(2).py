from sys import exit
from random import randint

class Game(object):
    def __init__(self,start):
        self.quips = ["You died. You kinda suck at this.",
             "Nice job, you died ...jackass.",
             "Such a luser.",
             "I have a small puppy that's better at this."]
        self.start = start
    def play(self):
        next = self.start

        while True:
            print("\n--------")
            print(self.start)
            
            room = getattr(self, next)
            next = room()

    def deat(self):
        print(self.quips[randint(0, len(self.quips)-1)])
        exit(1)
    def central_corridor(self):
        print("The Gothons of Planet Percal #25 have invaded your ship and destroyed")
        print("Armory and about to pull a weapon to blast you.")
        action = input("> ")
        if action == "shoot!":
            print("you are dead. Then he eats you.")
            return 'death'
        elif action == "dodge!":
            print("your head and eats you.")
            return 'deat'
        elif action == "tell a joke":
            print("putting him down, then jump through the Weapon Armory door.")
            return 'laser_weapon_armory'
        else:
            print("DOES NOT COMPUTE!")
            return 'central_corridor'
            exit(0)
a_game = Game("central_corridor")
a_game.play()
