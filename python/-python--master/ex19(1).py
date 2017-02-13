def cheese_and_crackers(cheese_count, boxes_of_crackers):
    print "You have %s cheeses!" % cheese_count
    print "You have %s boxes of crackers!" % boxes_of_crackers
    print "Man that's enough for a party!"
    print "Get a blanket.\n"
    
cheese_count = raw_input("Number:")
boxes_of_crackers = raw_input("Number:")
print "We can just give the function numbers directly:"
cheese_and_crackers(cheese_count, boxes_of_crackers)
p = '>'
amount_of_cheese = raw_input(p)
amount_of_crackers = raw_input(p)
print "OR, we can use variables from our script:"
cheese_and_crackers(amount_of_cheese, amount_of_crackers)
print "We can even do math inside too:"
cheese_and_crackers(10 + 20, 5 + 6)
print "And we can combine the two, variables and math:"
cheese_and_crackers(amount_of_cheese ,
                    amount_of_crackers )
