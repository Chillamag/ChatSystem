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

import java.io.*;
import java.util.HashMap;

public class User implements Serializable {
    
    private static final long serialVersionUID = 12345; // bare et eller andet nr.
    public String username; // studienummer
    public String email = "something@random.com";
    public long lastOnline;
    public String campusnetId; // campusnet database-ID
    public String study = "ukendt";
    public String firstname = "test";
    public String lastname = "testesen";
    public String password;
    public HashMap<String,Object> extraFields = new HashMap<>();
    
    public String toString(){ 
	return email;
    }
}
