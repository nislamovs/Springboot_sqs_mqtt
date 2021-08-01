#!/usr/bin/env bash

aws --endpoint-url http://localhost:9324 sqs --profile localsqs receive-message --queue-url http://localhost:9324/queue/default --wait-time-seconds 10