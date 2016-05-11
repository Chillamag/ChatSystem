/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.jar;

/**
 *
 * @author Magnus A. Nielsen
 */

import g24_chatsystem.server.jar.ServerStart;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server_Main {
    
    
    
    public static void main(String args[]) {
        Thread starter = new Thread(new ServerStart());
        starter.start();
        System.out.println("Server started... \n");
    }
    
    
    
}
