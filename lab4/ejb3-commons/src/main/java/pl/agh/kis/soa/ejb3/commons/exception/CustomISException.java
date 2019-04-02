package pl.agh.kis.soa.ejb3.commons.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class CustomISException extends RuntimeException {

  public CustomISException(String message) {
    super(message);
  }
}
