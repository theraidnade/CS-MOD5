/**
 * Module 5 Project: Cemetery
 *
 * Name: Phillip Dickey
 * 
 * AP Computer Science, Virtual Virginia
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Cemetery
{
    private int janAmount = 0;
    private int febAmount = 0;
    private int marAmount = 0;
    private int aprAmount = 0;
    private int mayAmount = 0;
    private int junAmount = 0;
    private int julAmount = 0;
    private int augAmount = 0;
    private int sepAmount = 0;
    private int octAmount = 0;
    private int novAmount = 0;
    private int decAmount = 0;
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
       Person[] people = new Person[num];
       int count = 0;
       try
       {
           Scanner scan = new Scanner(f);
           for(int g = 0;g<people.length;g++)
           {
               if(scan.hasNextLine())
               {
                   String temp = scan.nextLine();
                   people[g] = makePerson(temp);
               }
           }
       }
       catch (Exception e)
       {
           System.out.println("Check filename.");
       }
       
       return people;
   }
   
   /* A helper method that instantiates one Person object.
    * @param entry -- one line of the input file.
    */
   private static Person makePerson(String entry)
   {
       String currentName = entry.substring(0,25);
       String currentBurialDate = entry.substring(25,36);
       String currentAge = entry.substring(37,41);
       return new Person(currentName, currentBurialDate, currentAge);
   }  
   
   /* Finds and returns the location (the index) of the Person
    * who is the youngest.
    * @param arr -- an array of Person objects.
    */
   public static int locateMinAgePerson(Person[] arr)
   {
       double young = 200;
       int arrCount = 0;
       for(int y = 0;y<arr.length;y++)
       {
           if(arr[y].getAge() < young)
           {
               young = arr[y].getAge();
               arrCount = y;
           }
       }
       return arrCount;
   }   
   
   /* Finds and returns the location (the index) of the Person
      who is the oldest.
      @param arr -- an array of Person objects.
    */
   public static int locateMaxAgePerson(Person[] arr)
   {
       double old = 0;
       int arrCount2 = 0;
       for(int z = 0;z<arr.length;z++)
       {
           if(arr[z].getAge() > old)
           {
               old = arr[z].getAge();
               arrCount2 = z;
           }
       }
       return arrCount2;
   }
   /* This is my level 2 stuff.  It scans the list for the 
    * amount of people buried on the same month and then returns
    * that data.
    */
   public void monthAmount(File f, int num)
   {
       int i = 0;
       String[] month = new String[num];
       try
       {
           Scanner scan = new Scanner(f);
           for(int k=0;k<month.length;k++)
           {
               if (scan.hasNextLine())
               {
                   String temp3 = "";
                   temp3 = scan.nextLine();
                   month[k] = temp3.substring(28,31);
               }
           }
           for(int u=0;u<month.length;u++)
           {

               if(month[u].equals("Jan"))
               {
                  janAmount++; 
               }
               else if(month[u].equals("Feb"))
               {
                   febAmount++;
               }
               else if(month[u].equals("Mar"))
               {
                   marAmount++;
               }
               else if(month[u].equals("Apr"))
               {
                   aprAmount++;
               }
               else if(month[u].equals("May"))
               {
                   mayAmount++;
               }
               else if(month[u].equals("Jun"))
               {
                   junAmount++;
               }
               else if(month[u].equals("Jul"))
               {
                   julAmount++;
               }
               else if(month[u].equals("Aug"))
               {
                   augAmount++;
               }
               else if(month[u].equals("Sep"))
               {
                   sepAmount++;
               }
               else if(month[u].equals("Oct"))
               {
                   octAmount++;
               }
               else if(month[u].equals("Nov"))
               {
                   novAmount++;
               }
               else
               {
                   decAmount++;
               }
           }
       }
       
       catch (Exception e)
       {
           System.out.println("Check filename.");
       }       
   }
   public void displayMonthValues()
   {
      System.out.println("Amount of people born in January: " + janAmount);
      System.out.println("Amount of people born in February: " + febAmount);
      System.out.println("Amount of people born in March: " + marAmount);
      System.out.println("Amount of people born in April: " + aprAmount);
      System.out.println("Amount of people born in May: " + mayAmount);
      System.out.println("Amount of people born in June: " + junAmount);   
      System.out.println("Amount of people born in July: " + julAmount);
      System.out.println("Amount of people born in August: " + augAmount);
      System.out.println("Amount of people born in September: " + sepAmount);
      System.out.println("Amount of people born in October: " + octAmount);
      System.out.println("Amount of people born in November: " + novAmount);
      System.out.println("Amount of people born in December: " + decAmount);
   }
}

class Person
{
   //// FIELDS ////
   private String name = "";
   private String burialDate = "";
   private double age = 0;   
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
           int pos1 = a.indexOf("d");
           double numDays = Double.parseDouble(a.substring(0,pos1));
           numericalAge = numDays/365.0;
       }
       else
       {
           double AgeOther = Double.parseDouble(a.trim());
           numericalAge = AgeOther;
       }
       return numericalAge;
   }
   
   ////////// ACCESSOR METHODS (Person) //////////
   
   /* Write 3 accessor methods for the fields of the Person class.
    * (See the main method in the Cemetery class.)
    */
   public double getAge()
   {
       return age;
   }
   public String getBurialDate()
   {
       return burialDate;
   }
   public String getName()
   {
       return name;
   }
   
} 