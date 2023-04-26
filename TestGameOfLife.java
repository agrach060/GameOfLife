/**
 * @author Anna Gracheva
 * @version Minimal Level
 */
 
 /** This class tests which cell are alive 
  *or dead for creating the next generation
  */
public class TestGameOfLife {
    /**This method sets the initial board 
     *of the game. It sets up which cell are alive 
     *among the dead cells.
     */
    public static void setBoard(GameOfLife board) {
        // the two alive cells in the upper left
        board.setCellState(3, 4, GameOfLife.ALIVE);
        board.setCellState(4, 4, GameOfLife.ALIVE);
        // the block in the upper right
        board.setCellState(3, 13, GameOfLife.ALIVE);
        board.setCellState(3, 14, GameOfLife.ALIVE);
        board.setCellState(4, 13, GameOfLife.ALIVE);
        board.setCellState(4, 14, GameOfLife.ALIVE);
        // the beehive in the center
        board.setCellState(8, 7, GameOfLife.ALIVE);
        board.setCellState(8, 8, GameOfLife.ALIVE);
        board.setCellState(9, 6, GameOfLife.ALIVE);
        board.setCellState(9, 9, GameOfLife.ALIVE);
        board.setCellState(10, 7, GameOfLife.ALIVE);
        board.setCellState(10, 8, GameOfLife.ALIVE);
        // the glider in the lower left
        board.setCellState(15, 6, GameOfLife.ALIVE);
        board.setCellState(16, 4, GameOfLife.ALIVE);
        board.setCellState(16, 6, GameOfLife.ALIVE);
        board.setCellState(17, 5, GameOfLife.ALIVE);
        board.setCellState(17, 6, GameOfLife.ALIVE);
        // the blinker in the lower right
        board.setCellState(13, 13, GameOfLife.ALIVE);
        board.setCellState(13, 14, GameOfLife.ALIVE);
        board.setCellState(13, 15, GameOfLife.ALIVE);
    }
    
    // This method prints out the initial GameOfLife board 
    public static void main(String[] args) {
        GameOfLife life = null;
        life = new MyGameOfLife();
        setBoard(life);
        System.out.println("Starting point:");
        System.out.println(life.toString());
        System.out.println();
        // and prints out the next generation
        life.nextGeneration();
        System.out.println("First Generation:");
        System.out.println(life);
        System.out.println();
    
    }

}