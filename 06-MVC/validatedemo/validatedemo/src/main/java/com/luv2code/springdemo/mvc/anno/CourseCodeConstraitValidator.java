package com.luv2code.springdemo.mvc.anno;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraitValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode course) {
        coursePrefix = course.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(code != null){
            result = code.startsWith(coursePrefix);
        }else{
            result = true;
        }
        return result;
    }
}
