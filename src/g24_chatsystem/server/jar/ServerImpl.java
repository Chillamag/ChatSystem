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

import java.rmi.Naming;
import g24_chatsystem.server.UI.ServerTUI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImpl extends UnicastRemoteObject implements ChatUser{
    
    ChatLogic chatlogic;
    
    public ServerImpl() throws RemoteException{
        chatlogic = new ChatLogic();
    }
    
    @Override
    public void userAdd (String data) throws RemoteException{
        chatlogic.userAdd(data);
    }
    
    @Override
    public void userRemove (String data) throws RemoteException{
        chatlogic.userRemove(data);
    }
    
    @Override
    public void tellEveryone(String message) throws RemoteException{
        chatlogic.tellEveryone(message);
    }
        
    
}
