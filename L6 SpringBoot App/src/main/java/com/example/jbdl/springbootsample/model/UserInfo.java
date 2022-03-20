package com.example.jbdl.springbootsample.model;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserInfo {

    double id = Math.random();
    String name;


  public  UserInfo(String name){
        this.name = name;
  }

  public double getId(){
      return this.id;
  }
}
