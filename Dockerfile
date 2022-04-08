FROM php:7.4.28-apache
RUN docker-php-ext-install mysqli pdo pdo_mysql && docker-php-ext-enable pdo_mysql 
WORKDIR /var/www/html/
COPY . .
EXPOSE 80
