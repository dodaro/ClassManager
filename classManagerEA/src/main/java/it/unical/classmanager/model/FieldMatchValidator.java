package it.unical.classmanager.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
    	boolean toReturn = false;
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
            
            toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);        }
        catch (final Exception ignore)
        {
            // ignore
        }
        //If the validation failed
        if(!toReturn) {
            context.disableDefaultConstraintViolation();
            //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
            context.buildConstraintViolationWithTemplate("Passwords and confirm must match").addPropertyNode(firstFieldName).addConstraintViolation();
        }
        return toReturn;
    }

}
