/*
 *  Chat System
 *  Lavet af Gruppe 24 - DTU 2016
 *  --------------------
 *  Bao Duy Nguyen, s144880
 *  Magnus Andrias Nielsen, s141899
 *  --------------------
 */
package g24_chatsystem.userauthorisation;

/**
 *
 * @author Magnus A. Nielsen
 */

import java.io.*;

public class Serialization {
    
    public static void save(Serializable obj, String filename) throws IOException{
        
        System.out.println("Saving file "+ filename);
	FileOutputStream datastream = new FileOutputStream(filename);
	ObjectOutputStream objectstream = new ObjectOutputStream(datastream);
	objectstream.writeObject(obj);
	objectstream.close();
        
    }
    
    public static Serializable get(String filename) throws Exception{
        
        System.out.println("Loading "+ filename);
	FileInputStream datastream = new FileInputStream(filename);
	ObjectInputStream objectstream = new ObjectInputStream(datastream);
	Serializable obj = (Serializable) objectstream.readObject();
	objectstream.close();
        return obj;
    }
    
}
