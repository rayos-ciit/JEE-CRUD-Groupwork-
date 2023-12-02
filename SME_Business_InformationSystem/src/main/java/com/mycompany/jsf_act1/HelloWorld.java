/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsf_act1;

//import javax.annotation.ManagedBean;

import javax.faces.bean.ManagedBean;
@ManagedBean(name = "helloWorld", eager = true)

//@ManagedBean("helloWorld")

public class HelloWorld {
   public HelloWorld() {
      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World CIIT JSF!";
   }

}
