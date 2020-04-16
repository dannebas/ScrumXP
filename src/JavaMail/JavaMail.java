
package JavaMail;
import info.Booking;

/**
 *
 * @author Stefan
 */
public class JavaMail {
    public static void main(String[] args) throws Exception {
        
        Booking book = new Booking();
        
        String recepient = book.collectMail();
        
        JavaMailUtil.sendMail(recepient);
    }
}
