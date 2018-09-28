FROM java:8
VOLUME /tmp
ADD cooperation-0.0.1-SNAPSHOT.jar cooperation.jar
RUN bash -c 'touch /cooperation.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /cooperation.jar" ]