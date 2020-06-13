#!/usr/bin/env bash
echo 'Starting Application'
#java -jar mutualfund-0.0.1-SNAPSHOT.jar &
nohup java -jar mutualfund-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
echo 'Started Application'