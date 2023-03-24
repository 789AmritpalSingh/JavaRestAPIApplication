package com.amrit.javarestapiwithspring_springboot_hibernate.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name){
        this.name = name;
    }

    public Name getName(){
        return name;
    }

    public String toString(){
        return "PersonV2 [name=" + name + "]";
    }
}
