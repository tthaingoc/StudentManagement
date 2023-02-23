/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fu.tuantn.menu;

import static com.fu.tuantn.menu.BooleanDateDemo.toDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author NTuanT
 */

public class StudentList{
    //fields
    ArrayList<Student> arrStu = new ArrayList<>();

    
    //Others functions
    
    //Search Student ID
   private int search (String stdId){
   for(int i=0; i<arrStu.size(); i++) 
                {
			if(arrStu.get(i).getStuID().equalsIgnoreCase(stdId)) 
				return i;
		}
		return -1;
    }    
                                
    //Hàm này để thêm sinh viên
    public void addStudent(){
        String stuID, firstName, lastName, gender;
        String DOB;
        String email, phone;
        Date d = new Date();
        
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID"); // SID
        sc = new Scanner(System.in);
        stuID = sc.nextLine();
        search(stuID);
        while(search(stuID)!=-1){
            System.out.println("Found 1 Student in the List");
            System.out.println("Re-Input:");
            sc = new Scanner(System.in);
            stuID = sc.nextLine();
        }       
        
        
        System.out.println("First Name: "); //Name
        sc = new Scanner(System.in);
        firstName = sc.nextLine();
        while(firstName.isEmpty()){
            System.out.println("Name can't be Empty!\n First Name: ");
            sc= new Scanner(System.in);
            firstName = sc.nextLine();            
        }
        
        System.out.println("Last Name: ");  
        sc = new Scanner(System.in);
        lastName = sc.nextLine();
        while(lastName.isEmpty()){
            System.out.println("Name can't be Empty!\n Last Name: ");
            sc = new Scanner(System.in);
            lastName = sc.nextLine();
        }
        
        System.out.println("Gender");   //Gender
        sc= new Scanner(System.in);
        gender = sc.nextLine();
        while(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")){
            System.out.println("Male or Female");
            sc = new Scanner(System.in);
            gender = sc.nextLine();
        }

        
        //Check Date 
        boolean reInput =false;
        do{
        System.out.println("Input Day of Birth: yyyy/m/d:  ");
        sc= new Scanner(System.in);
        
        DOB = sc.nextLine().trim().toUpperCase();
        if(DOB.matches("^[0-9]{4}[/-][0-9]{1,2}[/-][0-9]{1,2}$")){
        long t = toDate(DOB);
        if(t<0){ 
            System.out.println("Inputted date is invalid!");
            reInput=true;
                }
        else{
            d= new Date(t);
            System.out.println("Inputed date: " +d);
                        reInput=false;
            }
        }
        else{
            System.out.println("Inputted date is invalid!");
            reInput= true;
        }
        }while(reInput==true);
        
        System.out.println("Email: ");
        sc = new Scanner(System.in);
        email = sc.nextLine();
        System.out.println(isValidEmail(email));
        while(isValidEmail(email)==false){
            System.out.println("Re-input: ");
            sc = new Scanner(System.in);
            email = sc.nextLine();       
        }

        
        System.out.println("Phone Number: ");
        sc = new Scanner(System.in);
        phone = sc.nextLine();
        while(phone.length() < 10 || phone.length() > 12){
            System.out.println("Invalid Phone Number. Try Again");
            sc = new Scanner(System.in);
            phone = sc.nextLine();
        }

        Student stu = new Student(stuID, firstName, lastName, gender, d, email, phone);
        arrStu.add(stu);
            
    }
    
    
    //Hàm này để sửa thông tin sinh viên
     void updateStudent(){
        String oldID;
        String nfname, nlname, gender, nDOB;
        Date d = new Date();
        String nemail, nphone;
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID To Search: ");
        sc = new Scanner(System.in);
        oldID = sc.nextLine();
        
        int pos = search(oldID);
        
        
        if (pos < 0) {System.out.println("No Result");}
                                            
                    else{
                    System.out.println("Enter New Student Information: ");
                    
                    
                    System.out.println("New first name: "); //Name != Null
                    sc = new Scanner(System.in);
                    nfname = sc.nextLine();
                    arrStu.get(pos).setFirstName(nfname);
                    
                    while(nfname.isEmpty()){
                        System.out.println("first name can't be empty. Try again");
                        sc = new Scanner(System.in);
                        nfname = sc.nextLine();
                        arrStu.get(pos).setFirstName(nfname);
                    }
                     
                    System.out.println("New last name: ");
                    sc = new Scanner(System.in);
                    nlname = sc.nextLine();
                    arrStu.get(pos).setLastName(nlname);
                    
                    while(nfname.isEmpty()){
                        System.out.println("last name can't be empty. Try again");
                        sc = new Scanner(System.in);
                        nlname = sc.nextLine();
                        arrStu.get(pos).setLastName(nlname);
                    }

                    
                    
                    System.out.println("Gender:");  //Gender
                    sc= new Scanner(System.in);
                    gender = sc.nextLine();
                    arrStu.get(pos).setGender(gender);
                    
                    while(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")){
                        System.out.println("Male or Female ?");
                        sc= new Scanner(System.in);
                        gender = sc.nextLine();
                        arrStu.get(pos).setGender(gender);
                    }
                                          
                    
                    //Date-Validation
                    boolean checkvalid= true;
                    do{
                    System.out.println("Input Day of Birth: yyyy/m/d:  ");
                    sc= new Scanner(System.in);
                    nDOB = sc.nextLine().trim().toUpperCase();
                    if(nDOB.matches("^[0-9]{4}[/][0-9]{1,2}[/][0-9]{1,2}$")){
                            
                    long t = toDate(nDOB);
                    if(t<0) {System.out.println("Inputted date is invalid!");
                                checkvalid=false;
                    }
                    else{
            
                    d= new Date(t);
                    System.out.println("Inputed date: " +d);
                            arrStu.get(pos).setDOB(d);
                            checkvalid=true;
                    }
                    }
                    else {System.out.println("Inputted date is invalid!");
                            checkvalid=false;
                    }
                    }while(checkvalid==false);
                    
                    
                    System.out.println("Email: "); //email
                    sc = new Scanner(System.in);
                    nemail = sc.nextLine();
                    System.out.println(isValidEmail(nemail));
                    arrStu.get(pos).setEmail(nemail);
                    
                    while(isValidEmail(nemail)==false){
                        System.out.println("Re-input: ");
                        sc = new Scanner(System.in);
                        nemail = sc.nextLine();
                        arrStu.get(pos).setEmail(nemail);
                        }
                            
                   
                    System.out.println("Phone Number: ");   //9<= Phone <= 12
                    sc = new Scanner(System.in);
                    nphone = sc.nextLine();
                    arrStu.get(pos).setPhone(nphone);
                    
                    while(nphone.length() < 10 || nphone.length() > 12){
                    System.out.println("Invalid Phone Number. Try Again");
                    sc = new Scanner(System.in);
                    nphone = sc.nextLine();
                    arrStu.get(pos).setPhone(nphone);
                           }
                    
                    
                    
                       }
            }
        
    
    //Hàm này để xóa thông tin 1 sinh viên
    public void deleteStudent(){
        String searchID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID To Search: ");
        sc = new Scanner(System.in);
        searchID = sc.nextLine();
        
        int pos = search(searchID);
        
        
        if (pos < 0 ) {System.out.println("Student does not exist");}
        
        else if (arrStu.get(pos).canDelete==false){
            System.err.println("This student can't be removed!");
        }
        else {
            boolean wantdelete = false;
            System.out.println("Do you want to delete it? (Y/N) ");
            sc = new Scanner(System.in);
            String inputStr = sc.nextLine().trim().toUpperCase();
            if(inputStr.startsWith("Y")) {wantdelete = true; 
            arrStu.remove(pos);
            System.out.println("Student : "+searchID+" has been deleted");
            } 
            else {wantdelete =false; System.out.println("Information is safe !");}
            }   

    }
    

    
    //My Validation
    
    public static boolean isValidEmail(String s)
    {
        String emailRegex = "[A-Z0-9._%+-]+@[A-Z0-9-]+[\\.a-z]{2,6}"; //@gmail.com
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matches = emailPat.matcher(s);
        return matches.find();
    
}
}
