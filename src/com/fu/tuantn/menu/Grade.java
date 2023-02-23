/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.tuantn.menu;

import java.util.Comparator;

/**
 *
 * @author NTuanT
 */
public class Grade {
    //fields
    Student std;
    Subject sub;
    double lab, test, FE;
    
    //constructors

    public Grade() {
        lab = 0;
        test = 0;
        FE =0;
        std = new Student();
        sub = new Subject();
    }

    public Grade( Student std, Subject sub, double lab, double test, double FE) {
        this.std = std;
        this.sub = sub;
        this.lab = lab;
        this.test = test;
        this.FE = FE;
    }
    
    //getters - setters

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public double getLab() {
        return lab;
    }

    public void setLab(double lab) {
        this.lab = lab;
    }

    public double getTest() {
        return test;
    }

    public void setTest(double test) {
        this.test = test;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }
    
    //Others Functions
    //Hàm này để tính trung bình môn
    public double average(){
        return 0.3*lab + 0.3*test + 0.4*FE; 
               
    }
    
    
    //Sort -> Comparator (a-z)
    public static Comparator<Grade>  byStudentName = (Grade graden1, Grade graden2) -> {
        {
            if (graden1.std.lastName.compareTo(graden2.std.lastName)<0)
                return -1;        
            return 0;
        }
    };
    
    //public static Comparator<Object> nameCompare = new Comparator<Object>
    public static Comparator<Grade>  bySubjectName = (Grade grades1, Grade grades2) -> {
        {
            if (grades1.sub.subName.compareTo(grades2.sub.subName)<0)
                return -1;        
            return 0;
        }
    };
    
        }