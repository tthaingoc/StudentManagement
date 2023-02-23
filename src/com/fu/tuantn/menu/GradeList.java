/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.tuantn.menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NTuanT
 */
public class GradeList extends ArrayList<Grade>{ // methods using this. to call constructors
    //fields
//    ArrayList<Grade> arrGrade = new ArrayList<>();
    StudentList stdList;
    SubjectList subList;

    public GradeList(StudentList stdList, SubjectList subList) {
        this.stdList = stdList;
        this.subList = subList;
    }
    
//Others Functions
         /* StudentList stdList;
          SubjectList subList;*/
private int search (String stdID, String subID) {
    
    for(int i=0; i<this.size(); i++) 
                {
			if(this.get(i).std.stuID.equalsIgnoreCase(stdID) && 
                                this.get(i).sub.subID.equalsIgnoreCase(subID))
				return i;
		}
		return -1; 
} 


//Hàm này để tìm kiếm subject id trong list grade
private int searchSubject (String subID){
    for (int i = 0 ; i < subList.arrSub.size(); i++)
    {
        if(subList.arrSub.get(i).getSubID().equalsIgnoreCase(subID))
            return i;
    }
    return -1;

}

//Hàm này để tìm kiếm student id trong list grade
private int searchStudent (String stdID){
   
    
    for (int i = 0 ; i < stdList.arrStu.size(); i++)
    {
      
        if(stdList.arrStu.get(i).getStuID().equalsIgnoreCase(stdID))
            return i;
    }
    return -1;

}

//Add New Grade
public void addNewGrade(){
    String stdID, subID;
    double lab, test, FE;
    int stdPos = -1, subPos=-1, gradePos=-1;
    
    Scanner sc = new Scanner(System.in);
             
            
    
        do{
            System.out.println("Enter ID to search: ");
            sc = new Scanner(System.in);
            stdID = sc.nextLine();
            
            stdPos = searchStudent(stdID);
        }while(stdPos<0);
           do{
               System.out.println("Enter Subject ID to search");
               sc = new Scanner(System.in);
               subID = sc.nextLine();
               
               subPos = searchSubject(subID);
           }while(subPos<0);     
           
           gradePos = this.search(stdID, subID); //Search this list
           if(gradePos>=0) System.out.println("This grade existed!");
           
                   else{
            System.out.println("Enter LAB grade: ");
            lab = sc.nextDouble();
            while(lab<0 || lab>10){
                System.out.println("Lab = [0-10]");
                lab = sc.nextDouble();
            } System.out.println("Inpputed !");
            
            System.out.println("Enter TEST grade: ");
            test = sc.nextDouble();
            while(test<0 || test > 10){
                System.out.println("Test = [0-10]");
                test = sc.nextDouble();
            } System.out.println("Inputted !");
            
            
            System.out.println("Enter Final Exam grade: ");
            FE = sc.nextDouble();
            while(FE<0 || FE>10){
                System.out.println("FE = [0-10]");
                FE = sc.nextDouble();
            } System.out.println("Inputted !");
                   
            //Grade addGrade = new Grade(stdList., subList.arrSub.get(subPos), lab, test, FE);
            Grade addgrade = new Grade(stdList.arrStu.get(stdPos), subList.arrSub.get(subPos), lab, test, FE);
            this.add(addgrade);
            stdList.arrStu.get(stdPos).canDelete=false;
            subList.arrSub.get(subPos).canDelete=false;
            System.out.println("A new Grade have been added! ");
            System.out.println("Size " + this.size());
            
            }           
          
}

//public void display(){
//    for (Grade grade : arrGrade) {
//        System.out.println(grade.toString());
//        
//    }
//}

//Print Reports
public void printStudentReport(){
    String stdID;
    //Student stu;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Student ID: ");
    sc = new Scanner(System.in);
    stdID = sc.nextLine();
    int gradePos = searchStudent(stdID);
    
    if(gradePos<0) System.out.println("No Result !");
    
    else{
        System.err.println("Student ID: " +stdID);
        
        Student st = this.get(gradePos).std;
        System.err.println("Student Name: "+st.lastName+" "+st.firstName);
        System.out.format("|   No.                |   Subject Name                     |  Average          ");
        System.out.println( "|    Status        |");
        System.out.format("|-------|--------------------|----------|--------------|%n");
        int count=1;
        this.sort(Grade.bySubjectName);
        for(Grade g : this){
            if(stdID.equalsIgnoreCase(g.std.stuID)){
                double avg = g.average();
                    String status;
                    if(avg>=4) status="Pass";
                    else status="Not Pass";
                    String leftAlignFormat = "| %8d | %-10s | %-10.1f | %-10s |";
                {
                System.out.format(leftAlignFormat,count, g.sub.subName, avg, status);
                }
        
                    
                count++;
            }
        }
    }
    
}

public void printSubjectReport(){
    String subID;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Subject ID: ");
    sc = new Scanner(System.in);
    subID = sc.nextLine();
    
    int gradePos = searchSubject(subID);
    
    
    if(gradePos<0) System.out.println("No report can be supported !");
    else{

        System.err.println("Subject ID: "+subID);
        
        Subject sub = this.get(gradePos).sub;
        System.err.println("Subject Name: "+sub.subName);
        
        System.out.format("|   No. |  Student ID  |    Student name    |  Average |  Status |%n");
        System.out.format("|-------|--------------|--------------------|----------|---------|%n");
        
        int count =1;
        this.sort(Grade.byStudentName); 
        for (Grade g: this){
            if(subID.equalsIgnoreCase(g.sub.subID)){
                    double avg = g.average();
                    String status;
                    if(avg>=5) status="Pass";
                    else status="Not Pass";
 System.out.format("|  %d  |  %s  | %s %s  |%.1f  | %s |%n", count, g.std.stuID, g.std.lastName,g.std.firstName,avg, status); 
 
                count++;
                
            }
        }
    }
}
    }
                                                                                  