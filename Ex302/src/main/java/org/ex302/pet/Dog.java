package org.ex302.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthday) {
        super(name, birthday);
    }
    public String guard(){
        return "我能警戒";
    }

    @Override
    public String shout() {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月d日");

        return "狗，名字："+this.getName()+"，生日："+this.getBirthday().format(formatter);

    }
}
