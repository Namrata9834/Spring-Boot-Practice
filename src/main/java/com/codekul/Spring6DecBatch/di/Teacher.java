package com.codekul.Spring6DecBatch.di;

public class Teacher {

    private Principle principle;

    public Teacher(){}
   //DI thr the constructor
    public Teacher(Principle principle ){

       this.principle = principle;
   }


    //DI thr the setter method
    public void setPrinciple(Principle principle) {
        this.principle = principle;
    }
    public void show(){
        principle.display();
    }

}
