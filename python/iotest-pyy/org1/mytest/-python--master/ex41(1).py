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
    print("The Gothons of Planet Percal #25 have invaded your ship and destroyed")
    print("your entire crew. You are the last surviving member and your last")
    print("mission is to get the neutron destruct bomb from the Weapons Armory,")
    print("put it in the bridge, and blow the ship up after getting into an ")
    print("escape pod.")
    print("\n")
    print("You're running down the central corridor to the Weapons Armory when")
    print("a Gothon jumps out, red scaly skin, dark grimy teeth, and evil clown costume")
    print("flowing around hishatefilled body. He's blocking the door to the")
    print("Armory and about to pull a weapon to blast you.")
    action = input("> ")
    if action == "shoot!":
        print("Quick on the draw you yank out your blaster and fire it at the Gothon.")
        print("His clown costume is flowing and moving around his body, which throws")
        print("off your aim. Your laser hits his costume but misses him entirely. This")
        print("completely ruins his brand new costume his mother bought him, which")
        print("makes him fly into an insane rage and blast you repeatedly in the face until")
        print("you are dead. Then he eats you.")
        return 'death'
    elif action == "dodge!":
        print("Like a world class boxer you dodge, weave, slip and slide right")
        print("astheGothon's blaster cranks alaser past your head.")
        print("In the middle of your artful dodge your foot slips and you")
        print("bang your head on the metal wall and pass out.")
        print("You wake up shortly after only to die as the Gothon stomps on")
        print("your head and eats you.")
        return 'death'
    elif action == "tell a joke":
        print("Lucky foryouthey made youlearn Gothon insults in the academy.")
        print("You tell the one Gothon joke you know:")
        print("Lbhe zbgure vf fb sng, jura fur fvgf nebhaq gur ubhfr, fur fvgf nebhaq gur ubhfr.")
        print("The Gothon stops, tries nottolaugh, then busts out laughing and can't move.")
        print("While he's laughing you run up and shoot him square in the head")
        print("putting him down, then jump through the Weapon Armory door.")
        return 'laser_weapon_armory'
    else:
        print("DOES NOT COMPUTE!")
        return 'central_corridor'
def laser_weapon_armory():
    print("You do a dive roll into the Weapon Armory, crouch and scan the room")
    print("for more Gothons that might be hiding. It's dead quiet, too quiet.")
    print("You stand up and run to the far side of the room and find the")
    print("neutron bomb in its container. There's a keypad lock on the box")
    print("and you need the code to get the bomb out. If you get the code")
    print("wrong 10 times then the lock closes forever and you can't")
    print("get the bomb. The code is 3 digits.")
    code = "%d%d%d" % (randint(1, 9), randint(1, 9),randint(1, 9))
    guess = input("[keypad]> ")
    guesses = 0
    while guess != code and guess < 10:
        print("BZZZZEDDD!")
        guesses += 1
        guess = input("[keypad]> ")
    if guess == code:
        print("The container clicks open and the seal breaks, letting gas out.")
        print("You grab the neutron bomb and run as fast as you can to the")
        print("bridge where you must place it in the right spot.")
        return 'the_bridge'
    else:
        print("The lock buzzes one last time and then you hear a sickening")
        print("melting sound as the mechanism is fused together.")
        print("You decide tositthere, andfinally theGothons blow up the")
        print("ship from their ship and you die.")
        return 'death'
def the_bridge():
    print("You burst onto the Bridge with the neutron destruct bomb")
    print("under your arm and surprise 5Gothons who are trying to")
    print("take control of the ship. Each of them has an even uglier")
    print("clown costume than the last. They haven't pulled their")
    print("weapons out yet, as they see the active bomb under your")
    print("arm and don't want to set it off.")
    action = input("> ")
    if action == "throw the bomb":
        print("In a panic you throw the bomb at the group of Gothons")
        print("and make aleap for the door. Right as you drop")
        print("Gothon shoots you right in the back killing")
        print("As you die you see another Gothon frantically")
        print("the bomb. You die knowing they will probably blow up when")
        print("it goes off.")
        return 'death'
    elif action == "slowly place the bomb":
        print("You point your blaster at the bomb under your arm")
        print("and the Gothons put their hands up and start")
        print("You inch backward tothe door, open it, and then to sweat.")
        print("You inch backward tothe door, open it, and then carefully")
        print("place the bomb on the floor, pointing your blaster at it.")
        print("You then jump back through the door, punch the close button")
        print("and blast the lock so the Gothons can't get out.")
        print("Now that thebomb isplaced youruntotheescape pod to")
        print("get off this tin can.")
        return 'escape_pod'
    else:
        print("DOES NOT COMPUTE!")
        return "the_bridge"
def escape_pod():
    print("You rushthrough theshipdesperately trying tomake it to")
    print("the escape pod before the whole ship explodes. It seems like")
    print("hardly any Gothons are on the ship, so your run is clear of")
    print("interference. You get to the chamber with the escape pods, and")
    print("now need to pick one to take. Some of them could be damaged")
    print("but you don't have time to look. There's 5 pods, which one")
    print("do you take?")
    good_pod = randint(1,5)
    guess = input("[pod #]> ")
    if int(guess) != good_pod:
        print("You jump into pod %sandhittheeject button." % guess)
        print("The pod escapes out into the void of space")
        print("implodes as the hull ruptures, crushing your body")
        print("into jam jelly.")
        return 'death'
    else:
        print("You jump into pod %sandhittheeject button." % guess)
        print("The pod easily slides out into space heading")
        print("the planet below. As it flies to the planet, guess to")
        print("the planet below. As it flies to the planet,you look")
        print("back andseeyour ship implode then explode like a")
        print("bright star, taking out the Gothon ship at the same")
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
