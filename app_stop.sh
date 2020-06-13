#!/usr/bin/env bash
echo 'Stopping Application'
kill $(ps aux | grep 'mutualfund-0.0.1-SNAPSHOT.jar' | grep -v grep | awk '{print $2}')
echo 'stopped Application'