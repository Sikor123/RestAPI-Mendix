package com.luv2code.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class Driver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ObjectMapper mapper = new ObjectMapper();

            Student theStudent = mapper.readValue(new File("data/sample-full.json") , Student.class);
            System.out.println(theStudent.getFirstName());
            System.out.println(theStudent.getLastName());
            System.out.println(theStudent.getId());
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }

    }

}