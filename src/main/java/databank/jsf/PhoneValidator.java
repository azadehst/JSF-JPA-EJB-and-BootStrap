/********************************************************************************************************2*4*w*
 * File:  PhoneValidator.java Course Materials CST8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator<String> {

	// North American phone number pattern
	private static final Pattern PHONE_PATTERN = Pattern
			.compile("^(\\+\\d( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
	private static Matcher mat;

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

		if (value == null) {
			FacesMessage msg = new FacesMessage("Phone number should not be empty", "Invalid phone number format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
		mat = PHONE_PATTERN.matcher(value);
		if (value != null && mat.matches() == false) {
			FacesMessage msg2 = new FacesMessage("Phone number is incorrect", "Invalid email format.");
			msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg2);
		}
		//TODO 08 - Complete the Matching using the PHONE_PATTERN above.
		//You can use methods matcher and matches from PHONE_PATTERN.
		//If match fails, create a new FacesMessage(String, String) object.
		//Use proper error messages.
		//Set the severity of your FacesMessage to FacesMessage.SEVERITY_ERROR.
		//Finally, throw an exception with the FacesMessage in it.
		//To know what exception should be thrown, look at the signature of this method.

	}

}
