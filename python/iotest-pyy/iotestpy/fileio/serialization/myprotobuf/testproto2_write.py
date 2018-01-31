
import fileio.serialization.myprotobuf.addressbook_pb2 as addressbook
import sys

def PromptForAddress(person):
    person.id = int(input("Enter person ID number: "))
    person.name = input("Enter name: ")

    email = input("Enter email address (blank for none): ")
    if email != "":
        person.email = email

    while True:
        number = input("Enter a phone number (or leave blank to finish): ")
        if number == "":
            break

        phone_number = person.phones.add()
        phone_number.number = number

        type = input("Is this a mobile, home or work phone? ")
        if type == "mobile":
            phone_number.type = addressbook.Person.MOBILE
        elif type == "home":
            phone_number.type = addressbook.Person.HOME
        elif type == "work":
            phone_number.type = addressbook.Person.WORK
        else:
            print("Unkown phone type; leaving as default value")



address_book = addressbook.AddressBook()

# Read the existing address book.
try:
    f = open("/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/prototxt", "rb")
    address_book.ParseFromString(f.read())
    f.close()
except IOError:
    print(": Could not open file. Creating a new one.")

# Add an address.
PromptForAddress(address_book.people.add())

# Write the new address book back to disk.
f = open("/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/prototxt", "wb")
f.write(address_book.SerializeToString())
f.close()