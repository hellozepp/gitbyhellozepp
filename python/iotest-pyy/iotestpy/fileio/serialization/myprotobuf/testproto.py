#protoc --python_out=. addressbook.proto
import fileio.serialization.myprotobuf.addressbook_pb2 as addressbook

person = addressbook.Person()
person.id = 1234
person.name = "John Doe"
person.email = "jdoe@example.com"
phone = person.phones.add() #phones字段是符合类型，调用add()方法初始化新实例。如果phones字段是标量类型，直接append()添加新元素即可。
phone.number = "555-4321"
phone.type = addressbook.Person.HOME
print(phone)