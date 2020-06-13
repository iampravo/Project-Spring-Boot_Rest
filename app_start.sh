#!/usr/bin/env bash
echo 'Starting Application'
#java -jar mutualfund-0.0.1-SNAPSHOT.jar &
nohup java -javaagent:applicationinsights-agent-3.0.0-PREVIEW.4.jar -jar mutualfund-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
echo 'Started Application'