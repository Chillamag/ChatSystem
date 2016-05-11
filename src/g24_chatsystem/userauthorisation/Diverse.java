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

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/

public class Diverse {
    public static String toString(Object obj) {
		StringBuilder sb = new StringBuilder();
		Class k = obj.getClass();
		sb.append(k.getSimpleName()).append(':');
		for (Field field : k.getFields()) try {
			Object value = field.get(obj);
			sb.append(' ').append(field.getName()).append('=').append('"').append(String.valueOf(value)).append('"');
		} catch (Exception e) { e.printStackTrace(); }
		return sb.toString();
	}
}
