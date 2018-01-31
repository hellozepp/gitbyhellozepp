#!/usr/bin/env bash
#!/usr/bin/expect  -f
echo "your computer is shutdown now!"
SERVERS="node2 node3 node4 node1"
AUTHOR="root"
PASSWORD=123123
for i in $SERVERS
do
    sh $AUTHOR@$i "init 0"
    expect "*password:"
    send "123123"
    interact
done