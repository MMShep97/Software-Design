import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Marc Shepherd
 * @version 1.0, 11/6/2018
 * @since SDK 1.8
 *
 * Holds all methods relating to the solving of a 2D character maze
 */

public class SolveMaze {

    /**
     * STARTING_ROW, STARTING_COL -- allows for setting of boolean variable atStart to check if at starting indice
     * atStart -- true if at start, false otherwise
     * solved -- true if solved, false otherwise; part of base condition
     * finished -- true if finished, false otherwise; part of base condition
     */
    private final int STARTING_ROW, STARTING_COL;
    private boolean atStart, solved, finished;

    /**
     * Sets initial atStart to true, solved to false, and finished to false
     * @param row -- brings in user input for maze
     * @param col -- brings in user input for maze
     */
    SolveMaze(int row, int col) {
        this.STARTING_ROW = row;
        this.STARTING_COL = col;
        this.atStart = true;
        this.solved = false;
        this.finished = false;
    }

    /**
     * Maneuvers through maze, putting an x for traversed paths & replaces current location with '@' at each step if the path
     * results in a dead end.
     * @param maze -- brings in specified maze in main method
     * @param row -- current row in path -- changes based on current recursive step
     * @param col -- current col in path -- changes based on current recursive step
     * @return boolean -- true if maze solved, false otherwise
     * @throws InterruptedException -- simulated maze completion time for visibility --> remove TimeUnit.MILLISECONDS.sleep if unwanted
     */
    public boolean mazeTraversal(char[][] maze, int row, int col) throws InterruptedException {

        //Print at each recursive step
        printMaze(maze);
        TimeUnit.MILLISECONDS.sleep(400); //For simulated traversal time

        //Check for starting area
        atStart = (STARTING_ROW == row) && (STARTING_COL == col);

        //Only set maze as finished if not at the beginning
        if (!atStart && ( row == 0 || row == maze.length - 1 || col == 0 || col == maze.length - 1 )) {
            finished = true;
            maze[row][col] = 'x';
        }
            //BASE CASE PART 1
            //If not at the start of the maze and the maze is finished, it is solved
            if (!atStart && finished) {
                solved = true;
                return true;
            }
            //BASE CASE PART 2
            //If at the start of the maze and the maze is finished, it could not be solved
            if (atStart && finished) return false;

            //check down for '.', then call recursively
            if (row < maze.length - 1 && maze[row + 1][col] == '.' ) {
                maze[row][col] = 'x';
                mazeTraversal(maze, row + 1, col);
            }
            //right
            else if (col < maze[row].length - 1 && maze[row][col + 1] == '.') {
                maze[row][col] = 'x';
                mazeTraversal(maze, row, col + 1);
            }
            //up
            else if (row > 0 && maze[row - 1][col] == '.') {
                maze[row][col] = 'x';
                mazeTraversal(maze, row - 1, col);
            }
            //left
            else if (col > 0 && maze[row][col - 1] == '.') {
                maze[row][col] = 'x';
                mazeTraversal(maze, row, col - 1);
            }
            //otherwise
            else {
                maze[row][col] = 'x';
            }

            /************Start backtracking************/

            //Only backtrack if still checking for a path
            if (!finished) {
                //Check for edge to stop an ArrayOutOfBounds
                //check down for 'x', then call recursively
                if (row < maze.length - 1 && maze[row + 1][col] == 'x') {
                    maze[row][col] = '@';
                    mazeTraversal(maze, row + 1, col);
                }
                //right
                else if (col < maze[row].length - 1 && maze[row][col + 1] == 'x') {
                    maze[row][col] = '@';
                    mazeTraversal(maze, row, col + 1);
                }
                //up
                else if (row > 0 && maze[row - 1][col] == 'x') {
                    maze[row][col] = '@';
                    mazeTraversal(maze, row - 1, col);
                }
                //left
                else if (col > 0 && maze[row][col - 1] == 'x') {
                    maze[row][col] = '@';
                    mazeTraversal(maze, row, col - 1);
                }
            }
        //Print maze one last time
        printMaze(maze);
        //True if path found, false otherwise
        return solved;
    }

    /**
     * prompts user for row selection in maze
     * @return  row -- subtracts one to use for indice
     * @throws IOException incase of illegal input
     */
    public static int chooseRow() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select the row you would like");
        boolean flag = true;

        while (flag) {
            try {
                return Integer.parseInt(input.readLine()) - 1; //Subtract one for indice (length - 1)
            }
            catch (NumberFormatException ex) {
                System.err.println("Error - illegal action performed - try again");
            }
        }
        return 0;
    }

    /**
     * prompts user for column selection in maze
     * @return  column -- subtracts one to use for indice
     * @throws IOException incase of illegal input attempt
     */
    public static int chooseColumn() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select the column you would like");
        boolean flag = true;

        while (flag) {
            try {
                return Integer.parseInt(input.readLine()) - 1; //Subtract one for the indice (length - 1)
            }
            catch (NumberFormatException ex) {
                System.err.println("Error - illegal action performed - try again");
            }
        }
        return 0;
    }

    /**
     * Prints out maze
     * @param maze -- brings in the maze from main method
     */
    private static void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(" " + maze[i][j] + " ");
            }
            System.out.println();
        }
        //Spacing of maze prints
        System.out.println();System.out.println();System.out.println();
    }

    /**
     * Prints the maze with row and column numbers for easy user input -- only prints on the start menu
     * @param maze -- brings in the maze from main method
     */
    public static void printMazeforStartMenu(char[][] maze) {

            int rowCount = 1;
            int colCount = 1;

            for (int i = 0; i < maze.length; i++) {
                if (rowCount < 10) System.out.print(" ");
                System.out.print(rowCount + " ");
                for (int j = 0; j < maze[i].length; j++) {
                    System.out.print(" " + maze[i][j] + " ");
                }
                rowCount++;
                System.out.println();
            }
            System.out.print("   ");
            for (int c = 0; c < maze[0].length; c++) {

                if (colCount < 10) System.out.print(" ");
                System.out.print(colCount + " ");
                colCount++;
            }
            System.out.println();
        }
}
