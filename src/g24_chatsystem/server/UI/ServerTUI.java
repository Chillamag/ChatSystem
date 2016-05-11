/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.server.UI;

import g24_chatsystem.server.jar.ServerImpl;
import g24_chatsystem.server.jar.ChatUser;
import g24_chatsystem.server.jar.ServerImpl;
import g24_chatsystem.server.UI.ServerUI;
//import g24_chatsystem.userauthorisation.data.User;
import brugerautorisation.data.Bruger;
//import g24_chatsystem.userauthorisation.rmi.UserAdmin;
import brugerautorisation.transport.rmi.Brugeradmin;
import g24_chatsystem.server.ServerStart;
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Magnus A. Nielsen
 */

//import

public class ServerTUI implements ServerUI {
    ChatUser chat;
    Scanner scanner;
    String userInput = "";
    boolean loggedIn = false;
    static boolean serverRunning = false;
    static boolean chatIsOn = false;
    String firstName = "";
    String lastName = "";
    static String serverStatus = "off";
    String chatStatus = "off";
        
    public ServerTUI(ChatUser user) {
        this.chat = user;
        this.scanner = new Scanner(System.in);
    }
        
    @Override
    public void start() throws Exception {
        
        String startServer = "/server.start";
        String stopServer = "/server.stop";
	String userLogIn = "/login";
        String userLogOut = "/logout";
        String chatOn = "/chat.on";
        String chatOff = "/chat.off";
        String status = "/status";
	String exitTUI = "/exit";
        String help = "/help";
        boolean tuiRunning = true;
	        
        printIntroduction();
        while (tuiRunning){
            printHeader();
            userInput = scanner.nextLine();
            
            if (userInput.equals(startServer)){
                
                if(!serverRunning && loggedIn){
                    System.out.println("\nStarting server..\n");
                    //serverRunning = true;
                    //serverStatus = "on";
                    //ServerImpl ServImp = new ServerImpl();
                    //ServImp.run();
                    //ServerImpl.serverThreadRunning = true;
                    
                    Thread starter = new Thread(new ServerStart());
                    starter.start();
                    
                                                            
                }else if(serverRunning && loggedIn){
                    System.out.println("\nServer already running..\n");
                    
                }else{
                    System.out.println("\nYou need to be logged in to start the server..\n");
                }
            }else if(userInput.equals(stopServer)){
                
                if(serverRunning && loggedIn){
                    System.out.println("\nStopping server..\n");
                    serverRunning = false; 
                    serverStatus = "off";
                    //ServerImpl.serverThreadRunning = false;
                    
                    try {
                        Thread.sleep(5000);
                    }catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
                    
                }else if(!serverRunning && loggedIn){
                    System.out.println("\nServer not running..\n");
                    
                }else{
                    System.out.println("\nYou need to be logged in to stop the server..\n");
                }
            
            }else if(userInput.equals(userLogIn)){
                Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
                                
                if(!loggedIn){                
                    System.out.println("\nUsername: ");
                    userInput = scanner.nextLine();
                    String usernameInput = userInput;
                    
                    System.out.println("\nPassword: ");
                    userInput = scanner.nextLine();
                    String passwordInput = userInput;
                    
                    try{
                        Bruger b = ba.hentBruger(usernameInput, passwordInput);
                                
                        System.out.println("\nLogged in as: " + b.fornavn + " " + b.efternavn + ".\n");
                        loggedIn = true;
                        firstName = b.fornavn;
                        lastName = b.efternavn;
                                  
                    }catch(IllegalArgumentException e){
                        System.out.println("\nWrong username or password..\n");
                    }
                   

                }else{
                    System.out.println("\nYou are already logged in, " + firstName + "!\n");
                }
            }else if(userInput.equals(userLogOut)){
                
                if(loggedIn){
                    System.out.println("\nLogged out..\n");
                    firstName = "";
                    loggedIn = false;
                }else{
                    System.out.println("\nYou are not logged in..\n");
                }
            }else if(userInput.equals(chatOn)){
                
                if(!chatIsOn && loggedIn){
                    System.out.println("\nChat surveillance activated..\n");
                    chatIsOn = true;
                    chatStatus = "on";
                }else if(chatIsOn && loggedIn){
                    System.out.println("\nChat surveillance is already turned on..\n");
                }else{
                    System.out.println("\nYou need to be logged in to activate the chat surveillance..\n");
                }
                
            }else if(userInput.equals(chatOff)){
                
                if(chatIsOn && loggedIn){
                    System.out.println("\nChat surveillance deactivated..\n");
                    chatIsOn = false;
                    chatStatus = "off";
                }else if (!chatIsOn && loggedIn){
                    System.out.println("\nChat surveillance is already off..\n");
                }else{
                    System.out.println("\nYou need to be logged in to deactivate the chat surveillance..\n");
                }
                
            }else if(userInput.equals(exitTUI)){
                
                if(serverRunning){
                    System.out.println("\nServer is still running..\n");
                    //printHeader();
                }else{
                    System.out.println("\nShutting down TUI..\n");
                    System.exit(0);
                }
                
            }else if(userInput.equals(help)){
                
                help();
                
            }else if(userInput.equals(status)){
                
                showStatus();
                
            }else{
                System.out.println("\nNot valid input: " + userInput);
                System.out.println("Try '/help' for help..\n");
            }
        }
    }

    private void printIntroduction() {
        System.out.println("Wellcome to our server TUI, made by g24\n");
    }

    public void printHeader() {
        System.out.print("Enter: ");
    }
    
    public void help(){
        System.out.println("\n/server.start = Start server");
        System.out.println("/server.stop = Stop server");
        System.out.println("/login = Log in");
        System.out.println("/logout = Log out");
        System.out.println("/chat.on = Turn chat messages on");
        System.out.println("/chat.off = Turn chat messages off");
        System.out.println("/status = Shows the status of server and chat");
        System.out.println("/exit = Exit TUI\n");
        //System.out.print("Enter: ");
    
    }
    
    public void showStatus(){
        if(loggedIn){
            System.out.println("\nLogged in as: " + firstName + " " + lastName);
        }else{
            System.out.println("\nNot logged in");
        }
        System.out.println("Server: " + serverStatus);
        System.out.println("Chat surveillance: " + chatStatus);
        
    }
    
    public void old(){
    if(!serverRunning){
            System.out.println("/server.start");
        }else{
            System.out.println("/server.stop");
        }
        if(loggedIn == false){
            System.out.println("/login");
        }else{
            System.out.println("2 - Log Out");
        }
        System.out.println("3 - Exit TUI");
        System.out.println("4 - Chat On");
        System.out.print("Enter: ");
    }
    
}
