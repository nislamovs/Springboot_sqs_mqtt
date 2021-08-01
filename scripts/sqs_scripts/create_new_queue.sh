#!/usr/bin/env bash

aws --endpoint-url http://localhost:9324 sqs --profile localsqs create-queue --queue-name newqueue1