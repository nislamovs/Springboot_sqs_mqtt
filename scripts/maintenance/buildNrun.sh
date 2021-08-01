#!/usr/bin/env bash

# export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export JAVA_HOME=/usr/lib/jvm/java-15-oracle

#Cleanup
./stop_n_remove_containers.sh ;
./docker_total_cleanup.sh ;

#Stop on error
set -e ;

#Go to project root folder
cd ../.. ;

# #Build sqs_consumer microservice and its docker image
# cd sqs_consumer ;
# ./gradlew clean build docker -x test;
# cd .. ;

#Build sqs_producer microservice and its docker image
cd sqs_producer ;
./gradlew clean build docker -x test;
cd ..

#Launch all docker chain
docker-compose up ;
