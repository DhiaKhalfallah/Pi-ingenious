/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobby.utils;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author Dhia
 */
public class Sms {
  
    public Sms() {
    }
    
    public void sendsms(int phoneNumber)
    {
          Twilio.init("AC92c9b81d75cf8392b7b58b2ef3bf3fcd", "e4f720c99355f186afb3a5e2fbabda46");
          Integer i = new Integer(phoneNumber);
          String tel = "+216"+String.valueOf(i);
System.out.println(tel);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(tel),
                new com.twilio.type.PhoneNumber("+3197010253846"),
                "Account logged in , if it wasn't you please check your security settings")
            .create();

        System.out.println(message.getSid());
    }
    
}
