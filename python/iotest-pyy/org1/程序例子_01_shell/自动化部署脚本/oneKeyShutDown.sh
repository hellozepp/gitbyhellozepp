#!/usr/bin/env bash
#!/usr/bin/expect  -f
echo "your computer is shutdown now!"
SERVERS="node2 node3 node4 node1"
AUTHOR="root"
PASSWORD=123123
for i in $SERVERS
do
	 expect -c "set timeout 1;
        spawn ssh $AUTHOR@$i init 0;;
        expect {
            *assword:* {send -- $PASSWORD\r;exp_continue;}
            eof        {exit 0;}
        }";
done