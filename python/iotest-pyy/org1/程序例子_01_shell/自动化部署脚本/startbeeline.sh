#!/usr/bin/env bash
source /etc/profile
$HIVE_HOME/bin/beeline -u jdbc:hive2://localhost:10000 -n hadoop