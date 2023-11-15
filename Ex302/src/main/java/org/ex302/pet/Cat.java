package org.ex302.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cat extends Pet{

    public Cat(String name, LocalDate birthday) {
        super(name, birthday);
    }

    public String climbTree(){
        return "我会爬树";
    }

    @Override
    public String shout() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月d日");

        return "猫，名字："+this.getName()+"，生日："+this.getBirthday().format(formatter);

    }

}
