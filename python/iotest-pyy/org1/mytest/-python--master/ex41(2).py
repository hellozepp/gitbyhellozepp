from sys import exit
from random import randint

def death():
    quips = ["You died. You kinda suck at this.",
             "Nice job, you died ...jackass.",
             "Such a luser.",
             "I have a small puppy that's better at this."]
    print(quips[randint(0, len(quips)-1)])
    exit(1)
def central_corridor():
    print("Armory and about to pull a weapon to blast you.")
    action = input("> ")
    if action == "shoot!":
        print("you are dead. Then he eats you.")
        return 'death'
    elif action == "dodge!":
        print("your head and eats you.")
        return 'death'
    elif action == "tell a joke":
        return 'laser_weapon_armory'
    else:
        print("DOES NOT COMPUTE!")
        return 'central_corridor'
def laser_weapon_armory():
    print("get the bomb. The code is 3 digits.")
    code = "%d%d%d" % (randint(1, 9), randint(1, 9),randint(1, 9))
    guess = input("[keypad]> ")
    guesses = 0
    while guess != code and guess < 10:
        print("BZZZZEDDD!")
        guesses += 1
        guess = input("[keypad]> ")
    if guess == code:
        print("bridge where you must place it in the right spot.")
        return 'the_bridge'
    else:
        print("ship from their ship and you die.")
        return 'death'
def the_bridge():
    print("arm and don't want to set it off.")
    action = input("> ")
    if action == "throw the bomb":
        print("it goes off.")
        return 'death'
    elif action == "slowly place the bomb":
        print("get off this tin can.")
        return 'escape_pod'
    else:
        print("DOES NOT COMPUTE!")
        return "the_bridge"
def escape_pod():
    print("do you take?")
    good_pod = randint(1,5)
    guess = input("[pod #]> ")
    if int(guess) != good_pod:
        print("into jam jelly.")
        return 'death'
    else:
        print("time. You won!")
        exit(0)
ROOMS = {
    'death': death,
    'central_corridor': central_corridor,
    'laser_weapon_armory': laser_weapon_armory,
    'the_bridge': the_bridge,
    'escape_pod': escape_pod
}
def runner(map, start):
    next = start
    while True:
        room = map[next]
        print("\n--------")
        next = room()
runner(ROOMS, 'central_corridor')
        
