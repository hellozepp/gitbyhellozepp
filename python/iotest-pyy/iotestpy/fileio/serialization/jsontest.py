import json

test = {"username":"测试","age":16}
print(type(test))
python_to_json = json.dumps(test,ensure_ascii=False)
print(python_to_json)
print(type(python_to_json))

json_to_python = json.loads(python_to_json)
print(type(json_to_python))
print(json_to_python['username'])