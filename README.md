# Connections
### Assingment 2:
### Singleton design pattern.

- In connection class
 the attributes arraylist static to can do reference from statics methods and the count is to know 
 how many connection is on, because its illegal more than 3 connections on, (the count and arraylist 
 are attributes to the class not obj).
 connectiontype to every object and isConected the same to know the the connection is on or realese in the next F.

- In Connection getInstance
 why (throws exeption)? in java if there is a function doing exeption we must show the type of exeption by throws and the type
 like what I did, I used general exeption (but I can do class inheritance from exeption).
 this function when he have connection he check  If the connection already existed, return the old connection
 by the for loop do iteration and If the connection doesn't exist, create new connection, after that if there is 3 con.
 he dont do new one and do exeption, but if there is no 3 con. he do new con. and the count up one. 

- In send
 not static (not function in class, its to object) to send message from protocole if its connected he send the message 
 if not he its not connected.

- In release
 he took connection and check if the connection exist, if the connection was done he delete it from connections and 
 do theconnection is false after that he cant send from protocole and the count down one and return true, if not
 return false.

- In ArrayList<String> getCurrentConnections
 he get the exist connections, he trace on con. one by one and converting it to string then to arraylist string.

- function doing throws to exeption 
 and any function have throws should use try and catch.

#### Note: the last comment in the code have exception..
 
   
 
