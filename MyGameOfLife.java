/**
 * @author Anna Gracheva
 * @version Minimal Level
 */
 
 /**Class implements methods from the class GameOfLife,
  *creates a 19x19 board, and sets all of the initial cells equal to "."
  */
public class MyGameOfLife implements GameOfLife{

  char board[][];
  
  public MyGameOfLife() {
    board = new char[19][19];
    for( int i = 0 ; i < 19 ; i++)
      for (int j = 0; j < 19; j++)
        board[i][j] = '.';
    
  }

  
  //Method checks which cells are dead and which are alive
  @Override
  public int getCellState(int row, int col) {
    if(board[row][col] == 'O')
      return 1;
    
    return 0;
  }

  //Method assigns graphic symbols to alive and dead cells  
  @Override
  public void setCellState(int row, int col, int state) {
    if(state == 1) 
      board[row][col] = 'O';
    else
      board[row][col] = '.';
  }

  //Method creates a board of next generation 
  @Override
  public void nextGeneration() {
    char temp[][] = new char[19][19];
    for( int i = 0 ; i < 19 ; i++) 
      for (int j = 0; j < 19; j++) 
      {
        int c = getAliveCount(i, j);
        if ( c == 3)
          temp[i][j] = 'O';
        else if( board[i][j] == '.' && c != 3)
          temp[i][j] = '.';
        else if( board[i][j] == 'O' && (c == 3 || c == 2))
          temp[i][j] = 'O';
        else if( board[i][j] == 'O' && c < 2)
          temp[i][j] = '.';
        else if( board[i][j] == 'O' && c > 3)
          temp[i][j] = '.';
      }
    
    board = temp;
    temp = null;
  }
  //Method prints out a board with cells
  @Override
  public String toString() {
    String s = "";
    for( int i = 0 ; i < 19 ; i++) {
      for (int j = 0; j < 19; j++) {
        s = s + board[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }
  
  private boolean isValid(int row, int col)
  {
    if(row < 0 || row >= 19 || col < 0 || col >= 19 )
      return false;
    
    return true;
  }
  
  private int getAliveCount(int row, int col)
  {
    int count = 0;
    
    for(int i = -1; i <= 1 ; i++)
      for( int j = -1 ; j <= 1 ; j++)
        if((i != 0 || j != 0) && isValid(i+row, j+col) && board[i+row][j+col] == 'O')
          count++;
    return count;
  }
  
}
