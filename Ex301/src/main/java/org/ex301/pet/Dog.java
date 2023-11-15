package org.ex301.pet;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthday) {
        super(name, birthday);
    }
    public String guard(){
        return "我能警戒";
    }
}
