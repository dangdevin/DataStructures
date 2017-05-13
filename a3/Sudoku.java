//Devin Dang
//Peoplesoft ID: 4059282

package cs445.a3;

import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sudoku {
    static boolean isFullSolution(int[][] board) {
        // TODO: Complete this method
       
        for (int i = 0; i <= board.length; i++)
        {
            for (int j = 0; j <= board[i].length; j++)
            {
               if(board[i][j] == 0)
               {
                  return false;
               }
            }
       }
        
        if(reject(board))
        {
            return false;
        }
        
        return true;
    }

    static boolean reject(int[][] board) {
        // TODO: Complete this method
        //check the row
        for (int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < board.length; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < board[col].length; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check 3 by 3 blocks
        //not used code
        /*for (int block = 0; block < board.length; block++)
        {
            for(int row = block / 3 * 3; row < block / 3 * 3 + 3; row++)
            {
               for(int col = block % 3 * 3; col < block % 3 * 3 + 3; col++)
               {
                   int select = board[row][col];
               }
            }
        }*/
        
        //check first block
        //check row
        for (int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 3; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 3; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check second block
         //check row
        for (int row = 0; row < 3; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 6; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 0; row < 3; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 3; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        //check 3rd block
        //check row
        for (int row = 0; row < 3; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 9; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 0; row < 3; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 3; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }

         //check fourth block
        //check row
        for (int row = 3; row < 6; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 3; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 3; row < 6; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 6; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check fifth block
         //check row
        for (int row = 3; row < 6; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 6; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 3; row < 6; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 6; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        //check sixth block
        //check row
        for (int row = 6; row < 9; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 9; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 6; row < 9; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 9; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }

         //check 7th block
        //check row
        for (int row = 6; row < 9; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 3; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 6; row < 9; row++)
        {
            for(int col = 0; col < 3; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 9; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check 8th block
         //check row
        for (int row = 6; row < 9; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 6; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 6; row < 9; row++)
        {
            for(int col = 3; col < 6; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 9; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        //check 9th block
        //check row
        for (int row = 6; row < 9; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherCol = col + 1; otherCol < 9; otherCol++)
               {
                  if ((select == board[row][otherCol]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }
        
        //check the column
        for (int row = 6; row < 9; row++)
        {
            for(int col = 6; col < 9; col++)
            {
               int select = board[row][col];
               for (int otherRow = row + 1; otherRow < 9; otherRow++)
               {
                  if ((select == board[otherRow][col]) && (select != 0))
                  {
                     return true;
                  }
               }
            }
        }




                
        return false;

    }

    static int[][] extend(int[][] board) {
        int [][] temp = new int[9][9];
        //copy the board
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[i].length; j++)
            {
               temp[i][j] = board[i][j];
            }
        }
        
        //replace the first instance of 0 with a 1
        boolean found = false;
        while(!found)
        {
           for(int i = 0; i < temp.length; i++)
           {
               for(int j = 0; j < temp[i].length; j++)
               {
                  if(temp[i][j] == 0)
                  {
                     temp[i][j] = 1;
                     found = true;
                  }
                  //reached the end, exit the loop
                  if((i == 8) && (j == 8))
                  {
                     found = true;
                  }
               }
           }
        }
        
        return temp;
    }

    static int[][] next(int[][] board) {
        int[][] temp = new int [9][9];
        //copy the board
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[i].length; j++)
            {
               temp[i][j] = board[i][j];
            }
        }
        
        //find the first instance of 0
        boolean found = false;
        int x = 0;
        int y = 0;
        while(!found)
        {
           for(int i = 0; i < temp.length; i++)
           {
               for(int j = 0; j < temp[i].length; j++)
               {
                  if(temp[i][j] == 0)
                  {
                     x = i;
                     y = j;
                     found = true;
                  }
                  
                  //reached the end, exit the loop
                  if((i == 8) && (j == 8))
                  {
                     found = true;
                  }
               }
           }
        }
        extend(temp);
        if(reject(temp))
        {
            if((x == 0) && (y == 0))
            {
               
            }
            if((temp[x][y] < 8))
            {
               temp[x][y]++;
            }
            if(temp[x][y] == 8)
            {
               temp[x][y] = 0;
            }
       }
       
       return temp;
    }

     static void testIsFullSolutionUnit(int[][] test) {
        if (isFullSolution(test)) {
            System.err.println("Full sol'n:\t" + Arrays.toString(test));
        } else {
            System.err.println("Not full sol'n:\t" + Arrays.toString(test));
        }
    }

    static void testIsFullSolution() {
        // TODO: Complete this method
        System.out.println("Testing isFullSolution()");
        //Full Solutions
        int[][] fullA = new int[][]{
        {7, 2, 8, 9, 3, 5, 1, 6, 4},
        {4, 1, 9, 6, 2, 8, 7, 5, 3},
        {6, 5, 3, 4, 1, 7, 9, 8, 2},
        {1, 4, 5, 8, 6, 9, 3, 2, 7},
        {3, 7, 6, 2, 5, 1, 4, 9, 8},
        {9, 8, 2, 3, 7, 4, 5, 1, 6},
        {8, 6, 1, 5, 4, 3, 2, 7, 9},
        {5, 9, 4, 7, 8, 2, 6, 3, 1},
        {2, 3, 7, 1, 9, 6, 8, 4, 5},
        };
 
        int[][] fullB = new int[][]{
        {9, 6, 4, 7, 3, 1, 8, 5, 2},
        {2, 1, 8, 4, 5, 9, 7, 3, 6},
        {5, 3, 7, 6, 2, 8, 9, 1, 4},
        {1, 8, 3, 2, 7, 5, 4, 6, 9},
        {4, 9, 5, 1, 8, 6, 3, 2, 7},
        {6, 7, 2, 9, 4, 3, 5, 8, 1},
        {8, 4, 1, 5, 6, 7, 2, 9, 3},
        {3, 2, 9, 8, 1, 4, 6, 7, 5},
        {7, 5, 6, 3, 9, 2, 1, 4, 8},
        };
        
        testIsFullSolutionUnit(fullA);
        testIsFullSolutionUnit(fullB);
        
        //Partial Solutions
        int[][] partialA = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] partialB = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] partialC = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {4, 5, 6, 4, 1, 3, 7, 9, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] partialD = new int[][]{
        {5, 0, 0, 0, 0, 0, 0, 0, 0},
        {7, 0, 0, 0, 0, 0, 0, 0, 0},
        {4, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0, 0, 0, 0},
        {5, 0, 0, 0, 0, 0, 0, 0, 0},
        {8, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 0, 0, 0, 0, 0, 0, 0},
        {7, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        testIsFullSolutionUnit(partialA);
        testIsFullSolutionUnit(partialB);
        testIsFullSolutionUnit(partialC);
        testIsFullSolutionUnit(partialD);
    }
    
    static void testRejectUnit(int[][] test) {
        if (reject(test)) {
            System.out.println("Rejected:\t" + Arrays.toString(test));
        } else {
            System.out.println("Not rejected:\t" + Arrays.toString(test));
        }
    }
    
    static void testReject() {
        // TODO: Complete this method
        System.out.println("Testing testReject()");
         //Should not be rejected
        int[][] noRejectA = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] noRejectB = new int[][]{
        {7, 2, 8, 9, 3, 5, 1, 6, 4},
        {4, 1, 9, 6, 2, 8, 7, 5, 3},
        {6, 5, 3, 4, 1, 7, 9, 8, 2},
        {1, 4, 5, 8, 6, 9, 3, 2, 7},
        {3, 7, 6, 2, 5, 1, 4, 9, 8},
        {9, 8, 2, 3, 7, 4, 5, 1, 6},
        {8, 6, 1, 5, 4, 3, 2, 7, 9},
        {5, 9, 4, 7, 8, 2, 6, 3, 1},
        {2, 3, 7, 1, 9, 6, 8, 4, 5},
        };
        
        //Should be rejected
        int[][] rejectA = new int[][]{
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        };
        
        int[][] rejectB = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] rejectC = new int[][]{
        {1, 1, 1, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
         
        testRejectUnit(noRejectA);
        testRejectUnit(noRejectB);
        testRejectUnit(rejectA);
        testRejectUnit(rejectB);
        testRejectUnit(rejectC);
 

    }

    static void testExtendUnit(int[][] test) {
        System.out.println("Extended " + Arrays.toString(test) + " to " + Arrays.toString(extend(test)));
    }
    
    static void testExtend() {
        // TODO: Complete this method
        System.out.println("Testing testExtend()");
        
        //Cannot be extended
        int[][] noExtendA = new int[][]{
        {7, 2, 8, 9, 3, 5, 1, 6, 4},
        {4, 1, 9, 6, 2, 8, 7, 5, 3},
        {6, 5, 3, 4, 1, 7, 9, 8, 2},
        {1, 4, 5, 8, 6, 9, 3, 2, 7},
        {3, 7, 6, 2, 5, 1, 4, 9, 8},
        {9, 8, 2, 3, 7, 4, 5, 1, 6},
        {8, 6, 1, 5, 4, 3, 2, 7, 9},
        {5, 9, 4, 7, 8, 2, 6, 3, 1},
        {2, 3, 7, 1, 9, 6, 8, 4, 5},
        };
 
        int[][] noExtendB = new int[][]{
        {9, 6, 4, 7, 3, 1, 8, 5, 2},
        {2, 1, 8, 4, 5, 9, 7, 3, 6},
        {5, 3, 7, 6, 2, 8, 9, 1, 4},
        {1, 8, 3, 2, 7, 5, 4, 6, 9},
        {4, 9, 5, 1, 8, 6, 3, 2, 7},
        {6, 7, 2, 9, 4, 3, 5, 8, 1},
        {8, 4, 1, 5, 6, 7, 2, 9, 3},
        {3, 2, 9, 8, 1, 4, 6, 7, 5},
        {7, 5, 6, 3, 9, 2, 1, 4, 8},
        };
        
        

        
        //Can be extended
        int[][] extendA = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        
        int[][] extendB = new int[][]{
        {0, 2, 0, 0, 0, 0, 0, 0, 0},
        {4, 1, 9, 6, 2, 8, 7, 5, 3},
        {6, 5, 3, 4, 1, 7, 9, 8, 2},
        {1, 4, 5, 8, 6, 9, 3, 2, 7},
        {3, 7, 6, 2, 5, 1, 4, 9, 8},
        {9, 8, 2, 3, 7, 4, 5, 1, 6},
        {8, 6, 1, 5, 4, 3, 2, 7, 9},
        {5, 9, 4, 7, 8, 2, 6, 3, 1},
        {2, 3, 7, 1, 9, 6, 8, 4, 5},
        };
         
        testRejectUnit(noExtendA);
        testRejectUnit(noExtendB);
        testRejectUnit(extendA);
        testRejectUnit(extendB);
    }
      
      
      static void testNextUnit(int[][] test) {
        System.err.println("Nexted " + Arrays.toString(test) + " to " + Arrays.toString(next(test)));
     }
    
    static void testNext() {
        // TODO: Complete this method
        System.out.println("Testing testNext()");
        
        //Cannot go next()
        int[][] noNextA = new int[][]{
        {1, 4, 7, 2, 9, 6, 8, 5, 3},
        {8, 2, 9, 3, 1, 5, 7, 4, 6},
        {5, 3, 6, 8, 4, 7, 2, 1, 9},
        {7, 8, 4, 6, 5, 3, 1, 9, 2},
        {3, 1, 2, 9, 7, 8, 4, 6, 5},
        {9, 6, 5, 4, 2, 1, 3, 8, 7},
        {2, 5, 1, 7, 6, 4, 9, 3, 8},
        {6, 7, 3, 1, 8, 9, 5, 2, 4},
        {4, 9, 8, 5, 3, 2, 6, 7, 1},
        };
        
        int[][] noNextB = new int[][]{
        {9, 6, 4, 7, 3, 1, 8, 5, 2},
        {2, 1, 8, 4, 5, 9, 7, 3, 6},
        {5, 3, 7, 6, 2, 8, 9, 1, 4},
        {1, 8, 3, 2, 7, 5, 4, 6, 9},
        {4, 9, 5, 1, 8, 6, 3, 2, 7},
        {6, 7, 2, 9, 4, 3, 5, 8, 1},
        {8, 4, 1, 5, 6, 7, 2, 9, 3},
        {3, 2, 9, 8, 1, 4, 6, 7, 5},
        {7, 5, 6, 3, 9, 2, 1, 4, 8},
        };
        
        //Can go next()
        int[][] nextA = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
         
        int[][] nextB = new int[][]{
        {0, 2, 8, 9, 3, 5, 1, 0, 4},
        {4, 1, 9, 6, 2, 8, 7, 5, 3},
        {6, 5, 3, 4, 1, 7, 9, 8, 2},
        {1, 4, 5, 8, 0, 9, 3, 2, 7},
        {3, 7, 6, 2, 5, 1, 4, 9, 8},
        {9, 8, 2, 3, 7, 4, 5, 1, 6},
        {8, 6, 0, 5, 4, 3, 2, 7, 9},
        {5, 9, 4, 7, 8, 2, 6, 3, 1},
        {2, 3, 7, 1, 9, 6, 8, 4, 5},
        };
        
        testRejectUnit(noNextA);
        testRejectUnit(noNextB);
        testRejectUnit(nextA);
        testRejectUnit(nextB);


    }

    static void printBoard(int[][] board) {
        if (board == null) {
            System.out.println("No assignment");
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println("----+-----+----");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    static int[][] readBoard(String filename) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        } catch (IOException e) {
            return null;
        }
        int[][] board = new int[9][9];
        int val = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    val = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));
                } catch (Exception e) {
                    val = 0;
                }
                board[i][j] = val;
            }
        }
        return board;
    }

    static int[][] solve(int[][] board) {
        if (reject(board)) return null;
        if (isFullSolution(board)) return board;
        int[][] attempt = extend(board);
        while (attempt != null) {
            int[][] solution = solve(attempt);
            if (solution != null) return solution;
            attempt = next(attempt);
        }
        return null;
    }

    public static void main(String[] args) {
        if (args[0].equals("-t")) {
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
        } else {
            int[][] board = readBoard(args[0]);
            printBoard(board);
            printBoard(solve(board));
        }
    }
}

