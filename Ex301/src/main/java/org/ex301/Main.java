package org.ex301;

import org.ex301.pet.Cat;
import org.ex301.pet.Dog;
import org.ex301.pet.Pet;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pet pet=new Pet("Alan", LocalDate.of(2016,5,18));
        System.out.println("Pet：");
        System.out.println(pet.shout());

        Cat cat=new Cat("Tom",LocalDate.of(2020,7,13));
        System.out.println("Cat:");
        System.out.println(cat.shout());
        System.out.println(cat.climbTree());

        Dog dog=new Dog("Goofy",LocalDate.of(1932,8,20));
        System.out.println("Dog:");
        System.out.println(dog.shout());
        System.out.println(dog.guard());
    }
}
