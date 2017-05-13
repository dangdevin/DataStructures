// CS 0445 Spring 2016
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list
	private CNode currNode;

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.
   

	// Create a new MyStringBuilder initialized with the chars in String s
	public MyStringBuilder(String s)
	{
      if (s == null || s.length() == 0) // Special case for empty String
	   {					 			  // or null reference
   		firstC = null;
   		lastC = null;
   		length = 0;
	   }
	   	else
	   	{
	   		// Create front node to get started
	   		firstC = new CNode(s.charAt(0));
	   		length = 1;
	   		CNode currNode = firstC;
	   		// Create remaining nodes, copying from String.  Note
	   		// how each new node is simply added to the end of the
	   		// previous one.  Trace this to see what is going on.
	   		for (int i = 1; i < s.length(); i++)
	   		{
	   			CNode newNode = new CNode(s.charAt(i));
	   			currNode.next = newNode;
	   			currNode = newNode;
	   			length++;
	   		}
	   		lastC = currNode;
	   	}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
	      if (s == null || s.length == 0) // Special case for empty String
		   {					 			  // or null reference
	   		firstC = null;
	   		lastC = null;
	   		length = 0;
	   	}
	   	else
	   	{
	   		// Create front node to get started
	   		firstC = new CNode(s[0]);
	   		length = 1;
	   		CNode currNode = firstC;
	   		// Create remaining nodes, copying from char [].  Note
	   		// how each new node is simply added to the end of the
	   		// previous one.  Trace this to see what is going on.
	   		for (int i = 1; i < s.length; i++)
	   		{
	   			CNode newNode = new CNode(s[i]);
	   			currNode.next = newNode;
	   			currNode = newNode;
	   			length++;
	   		}
	   		lastC = currNode;
	   	}	
    }

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
   		firstC = null;
   		lastC = null;
   		length = 0;
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
          if(length==0)
          {
            firstC = new CNode(b.firstC.data);
            length = 1;
            CNode currNode = b.firstC;
            for (int i = 1; i < b.length; i++)
            {
                CNode newNode = new CNode(currNode.next.data);
                currNode.next = newNode;
                currNode = newNode;
                length++;
            }
            lastC = currNode;

          }
          else
          {
               CNode currNode = lastC;
               CNode bNode = b.firstC;
               for (int i = 1; i <= b.length; i++)
               {
                  CNode newNode = new CNode(bNode.data);
                  currNode.next = newNode;
                  currNode = newNode;
                  newNode = currNode.next;
                  bNode = bNode.next;
                  length++;
               }
               lastC = currNode;
           }
         return b;
	}


	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		char [] array = s.toCharArray();
		if (length == 0)
	    {
	    	firstC = new CNode(array[0]);
	    	length = 1;
	    	currNode = firstC;
	    }
		else
		{
	      CNode currNode = lastC;
	      for (int i = 0; i < array.length; i++)
	      {
	            CNode newNode = new CNode(array[i]);
	            currNode.next = newNode;
	            currNode = newNode;
	            newNode = currNode.next;
	            length++;
	      }
		}
	    return this;
         
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{
                CNode currNode = lastC;
                for (int i = 0; i < c.length; i++)
                {
                  CNode newNode = new CNode(c[i]);
                  currNode.next = newNode;
                  currNode = newNode;
                  lastC = currNode;
                  length++;
                }
       
       return this;
    }

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
      CNode newNode = new CNode(c);
      CNode currNode = lastC;
      currNode.next = newNode;
      currNode = newNode;
      lastC = currNode;
      length++;
      return this;

	}

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
      if ((index > length) || (index < 0))
      {
         throw new IndexOutOfBoundsException("Index does not exist there.");
      }
      else
      {
         char result = '\0';
         CNode currNode = firstC;
         int counter = 0;
         for(int i = 0; i < index+1; i++)
         {
            result = currNode.data;
            currNode = currNode.next;
         }
         return result;
         
      }

	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
      if((start > length) || (start < 0) || (end <= start) || (end > length) || (end < 0))
      {
         return this;
      }
      else
      {
         int i = 0;
         char [] array = new char[length];
         int amount = length - (end - start);
         System.out.println(amount);
         System.out.println(length);
         char [] deleted = new char[amount];
         CNode currNode = firstC;
         int deletedCounter = 0;
         while (currNode.next != null)
         {
            array[i] = currNode.data;
            currNode = currNode.next;
            i++;
         }
         array[i] = currNode.data;
         for(int j = start; j < end; j++)
         {
            array[j] = '6';
         }
         for(int k = 0; k < array.length; k++)
         {
            if(array[k] != '6')
            {
               deleted[deletedCounter] = array[k];
               deletedCounter++;
            }
         }
         length = deleted.length;
         System.out.println(deleted.length);
         MyStringBuilder done = new MyStringBuilder(deleted);
         return done;
         /*CNode startNode;
         CNode endNode;
         startNode = firstC;
         endNode = firstC;
         for(int i = 0; i < start; i++)
         {
         }*/
            
      }
         
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
      if((index > length) || (index < 0))
      {
         return this;
      }
      else
      {
         int i = 0;
         char [] array = new char[length+1];
         int amount = length - (1);
         char [] deleted = new char[amount];
         CNode currNode = firstC;
         int deletedCounter = 0;
         while (currNode.next != null)
         {
            array[i] = currNode.data;
            currNode = currNode.next;
            i++;
         }
         array[i] = currNode.data;
         array[index] = '\0';
         for(int k = 0; k < array.length; k++)
         {
            if(array[k] != '\0')
            {
               deleted[deletedCounter] = array[k];
            }
         }
         
         MyStringBuilder done = new MyStringBuilder(deleted);
         length = length - 1;
         return done;
      }

	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
         int lengthOfStr = str.length();
         String data = this.toString();
         int index = -1;
         for(int i = 0; i < length - lengthOfStr; i++)
         {
            if (data.substring(i, i+lengthOfStr).compareTo(data) == 0)
            {
               index = i;
               break;
            }
         }
         return index;
      
      
      
	}

	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{
      if(offset == length)
      {
         this.append(str);
         System.out.println("Offset == length" + length);
         return this;
      }
      else if ((offset > length) && (offset >= 0))
      {
         return this;
      }
      else
      {
         CNode currNode = firstC;
         char [] build = new char[length+str.length()];
         int arrayCounter = 0;
         for(int i = 0; i < offset; i++)
         {
            build[i] = currNode.data;
            currNode = currNode.next;
         }
         char [] array = str.toCharArray();
         for(int j = offset; j < offset + str.length(); j++)
         {
            build[j] = array[arrayCounter];
            arrayCounter++;
         }
         for (int k = offset + str.length(); k < build.length; k++)
         {
           build[k] = currNode.data;
           currNode = currNode.next;
         }
         
         MyStringBuilder inserted = new MyStringBuilder(array);
         length = length + str.length();
         return inserted;
      }
         


	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
      if(offset == length)
      {
         this.append(c);
         return this;
      }
      else if((offset > length) || (offset < 0))
      {
         return this;
      }
      else
      {
         int i = 0;
         char [] array = new char[length+1];
         CNode currNode = firstC;
         while (currNode.next != null)
         {
            array[i] = currNode.data;
            currNode = currNode.next;
            i++;
         }
         array[i] = currNode.data;
         for (int j = array.length - 1; j >= offset; j--) 
         {                
            array[j+1] = array[j];
         }
         array[offset] = c;
         MyStringBuilder inserted = new MyStringBuilder(array);
         length++;
         return inserted;
      }
   }

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{
      if(offset == length)
      {
         this.append(c);
         System.out.println("Offset == length" + length);
         return this;
      }
      else if((offset > length) || (offset < 0))
      {
         System.out.println("Invalid" + length);
         return this;
      }
      else
      {
         System.out.println("Tried to insert." + length);
         int i = 0;
         int insertLength = c.length;
         char [] array = new char[length+insertLength];
         CNode currNode = firstC;
         int cCounter = 0;
         while (currNode.next != null)
         {
            array[i] = currNode.data;
            currNode = currNode.next;
            i++;
         }
         array[i] = currNode.data;
         for (int j = array.length - 1; j >= offset; j--) 
         {                
            array[j+1] = array[j];
         }
         for(int k = offset; k < offset + insertLength; k++)
         {
            array[k] = c[cCounter];
            cCounter++;
         }
         length =  length + c.length;
         MyStringBuilder inserted = new MyStringBuilder(array);
         return inserted;
      }
	}

	// Return the length of the current MyStringBuilder
	public int length()
	{
      int x = 0;
      CNode currNode = firstC;
      char [] array = new char[length];
      while (currNode.next != null)
      {
         array[x] = currNode.data;
         currNode = currNode.next;
         x++;
      }
      array[x] = currNode.data;
      x++;
      return x;
	}


	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.
	public MyStringBuilder replace(int start, int end, String str)
	{
      if((start > length) || (start < 0) || (end <= start) || (end > length) || (end < 0))
      {
         this.append(str);
         return this;
      }
      else
      {
         CNode currNode = firstC;
         char [] build = new char[length];
         int arrayCounter = 0;
         for(int i = 0; i < build.length; i++)
         {
            build[i] = currNode.data;
            currNode = currNode.next;
         }
         char [] array = str.toCharArray();
         for(int j = start; j < end+1; j++)
         {
            build[j] = array[arrayCounter];
            arrayCounter++;
         }
         
         MyStringBuilder inserted = new MyStringBuilder(array);
         return inserted;
      }

	}

	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
      if((start > length) || (start < 0) || (end <= start) || (end > length) || (end < 0))
      {
         return "";
      }
      else
      {
         CNode currNode = firstC;
         char [] build = new char[length];
         int x = 0;
         while (currNode.next != null)
         {
            build[x] = currNode.data;
            currNode = currNode.next;
            x++;
         }
         build[x] = currNode.data;
         int arrayCounter = 0;
         char [] array = new char[(end-start)+1];
         for(int j = start; j < end+1; j++)
         {
            array[arrayCounter] = build[j];
            arrayCounter++;
         }
         
         String done = String.valueOf(array);
         return done;
      }
	}

	// Return the entire contents of the current MyStringBuilder as a String
	public String toString()
	{
      int i = 0;
      char [] array = new char[length];
      CNode currNode = firstC;
      if(length == 0)
      {
         return "";
      }
      while (currNode.next != null)
      {
         array[i] = currNode.data;
         currNode = currNode.next;
         i++;
      }
      array[i] = currNode.data;
      String toS = new String(array);
      return toS;
         
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
}

