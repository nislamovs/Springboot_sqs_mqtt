# Springboot_sqs_mqtt
Springboot sqs mqtt example

### Stack:

- Java 15, Springboot 2, AWS SQS queue
- Swagger, webflux
- Spring SQS, MQTT client
- Docker, Docker-compose

### Build:



### AWS CLI scripts:

- Go to `scripts/sqs_scripts` and there You will see scripts for interactions with sqs queue.
  Before You will start,  add the following text to `~/.aws/credentials`:
```aidl
[localsqs]
aws_access_key_id=notValidKey
aws_secret_access_key=notValidSecret
region=eu-central-1
``` 

### MQTT

- Installation of MQTT explorer: `sudo snap install mqtt-explorer`

---

|  URL                    |  Description           |
| ----------------------- | ---------------------- |
| http://localhost:8081   | SQS producer           |
| http://localhost:8082   | SQS consumer           |
| http://localhost:9324   | SQS interface (?)      |
| http://localhost:9325   | SQS queue UI           |
| http://localhost:1883   | MQTT server            |

