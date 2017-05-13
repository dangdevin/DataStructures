import java.util.Scanner.*;
import java.io.*; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Assig2B
{
   public static void main (String [] args) throws IOException
   {
      BufferedReader inputStream = new BufferedReader(new FileReader(args[0]));
      BufferedReader inputStreamTwo = new BufferedReader(new FileReader(args[0]));
      StringBuilder a = new StringBuilder();
      StringBuilder aa = new StringBuilder();
      MyStringBuilder b = new MyStringBuilder();
      MyStringBuilder bb = new MyStringBuilder();
      String c = new String();
      String cc = new String();
            
      long startStringBuilderappend = System.nanoTime();
      a.append(inputStream);
      long endStringBuilderappend = System.nanoTime();
      long durationStringBuilderappend = (endStringBuilderappend - startStringBuilderappend);
      System.out.println("The duration of the append method of StringBuilder is " + durationStringBuilderappend);
      
      long startStringBuilderdelete = System.nanoTime();
      while(a.length() != 0)
      {
         a.delete(0,1);
      }
      long endStringBuilderdelete = System.nanoTime();
      long durationStringBuilderdelete = (endStringBuilderdelete - startStringBuilderdelete);
      System.out.println("The duration of the delete method of StringBuilder is " + durationStringBuilderdelete);
      
      long startStringBuilderinsert = System.nanoTime();
      for(int i = 0; i < a.length(); i++);
      {
         aa.insert(aa.length()/2, 'A');
      }
      long endStringBuilderinsert = System.nanoTime();
      long durationStringBuilderinsert = (endStringBuilderinsert - startStringBuilderinsert);
      System.out.println("The duration of the insert method of StringBuilder is " + durationStringBuilderinsert);
      
      long startMyStringBuilderappend = System.nanoTime();
      b.append(inputStream.readLine());
      long endMyStringBuilderappend = System.nanoTime();
      long durationMyStringBuilderappend = (endMyStringBuilderappend - startMyStringBuilderappend);
      System.out.println("The duration of the append method of MyStringBuilder is " + durationMyStringBuilderappend);
      
      long startMyStringBuilderdelete = System.nanoTime();
      while(b.length() != 0)
      {
         b.delete(0,1);
      }
      long endMyStringBuilderdelete = System.nanoTime();
      long durationMyStringBuilderdelete = (endMyStringBuilderdelete - startMyStringBuilderdelete);
      System.out.println("The duration of the delete method of MyStringBuilder is " + durationMyStringBuilderdelete);
      
      long startMyStringBuilderinsert = System.nanoTime();
      for(int i = 0; i < b.length(); i++);
      {
         bb.insert(aa.length()/2, 'A');
      }
      long endMyStringBuilderinsert = System.nanoTime();
      long durationMyStringBuilderinsert = (endMyStringBuilderinsert - startMyStringBuilderinsert);
      System.out.println("The duration of the insert method of MyStringBuilder is " + durationMyStringBuilderinsert);
      
      
      long startStringappend = System.nanoTime();
      c.concat(inputStream.readLine());
      long endStringappend = System.nanoTime();
      long durationStringappend = (endStringappend - startStringappend);
      System.out.println("The duration of the append method of String is " + durationStringappend);
      
      long startStringdelete = System.nanoTime();
      while(c.length() != 0)
      {
         c.replace('A', ' ');
      }
      long endStringdelete = System.nanoTime();
      long durationStringdelete = (endStringdelete - startStringdelete);
      System.out.println("The duration of the delete method of String is " + durationStringdelete);
      
      long startStringinsert = System.nanoTime();
      for(int j = 0; j < c.length();j++);
      {
         cc.concat("A");
      }
      long endStringinsert = System.nanoTime();
      long durationStringinsert = (endStringinsert - startStringinsert);
      System.out.println("The duration of the insert method of String is " + durationStringinsert);


      
   }
}