cities = {'CA':'San Francisco','MI':'Detroit','FL':'Jacksonvile'}
cities['NY'] = 'New York'
cities['OR'] = 'Portland'

def find_city(themap, state):
    if state in themap:
        #print themap #themap 应该就是 cities 中的一个位置
        return themap[state]
    else:
        return "Not found."
cities['_find'] = find_city
while True:
    print("State? (ENTER TO QUIT)", end=' ')
    state = input("> ")
    if not state: break       #在运行过程中实现的功能是按"Enter"退出
    city_found = cities['_find'](cities, state)
    print(city_found)
    print(state)
    
