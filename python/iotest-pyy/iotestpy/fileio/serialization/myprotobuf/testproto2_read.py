import fileio.serialization.myprotobuf.addressbook_pb2 as addressbook
import sys

def ListPeople(address_book):
    for person in address_book.people:
        print("Person ID:", person.id)
        print(" Name:", person.name)
        if person.HasField("email"):
            print(" E-mail adress:", person.email)

        for phone_number in person.phones:
            if phone_number.type == addressbook.Person.MOBILE:
                print(" Mobile phone #:",end="")
            elif phone_number.type == addressbook.Person.HOME:
                print(" Home phone #:",end="")
            elif phone_number.type == addressbook.Person.WORK:
                print(" Work phone #:",end="")
            print(phone_number.number)


address_book = addressbook.AddressBook()

# Read the existing address book
f = open("/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/prototxt", "rb")
address_book.ParseFromString(f.read())
f.close()

ListPeople(address_book)