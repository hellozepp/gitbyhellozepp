#!/usr/bin/env bash
echo "bulid the auto start process!"
for i in 1 2 3
do
	ssh hadoop@zookeeper0$i "source /etc/profile;zkServer.sh stop;zkServer.sh status;"
done