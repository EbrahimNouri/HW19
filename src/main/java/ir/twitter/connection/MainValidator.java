package ir.twitter.connection;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MainValidator {

    private static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();

    public static Validator getValidatorFactory() {
        return VALIDATOR_FACTORY.getValidator();
    }
}
