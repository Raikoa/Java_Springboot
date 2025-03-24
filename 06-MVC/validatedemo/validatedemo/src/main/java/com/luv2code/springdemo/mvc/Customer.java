package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.anno.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String code;
    private String firstName;
    @Max(value = 10, message = "must be smaller than 10")
    @Min(value = 0, message = "must be greater than 0")
    @NotNull(message = "is required")
    private Integer passes;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName="";
    @Pattern(regexp = "^[A-Za-z0-9]{5}", message = "only 5")
    private String postal;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }
}
