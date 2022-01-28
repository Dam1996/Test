FROM tomcat:8-alpine
LABEL developer="Javier Skieba"
ADD /target/Seguridad-1.0.0.war  /usr/local/tomcat/webapps/
EXPOSE 9090
CMD ["catalina.sh","run"]
