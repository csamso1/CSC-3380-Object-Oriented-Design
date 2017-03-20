/********************************************/
/*    Groovy Music End-of-Year Inventory    */
/*	        Clayton Samson              */
/*          CSC 3380_89 Section 1           */
/*                Assignment 1              */
/* Instructor: Douglas                      */
/* Program due date:  February 2, 2016      */    
/********************************************/
package groovymusic;

import java.util.*;
import java.io.*;

public class GroovyMusic {
    
    private static final LinkedList<DVD> list = new LinkedList<>();
    
    /**
     * 
     * @param args the command line
     * @throws FileNotFoundException 
     */

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        int cutOffYear;
        do{
            System.out.println("Enter the cut off year: ");
            cutOffYear = sc.nextInt();
        } while (cutOffYear < 2006 || cutOffYear > 2016);
        sc = new Scanner(new File("Music2015.data"));
        addDVDs(sc);
        System.out.println("Original inventory in order of ID:");
        list.stream().forEach((cd) -> {
            System.out.printf("%s", cd.toString);
        });
        LinkedList<DVD> deleted = updateDVDs();
        System.out.println("Items to be deleted");;
        deleted.stream().forEach((cd) -> {
            System.out.printf("%s", cd.toString);
        });
        System.out.println("Items after deletion");
        list.stream().forEach((DVD) -> {
            System.out.printf("%s", cd.toString());
        });
    }
    
    /**
     * 
     * @param in scanner that is reading the input file
     */
    private static void addDVDs(Scanner in){
            while (in.hasNextLine()){
                int count = 0;
                DVD_data cd = new DVD_data();
                while (count < 4){
                    String line = in.nextLine();
                    String info[] = line.split("\\s*");
                    if(count == 0){
                        DVD_data = new DVD_data(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    }
                    else if (count == 1){
                        DVD_data.update(Double.parseDouble(info[0]), Integer.parseInt(info[1]));
                    }
                    else if (count == 2){
                        DVD_data.artist = line;
                    }
                    else if (count == 3){
                        DVD_data.title = line;
                    }
                    count++;
                }
                if (list.size() == 0){
                    list.add(DVD);
                } else {
                    boolean added = false;
                    for (int i = 0; i < list.size(); i++){
                        if (list.get(i).id > cd.id){
                            list.add(i, cd);
                            added = true;
                            break;
                        }
                    }
                    if (added == false){
                        list.addLast(cd);
                    }
                }
        }
    }
    
    /**
     * Checks the DVDs currently in stock and removed those that don't meet the cutoff year
     * @return the DVDs that were deleted
     */
    private static LinkedList<DVD>
}