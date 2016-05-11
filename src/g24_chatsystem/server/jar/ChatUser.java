/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.jar;

/**
 *
 * @author Magnus A. Nielsen
 */

//import

public interface ChatUser extends java.rmi.Remote {
    void userAdd(String data)           throws java.rmi.RemoteException;
    void userRemove (String data)       throws java.rmi.RemoteException;
    void tellEveryone(String message)   throws java.rmi.RemoteException;
    
}
