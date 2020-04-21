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
    //My accountSid, used for the api.
    private String accountSid = "AC04c374ea758f4d4b18b53972028390a2";
    private String authToken = "";

    public NotificationHandler(String accountSid, String authToken)
    {
        this.accountSid = accountSid;
        this.authToken = authToken;
    }
    
    public void sendSMS(String textMessage, String toNumber)
    {
        Twilio.init(accountSid, authToken);
       
        //Create the sms using the twilio rest api.
        try
        {
	 Message message = Message.creator(
	                new PhoneNumber(toNumber),  // To number
	                new PhoneNumber("+18504033759"),  // From number
	                textMessage // SMS body
	            ).create();
		 
            System.out.println(message.getSid());
        } catch (final ApiException e)
        {
            System.err.println(e);
        }
    }
}
