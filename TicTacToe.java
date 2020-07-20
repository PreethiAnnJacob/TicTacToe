/* Tic Tac Toe
Preethi Ann Jacob 19-07-2020
*/
import java.io.*;
class TicTacToe
{   //Display the board
    static void showBoard(char board[][])
    {   for(int i=0;i<3;i++)
        {   for(int j=0;j<3;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }
    //Evaluate the board score for current board state
    static int evaluate(char board[][])
    {   //check rows for winner
        for(int i=0;i<3;i++)
        {   if(board[i][0]=='X' && board[i][1]=='X' && board[i][2]=='X')    return 10;
            if(board[i][0]=='O' && board[i][1]=='O' && board[i][2]=='O')    return -10;
        }
        
        //check columns for winner
        for(int j=0;j<3;j++)
        {   if(board[0][j]=='X' && board[1][j]=='X' && board[2][j]=='X')    return 10;
            if(board[0][j]=='O' && board[1][j]=='O' && board[2][j]=='O')    return -10;
        }
        
        //check diagonals for winner
        
        //right diagonal check
        if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')    return 10;
        if(board[0][0]=='O' && board[1][2]=='O' && board[2][2]=='O')    return -10;
        
        //left diagonal check
        if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X')    return 10;
        if(board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O')    return -10;
        
        //Tied or none have won
        return 0;
    }
    //Moves left or not
    static boolean isMovesLeft(char board[][])
    {   for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]=='_')
                    return true;
        return false;
    }
    
    static int minMax(char board[][],int depth,boolean isMax)
    {   int score=evaluate(board);
        if(score==10 || score==-10)//Somebody Won
            return score;
        if(score==0 && !isMovesLeft(board))//Tie
            return 0;
        //The chance is of Maximiser
        if(isMax)
        {   int best=-1000;//minus infinity
            for(int i=0;i<3;i++)
            {   for(int j=0;j<3;j++)
                {   if(board[i][j]=='_')
                    {   board[i][j]='X';//Make the move
                        best=Math.max(best,minMax(board,depth+1,!isMax));
                        board[i][j]='_';//Undo the move
                    }
                }
            }
            return best;
        }
        //The chance is of the minimiser
        else
        {   int best=1000;//infinity
            for(int i=0;i<3;i++)
            {   for(int j=0;j<3;j++)
                {   if(board[i][j]=='_')
                    {   board[i][j]='O';//Make the move
                        best=Math.min(best,minMax(board,depth+1,!isMax));
                        board[i][j]='_';//Undo the move
                    }
                }
            }
            return best;
        }
    }
    public static void main()
    {   //board of 3X3
        char board[][]={    {'_','_','_'},
                            {'_','_','_'},
                            {'_','_','_'}
                       };
        char chance='X';
        do
        {   if(chance=='X')
            {   int bestVal=-1000;//minus infinity
                int bestMoveRow=-1;
                int bestMoveCol=-1;
                for (int i=0;i<3;i++)
                {   for(int j=0;j<3;j++)
                    {   if(board[i][j]=='_')
                        {   board[i][j]='X';//make the move
                            int moveVal=minMax(board,0,false);
                            board[i][j]='_';//undo the move
                            if(moveVal>bestVal)
                            {   bestVal=moveVal;
                                bestMoveRow=i;
                                bestMoveCol=j;
                            }  
                        }
                    }
                }
                board[bestMoveRow][bestMoveCol]='X';//X makes the best move
                System.out.println("X makes move at"+bestMoveRow+","+bestMoveCol);
                chance='O';
            }
            else
            {   int bestVal=1000;//infinity
                int bestMoveRow=-1;
                int bestMoveCol=-1;
                for (int i=0;i<3;i++)
                {   for(int j=0;j<3;j++)
                    {   if(board[i][j]=='_')
                        {   board[i][j]='O';//make the move
                            int moveVal=minMax(board,0,true);
                            board[i][j]='_';//undo the move
                            if(moveVal<bestVal)
                            {   bestVal=moveVal;
                                bestMoveRow=i;
                                bestMoveCol=j;
                            }  
                        }
                    }
                }
                board[bestMoveRow][bestMoveCol]='O';//O makes the best move
                System.out.println("O makes move at"+bestMoveRow+","+bestMoveCol);
                chance='X';
            }
            System.out.println("Current Board State:");
            showBoard(board);
            int score=evaluate(board);
            if(score==10)                               {System.out.println("X WON");break;}
            else if(score==-10)                         {System.out.println("O WON");break;}
            else if(score==0 && !isMovesLeft(board))    {System.out.println("TIE");break;}
        }while(true);
    }
}
