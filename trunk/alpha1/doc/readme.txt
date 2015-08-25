1.REQUITMENTS	
Tomcat 5.*
MySQL 5.*
JDK 1.5.*

2.DEPROY
find the two property files "/WEB-INF/classes/net/ziqiang/movie/dao/ibatis/movie/conf/db.properties" and "/WEB-INF/classes/net/ziqiang/movie/dao/ibatis/passport/conf/db.properties",they look like this
---------------------------------------------
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/movie
username=root
password=yejinhui
---------------------------------------------
change the username and password as your own mysql server
copy the movie2 directory to $TOMCAT_HOME/webapp

3.RUN
start the tomcat server and open "http://127.0.0.1:8080/movie2/loginForm.do" in web browser
