package javaapplication1;
import java.util.ArrayList;

enum ConnectionProtocol{
    SSH,HTTP,TELNET,SCP,FTP;
}

public class Connection {
    static private ArrayList<Connection> connections = new ArrayList<Connection>();
    static private int count = 0;
    private String connectionType;
    private boolean isConnected = false;
    private Connection(String type){
        this.connectionType = type;
        this.isConnected = true;
    }
    
    public static Connection getInstance(ConnectionProtocol T) throws Exception{
        // If the connection already existed, return the old connection.
        for(Connection t:connections){
            if(t.connectionType.equals(T.toString())){
                return t;
            }
        }
        // If the connection doesn't exist, create new connection
        if(count == 3){
            // Limit connections by 3
            throw new Exception("Can't create more than 3 connections");
        }else{
            // If there is a room for a connection, create one.
            Connection newObj = new Connection(T.toString());
            connections.add(newObj);
            count++;
            return newObj;
        }
    }
    
    public void send(String msg){
        if(isConnected){
        System.out.println("Sending ["+msg+"] vi "+this.connectionType+" protocol.");
        }else{
            System.out.println("The connection through "+this.connectionType+" protocol is released.");
        }
    }
    
    public static boolean release(ConnectionProtocol t){
        for(Connection currCon:connections){
            if(currCon.connectionType.equals(t.toString())){
                connections.remove(currCon);
                currCon.isConnected = false;
                count--;
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<String> getCurrentConnections(){
        ArrayList<String> t = new ArrayList<String>();
        for(Connection cCurr: connections){
            t.add(cCurr.connectionType);
        }
        return t;
    }
    
    public static void main(String[] args){
        try{
            Connection telnetConnection = Connection.getInstance(ConnectionProtocol.TELNET);
            Connection telnetConnection2 = Connection.getInstance(ConnectionProtocol.TELNET);
            Connection sshConnection = Connection.getInstance(ConnectionProtocol.SSH);
            Connection httpConnection = Connection.getInstance(ConnectionProtocol.HTTP);
//            Connection scpConnection = Connection.getInstance(ConnectionProtocol.SCP);
            
            boolean isReleased = Connection.release(ConnectionProtocol.TELNET);
            
            Connection ftpConnection = Connection.getInstance(ConnectionProtocol.FTP);
            
            ArrayList<String> connections = Connection.getCurrentConnections();
            
            telnetConnection.send("My message");
            
            sshConnection.send("My message");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
