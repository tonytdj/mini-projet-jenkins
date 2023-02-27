FROM httpd:latest
LABEL maintainer="Tony"
RUN apt-get update && apt-get upgrade -y && apt-get install git -y
EXPOSE 80
RUN rm -rf //usr/local/apache2/htdocs/*
RUN git clone https://github.com/tonytdj/mini-projet-jenkins.git /usr/local/apache2/htdocs
RUN apt-get remove git -y && apt-get autoremove -y
