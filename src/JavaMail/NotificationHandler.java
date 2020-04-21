package JavaMail;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Viggo
 */
public class NotificationHandler 
{
    private String accountSid = "AC04c374ea758f4d4b18b53972028390a2";
    private String authToken = "e5e2787ea7ec41e93a70cde0ac77a1c9";
    
    public NotificationHandler(String accountSid, String authToken)
    {
        this.accountSid = accountSid;
        this.authToken = authToken;
    }
    
    public void sendSMS()
    {
        Twilio.init(accountSid, authToken);
       
        try
        {
	 Message message = Message.creator(
	                new PhoneNumber("+46 72-534 43 68"),  // To number
	                new PhoneNumber("+18504033759"),  // From number
	                "Hello world!"                    // SMS body
	            ).create();
		 
            System.out.println(message.getSid());
        } catch (final ApiException e)
        {
            System.err.println(e);
        }
    }
}
