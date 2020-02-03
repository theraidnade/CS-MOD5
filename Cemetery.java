/**
 * Module 5 Project: Cemetery
 *
 * Name: 
 * 
 * AP Computer Science, Virtual Virginia
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Cemetery
{
   //////// MAIN ////////
   public static void main (String [] args)
   {
      File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      Person[] cemetery = readIntoArray(file, numEntries); 
      
      //TESTING ONLY: un-comment the 2 lines below to see if array was created properly
      //for (int i = 0; i < cemetery.length; i++) 
        //System.out.println(cemetery[i].getName() + " " + cemetery[i].getAge());
      
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery); 
      System.out.println("In the St. Mary Magdelene Old Fish Cemetery --> ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());    
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge());     
   }
   
   //////// METHODS (Cemetery) ////////

   /* Counts and returns the number of entries in File f.
    * Uses a try-catch block.   
    * @param f -- the file object
   */
   public static int countEntries(File f)
   {
       int i = 0;
       try
       {
           Scanner scan = new Scanner(f);
           while (scan.hasNextLine())
           {
               i++;
               scan.nextLine();
           }
       }
       catch (Exception e)
       {
           System.out.println("Check filename.");
       }
       
       return i;
   }

   /* Reads the data.
    * Fills the array with Person objects.
    * Uses a try-catch block.   
    * @param f -- the file object 
    *        num -- the number of lines in the File f  
    */
   public static Person[] readIntoArray (File f, int num)
   {
       private String[] people;
       
   }
   
   /* A helper method that instantiates one Person object.
    * @param entry -- one line of the input file.
    */
   private static Person makePerson(String entry)
   {
       String currentName = entry.substring(0,25);
       String currentBurialDate = entry.substring(25,36);
       String currentAge = //write code here!
       return new Person(currentName, currentBurialDate, currentAge);
   }  
   
   /* Finds and returns the location (the index) of the Person
    * who is the youngest.
    * @param arr -- an array of Person objects.
    */
   public static int locateMinAgePerson(Person[] arr)
   {
   
   }   
   
   /* Finds and returns the location (the index) of the Person
      who is the oldest.
      @param arr -- an array of Person objects.
    */
   public static int locateMaxAgePerson(Person[] arr)
   {
   
   }        
}

class Person
{
   //// FIELDS ////
   
   /* Declare fields for the name, the burial date, and the age. */
      
   ////// CONSTRUCTOR //////
   
   /* @param n -- a String representing a name from the input file.
    *        bd -- a String representing a burial date from the input file.
    *        a -- a String representing an age from the input file.
    */
   public Person(String n, String bd, String a)
   {
       name = n;
       burialDate = bd;
       age = calculateAge(a);
   }
   
   //////// METHODS (Person) ////////

   /* Calculates the numerical equivalent of an age in String format.
    * If the String contains a "w" (weeks) or "d" (days), calculates appropriate portion
    * of a year.
      @param a -- a String representing a person's age.
   */
   public double calculateAge(String a)
   {
       double numericalAge;
       if(a.contains("w"))
       {
           int pos = a.indexOf("w");
           double numWeeks = Double.parseDouble(a.substring(0,pos));
           numericalAge = numWeeks/52.0;
       }
       else if(a.contains("d"))
       {
           //write code here!
       }
       else
       {
           //write code here!
       }
       return numericalAge;
   }
   
   ////////// ACCESSOR METHODS (Person) //////////
   
   /* Write 3 accessor methods for the fields of the Person class.
    * (See the main method in the Cemetery class.)
    */
   
} 