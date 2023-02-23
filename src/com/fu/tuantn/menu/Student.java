/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.tuantn.menu;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author NTuanT
 */
public class Student {
    //fields
    String stuID, firstName, lastName, gender;
    Date DOB;
    String email, phone;
    boolean canDelete = true;
    
    //constructors

    public  Student() {
        stuID = "";
        firstName = "";
        lastName = "";
        gender = "";
        email = "";
        phone = "";
        DOB = new Date();
       
    }

    public Student(String stuID, String firstName, String lastName, String gender, Date DOB, String email, String phone) {
        this.stuID = stuID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.DOB = new Date();
        
    }
    
    //getters - setters

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

}
    
        //Validation
    class BooleanDateDemo{
        //Testing whether the year y is leap or not
        public static boolean isLeap(int y){
            boolean result = false;
            if((y%400==0)||((y%4==0) && (y%100!=0))) result=true;
            return result;
        }
        //Testing whether the y,m,d is valid date value or not
        public static boolean valid(int y, int m, int d){
            if(y<0 || m<0 || m>12 || d<0 || d>31) return false;
            int maxD=31;
            if(m==4 || m==6 || m==9 || m==11) maxD=30;
            else if(m==2){
                if(isLeap(y)) maxD=29;
                else maxD = 28;
            }
            return d<=maxD;
        }   
        //convert y/m/d or y-m-d to mili secs (long number)
        public static long toDate(String ymd){
            StringTokenizer stk = new StringTokenizer(ymd,"/");
            int y = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            if(!valid(y,m,d)) return -1;
            Calendar cal = Calendar.getInstance();
            cal.set(y, m-1, d); //month number 0...11
            long t = cal.getTime().getTime();
            return t;
        }
}
