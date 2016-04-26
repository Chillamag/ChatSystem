/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server;

import g24_chatsystem.server.UI.ChatUser;
import g24_chatsystem.server.UI.ServerUI;
import java.util.Scanner;

/**
 *
 * @author Magnus A. Nielsen
 */

//import

public class ServerTUI implements ServerUI {
    
    Scanner scanner;
    String userInput = "";
    boolean loggetInd = false;
    boolean serverRunning = false;
        
    public ServerTUI(ChatUser user) {
        this.scanner = new Scanner(System.in);
    }
        
    @Override
    public void start() throws Exception {
        String powerServer = "1";
	String userLogin = "2";
	String exitTUI = "3";
	boolean tuiRunning = true;
	        
        printIntroduction();
        while (tuiRunning){
            printHeader();
            userInput = scanner.nextLine();
            
            if (userInput.equals(powerServer)){
                
                if(!serverRunning){
                    System.out.println("Starting server..\n");
                    serverRunning = true;
                }else{
                    System.out.println("Stopping server..\n");
                    serverRunning = false;
                }
                                
            }else if(userInput.equals(userLogin)){
                //Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
                
            }else if(userInput.equals(exitTUI)){
                
                if(serverRunning){
                    System.out.println("Server is still running..\n");
                    //printHeader();
                }else{
                    System.out.println("Shutting down TUI..\n");
                    System.exit(0);
                }
            }else{
                System.out.println("Not valid input: " + userInput + "\n");
            }
        }
    }

    private void printIntroduction() {
        System.out.println("Wellcome to our server TUI");
    }

    public void printHeader() {
        if(!serverRunning){
            System.out.println("1 - Start Server");
        }else{
            System.out.println("1 - Stop Server");
        }
        if(loggetInd == false){
            System.out.println("2 - Login");
        }else{
            System.out.println("2 - Log Out");
        }
        System.out.println("3 - Exit TUI");
        System.out.print("Enter: ");
    }
    
}
