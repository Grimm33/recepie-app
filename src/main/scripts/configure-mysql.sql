# Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql
# disable mysqld.exe from task manager if port 3306 is already in use

# Connect to mysql and run as root user
# Create Databases
create database sfg_dev;
create database sfg_prod;

# Create Database service accounts
create user 'sfg_dev_user'@'localhost' identified by 'grimm';
create user 'sfg_prod_user'@'localhost' identified by 'grimm';
create user 'sfg_dev_user'@'%' identified by 'grimm';
create user 'sfg_prod_user'@'%' identified by 'grimm';

# Database grants
grant select on sfg_dev.* to 'sfg_dev_user'@'localhost';
grant insert on sfg_dev.* to 'sfg_dev_user'@'localhost';
grant delete on sfg_dev.* to 'sfg_dev_user'@'localhost';
grant update on sfg_dev.* to 'sfg_dev_user'@'localhost';
grant select on sfg_prod.* to 'sfg_prod_user'@'localhost';
grant insert on sfg_prod.* to 'sfg_prod_user'@'localhost';
grant delete on sfg_prod.* to 'sfg_prod_user'@'localhost';
grant update on sfg_prod.* to 'sfg_prod_user'@'localhost';
grant select on sfg_dev.* to 'sfg_dev_user'@'%';
grant insert on sfg_dev.* to 'sfg_dev_user'@'%';
grant delete on sfg_dev.* to 'sfg_dev_user'@'%';
grant update on sfg_dev.* to 'sfg_dev_user'@'%';
grant select on sfg_prod.* to 'sfg_prod_user'@'%';
grant insert on sfg_prod.* to 'sfg_prod_user'@'%';
grant delete on sfg_prod.* to 'sfg_prod_user'@'%';
grant update on sfg_prod.* to 'sfg_prod_user'@'%';