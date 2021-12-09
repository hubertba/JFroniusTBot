#!/bin/bash
nohup java -jar target/JFroniusTBot-0.0.1-SNAPSHOT.jar > JFroniusTBot.$(date '+%Y-%m-%d-%H-%M').log 2>&1 &
echo $! > jFroniusTBot.pid.file