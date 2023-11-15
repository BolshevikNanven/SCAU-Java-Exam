package org.ex301.pet;

import java.time.LocalDate;

public class Cat extends Pet{

    public Cat(String name, LocalDate birthday) {
        super(name, birthday);
    }

    public String climbTree(){
        return "我会爬树";
    }

}
