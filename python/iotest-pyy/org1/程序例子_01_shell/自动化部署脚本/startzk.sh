#!/bin/bash
echo "bulid the auto start process!"
for i in 1 2 3
do
	ssh hadoop@zookeeper0$i "source /etc/profile;zkServer.sh start;zkServer.sh status"
done
	#配置无密认证：rm -rf ~/.ssh;ssh hadoop@localhost;ssh-keygen -t rsa -P ''<<EOF
	#EOF;for i in 1 2 3
	# do
	# 	ssh-copy-id node$i
	# done
