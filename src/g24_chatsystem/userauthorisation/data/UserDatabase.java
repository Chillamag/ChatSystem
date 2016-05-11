/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.userauthorisation.data;

/**
 *
 * @author Magnus A. Nielsen
 */

import g24_chatsystem.userauthorisation.Diverse;
import g24_chatsystem.userauthorisation.Serialization;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class UserDatabase implements Serializable {
    
    private static final long serialVersionUID = 12345; 
    private static UserDatabase instance;
    private static final String SERIALIZED_FILE = "brugere.ser";
    private static final Path BACKUP_FILE = Paths.get("sikkerhedskopi");
    private static long fileLastSaved;
    
    public ArrayList<User> users = new ArrayList<>();
    public transient HashMap<String,User> usernameForUser = new HashMap<>();
    
    public static UserDatabase getInstance(){
        
        if (instance!=null) return instance;
        
        //
        return instance;
        //
    }
    
}
