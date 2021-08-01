FROM toke/mosquitto:latest

COPY ./configs/mosquitto.passwd /mosquitto/config/mosquitto.passwd
COPY ./configs/mosquitto.conf /mosquitto/config/mosquitto.conf
#COPY docker-entrypoint.sh /

#ENTRYPOINT ["sh", "./docker-entrypoint.sh"]
#
#CMD ["/usr/sbin/mosquitto", "-c", "/mosquitto/config/mosquitto.conf"]
