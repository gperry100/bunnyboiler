FROM jeanblanchard/busybox-java:7
MAINTAINER gil <gil_perry@hotmail.com>

COPY bunny-boiler-1.0.jar .
COPY start.sh .
#COPY bunnyorderservice.properties.erb /build/bunnyorderservice.properties.erb
#COPY start.sh start.sh
RUN chmod +x start.sh
CMD ["sh","start.sh"]

