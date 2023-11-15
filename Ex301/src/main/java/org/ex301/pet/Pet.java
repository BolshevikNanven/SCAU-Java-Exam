package org.ex301.pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Pet {
    private String name;
    private LocalDate birthday;

    public Pet(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String shout(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年M月d日");

        return "名字："+name+"，生日："+birthday.format(formatter);
    }

}
