package com.axxes.testing.mocking;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Greeter {
    public String greet(String... names){
        if(names == null) {
            return "Hello, there";
        }
        if (names.length ==1) {
            return handleSingleName(names[0]);
        }
       return "Hello, " + names[0] + " and " + names[1];
    }

    public String handleSingleName(String name){
        if(isUppercase(name)){
            return "HELLO, " + name;
        }
        return "Hello, "+ name;
    }
    boolean isUppercase(String name){
        return name.toUpperCase().equals(name);
    }
}
