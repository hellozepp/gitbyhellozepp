# -- coding: utf-8 --
#������������100
cars = 100
#�����ռ����4
space_in_a_car = 4
#˾������������30
drivers = 30
#�˿͵���������90
passengers = 90
#������˾������֮��
cars_not_driven = cars - drivers
#˾��������
cars_driven = drivers
#���Ժϻ�ʹ������������
carpool_capacity = cars_driven * space_in_a_car
#ƽ��ÿ�����ĳ˿͵�����
average_passengers_per_car = passengers / cars_driven

print("There are",cars,"cars available")
print("There are only",drivers,"drivers available.")
print("There will be",cars_not_driven,"empty cars today.")
print("We can transport",carpool_capacity,"people today.")
print("We have",passengers,"to carpool today.")
print("We need to put about",average_passengers_per_car,"in each car.")
