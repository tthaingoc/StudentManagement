/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fu.tuantn.menu;

import java.util.Scanner;

/**
 *
 * @author NTuanT
 */
public class GradeManager {
    public static void main(String[] args){
        
        StudentList stdList = new StudentList();
        SubjectList subList = new SubjectList();
        GradeList gradeList = new GradeList(stdList, subList);
        
        int choice = 0;
        Scanner sc = new Scanner(System.in);
       
        
        
            System.out.println("+--------------MENU-----------------+");
            System.out.println("1. Add new Student");
            System.out.println("2. Update Student ");
            System.out.println("3. Delete Student ");
            System.out.println("4. Add new Subject ");
            System.out.println("5. Update Subject ");
            System.out.println("6. Delete Subject ");
            System.out.println("7. Enter Grade ");
            System.out.println("8. Display Student Grade Report ");
            System.out.println("9. Display Subject Grade Report ");
            System.out.println("10. Quit Program ");
            System.out.println("**********Test in 22/02/2023*************");
            
        do{
            System.out.println("+-----------------------------------+");
            System.out.println("Enter the Choice: ");

            
            choice = sc.nextInt();
            
        switch (choice)
        {
            case 1:
                boolean check = false;
           do{
            System.err.println("Add new Student");
            stdList.addStudent();
            
            
            System.out.println("Add 1 More Student (Y/N)?");
            sc = new Scanner(System.in);
            String inputStr = sc.nextLine().trim().toUpperCase();
            if(inputStr.startsWith("Y")) {check = true;
            
            }
            else check = false;
           }while(check == true);   
           
                break;
                
            case 2:
                System.err.println("Update Student");
                stdList.updateStudent();
                break;
            case 3:
                System.err.println("Delete Student");
                stdList.deleteStudent();
                break;
            case 4:
                boolean reInput = false;
                do{
                System.err.println("Add new Subject");
                subList.addSubject();
                    System.out.println("Add 1 More Subject (Y/N}");
                    sc= new Scanner(System.in);
                    String inputStr = sc.nextLine().trim().toUpperCase();
                    if(inputStr.startsWith("Y")) { reInput = true;
            
            }
            else reInput = false;
                }while(reInput == true);
                
                break;
                
            case 5:
                System.err.println("Update Subject");
                subList.updateSubject();
                break;
            case 6:
                System.err.println("Delete Subject");
                subList.deleteSubject();
                break;
            case 7:
                System.err.println("Enter Grade");
                gradeList.addNewGrade();
                break;
            case 8:
                System.err.println("Display Student Grade Report");
                gradeList.printStudentReport();
                break;
            case 9:
                System.err.println("Display Subject Grade Report");
                gradeList.printSubjectReport();
                break;
            case 10:
                System.err.println("This is the end of program.");
                
                break;
                
            }
    }while (choice <= 9);
}
}
