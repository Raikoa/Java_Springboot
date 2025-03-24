package com.luv2code.SpringDEMO.Common;

public class Swimcoach implements Coach{
    public Swimcoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {


        return "Frogger";
    }
}
