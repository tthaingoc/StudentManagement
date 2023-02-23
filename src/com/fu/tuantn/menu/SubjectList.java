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
public class SubjectList{
    //fields
    ArrayList<Subject> arrSub = new ArrayList<>();
    

    //Others functions
    
    //Search Subject ID
    private int search (String subID){

            for(int i=0 ; i< arrSub.size(); i++){
                if(arrSub.get(i).getSubID().equalsIgnoreCase(subID))
                    return i;
            }
    return -1;
                    }    
    //Hàm này để thêm 1 môn học
    public void addSubject(){
        String subID, subName;
        int credit;
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter Subject ID: "); //Sub ID
        sc = new Scanner(System.in);
        subID = sc.nextLine();
        search(subID);
        while(search(subID)!=-1){
            System.out.println("Found 1 subject in the list");
            sc = new Scanner(System.in);
            subID = sc.nextLine();
        }
        
        System.out.println("Enter Subject Name: "); //Sub name != null
        sc = new Scanner(System.in);
        subName = sc.nextLine();
        while(subName.isEmpty()){
            System.out.println("Subname can't be empty");
            sc = new Scanner(System.in);
            subName = sc.nextLine();
        }
        
        System.out.println("Enter Subject Credit"); //0<= credit <= 30
        credit = sc.nextInt();
        while(credit<0 || credit>30){
            System.out.println("Credit [0-30]. Please Try Again.");
            credit = sc.nextInt();
        } System.out.println("Inputed");
        
        
        Subject sub =new Subject(subID, subName, credit);
        arrSub.add(sub);
    }
    
    //Hàm này để sửa thông tin môn học
    public void updateSubject(){
        String nsubID, nsubName;
        int ncredit;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Subject ID to Search");
        sc = new Scanner(System.in);
        nsubID = sc.nextLine();
        
        int pos = search(nsubID);
        if (pos < 0) {System.out.println("No Result");}
        else
        {
            System.out.println("Enter new Subject Information: ");
            
           do{
            System.out.println("Enter Subject Name");
            sc = new Scanner(System.in);
            nsubName = sc.nextLine();
            if(nsubName.isEmpty()) System.out.println("ReInput Please");
            else arrSub.get(pos).setSubName(nsubName);
            }while(nsubName.isEmpty());
           
           System.out.println("Enter Subject Credit");
            ncredit = sc.nextInt();
            while(ncredit<0 || ncredit>30){
            System.out.println("Credit [0-3]. Please Try Again.");
            ncredit = sc.nextInt();
            } System.out.println("Inputed");
            arrSub.get(pos).setCredit(ncredit); //Set to list
            
        }
        
    }
    
    //Hàm này để xóa 1 môn học
    public void deleteSubject(){
        String subsearch; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Subject Name To Search");
        sc = new Scanner(System.in);
        subsearch = sc.nextLine();
        
        int pos = search(subsearch);
        
        if(pos<0) System.out.println("Subject does not exist");
        else if(arrSub.get(pos).canDelete==false){
            System.out.println("Subject can not be removed");
        }
        else{
            boolean check = false;
            System.out.println("Do you want to delete (Y/N)");
            sc = new Scanner(System.in);
            String inputStr = sc.nextLine().trim().toUpperCase();
            if(inputStr.startsWith("Y")){ check =true;
            arrSub.remove(pos);
                System.out.println("Subject has been deleted ");
            }
            else {check = false; System.out.println("Information is safe !");}
        }
    }
}
