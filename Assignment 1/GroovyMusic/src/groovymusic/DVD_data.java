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

public class DVD_data {
    //
    public int dvdIdentification;
    //
    public int dvdCatageory;
    //
    public int dvdYear;
    //
    public double dvdPrice;
    //
    public int dvdCount;
    //
    public String dvdArtistName;
    //
    public String dvdTitle;
    //
    public String catageoryString;
    
    public DVD(){
        dvdIdentification = dvdCatageory = dvdYear = dvdCount = 0;
        dvdPrice = 0.0;
        dvdArtistName = dvdTitle = catageoryString = "unknown";
    }
    //
    public DVD(int Identification, int Catageory, int Year, double Price, int Count, String Artist, String Title){
        //
        dvdIdentification = Identification;
        //
        dvdCatageory = Catageory;
        //
        dvdYear = Year;
        //
        dvdPrice = Price;
        //
        dvdCount = Count;
        //
        dvdArtistName = Artist;
        //
        dvdTitle = Title;
    }
    
    //
    public DVD_data[] insert(String inputFile) throws FileNotFoundException{
        DVD_data[] DVDInventory = new DVD_data[20];
        Scanner scan = new Scanner(new File(inputFile));
        int i = 0;
        while (scan.hasNextLine()){
            DVD_data newDVD = new DVD_data();
            dvdIdentification = scan.nextInt();
            dvdCatageory = scan.nextInt();
            dvdYear = scan.nextInt();
            dvdPrice = scan.nextDouble();
            dvdCount = scan.nextInt();
            dvdArtistName = scan.nextLine();
            dvdTitle = scan.nextLine();
            newDVD.DVD(dvdIdentification, dvdCatageory, dvdYear, dvdPrice, dvdCount, dvdArtistName, dvdTitle);
            newDVD = DVDInventory[i];
            i++;
        }
        return DVDInventory;
    }
}