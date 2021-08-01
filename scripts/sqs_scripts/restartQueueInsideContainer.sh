#!/usr/bin/env bash

docker exec -it sqs_queue sh -c "supervisorctl restart elasticmq"