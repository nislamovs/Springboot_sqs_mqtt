#!/usr/bin/env bash

aws --endpoint-url http://localhost:9324 sqs --profile localsqs send-message --queue-url http://localhost:9324/queue/default --message-body "Hello, queue!"