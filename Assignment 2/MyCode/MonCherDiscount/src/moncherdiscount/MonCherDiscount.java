
package moncherdiscount;

import java.io.*;
import java.util.*;

/**
 *
 * @author Clayton
 */
public class MonCherDiscount {
    private static MonCherDiscount[] customers = new MonCherDiscount[20];
    private String Name, Address, EmailAddress;
    private String PhoneNumber;
    private boolean MailingListFlag;
    private Double TotalSpent;
    private int Discount;    
    
//    /**
//     * 
//     * @param name
//     * @param address
//     * @param phonenumber 
//     */
//    public void Person(String name, String address, Long phonenumber){
//        this.Name = name;
//        this.Address = address;
//        this.PhoneNumber = phonenumber;
//    }
//    
//    /**
//     *
//     * @param name
//     * @param address
//     * @param phonenumber
//     * @param mailinglistflag
//     * @param email
//     */
//    public void Customer(String name, String address, Long phonenumber, Boolean mailinglistflag, String email){
//        this.Name = name;
//        this.Address = address;
//        this.PhoneNumber = phonenumber;
//        this.MailingListFlag = mailinglistflag;
//        this.EmailAddress = email;
//    }
//    
//    public void DiscountCustomer(){
//        this.Name = null;
//        this.Address = null;
//        this.PhoneNumber = null;
//        this.EmailAddress = null;
//        this.Discount = 0;
//        this.TotalSpent = null;
//    }
    /**
     * 
     * @param name
     * @param address
     * @param phonenumber
     * @param mailinglistflag
     * @param email
     * @param discount 
     */
    public MonCherDiscount(String name, String address, String phonenumber, Boolean mailinglistflag, String email, int discount, Double total){
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phonenumber;
        this.MailingListFlag = mailinglistflag;
        this.EmailAddress = email;
        this.Discount = discount;
        this.TotalSpent = total;
    }
    
    public static void insert() throws FileNotFoundException{
        try{
            int trueFalse = 0;
            int i = 0;
            Scanner scan = new Scanner(new File("MonCher.data"));
            while(scan.hasNextLine()){
                String name = scan.nextLine();
                String address = scan.nextLine();
                String phone = scan.nextLine();
                trueFalse = scan.nextInt();
                boolean mailinglist = intboolean(trueFalse);
                String email = scan.nextLine();
                String tot = scan.nextLine();
                double total = Double.parseDouble(tot);
                customers[i++] = new MonCherDiscount(name, address, phone, mailinglist, email, 0, total);
            }
        }catch(FileNotFoundException e){System.out.print(e.getMessage());}
    }
    
    public static boolean intboolean(int trueFalse){
        if(trueFalse == 1)
            return(true);
        return(false);
    }
    
    public static void selectionSort(MonCherDiscount[] data){
        for(int i = 0; i <  customers.length - 1; i++){
            int minPos = 0;
            for(int j = i + 1; j < customers.length - 1; j++){
                if(customers[j] != null && customers[minPos] != null)
                    if (customers[j].TotalSpent < customers[minPos].TotalSpent)
                        minPos = j;
            }
            MonCherDiscount tmp = customers[minPos];
            customers[minPos] = customers[i];
            customers[i] = tmp;
        }
    }
    
    private static void printCustomerData(PrintWriter print){
        for(int i = 0; i < customers.length; i++)
            if(customers[i] != null)
                printData(customers[i], print);
        print.close();
    }
    
    public static int customerDiscount(MonCherDiscount person){
        if(person.TotalSpent < 200)
            return 0;
        if(person.TotalSpent < 500)
            return 25;
        if(person.TotalSpent < 750)
            return 30;
        if(person.TotalSpent < 1000)
            return 35;
        else
            return 40;
    }
    
    private static void printData(MonCherDiscount customer, PrintWriter print) {
        System.out.println("Name: " + customer.Name);
        System.out.println("Address: " + customer.Address);
        System.out.println("Phone Number: " + customer.PhoneNumber);
        System.out.println("Mailing List Member: " + customer.MailingListFlag + " Email Address: " + customer.EmailAddress);
        System.out.println("Total Spent: " + customer.TotalSpent);
        System.out.printf("Discount: %d ", customer.Discount);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter export = new PrintWriter(new File("Report.out"));
        insert();
        selectionSort(customers);
        printCustomerData(export);
    }
}