package ex4;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("mailValidator")
public class MailValidator implements Validator {
  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
    String email = value.toString();
    boolean emailValid = email.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");

    if (!emailValid) throw new ValidatorException(new FacesMessage("invalid mail"));
  }
}
