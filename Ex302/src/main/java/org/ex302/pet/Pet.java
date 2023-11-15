package org.ex302.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String name;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Pet(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String shout(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月d日");

        return "名字："+name+"，生日："+birthday.format(formatter);
    }

}
