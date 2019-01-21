package com.spring.test;

public class Travel {
    
    Vehicle v;
    public void setV(Vehicle v){
        this.v=v;
    }
     
    public void startJourney(){
        v.start();
    }
 
}
