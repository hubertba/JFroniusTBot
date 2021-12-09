#!/bin/bash
nohup java -jar /Users/admin/JFroniusTBot/JFroniusTBot-0.0.1-SNAPSHOT.jar > /Users/admin/JFroniusTBot/JFroniusTBot.$(date '+%Y-%m-%d-%H-%M').log 2>&1 &
echo $! > /Users/admin/JFroniusTBot/jFroniusTBot.pid.file