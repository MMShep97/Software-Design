import java.util.*;
import java.io.*;

/*
    # # # # # # # # # # # #
    # . . . # . . . . . . #
    . . # . # . # # # # . #
    # # # . # . . . . # . #
    # . . . . # # # . # . .
    # # # # . # . # . # . #
    # . . # . # . # . # . #
    # # . # . # . # . # . #
    # . . . . . . . . # . #
    # # # # # # . # # # . #
    # . . . . . . # . . . #
    # # # # # # # # # # # #
 */

/**
 * @author Marc Shepherd
 * @version 1.0, 11/6/2018
 * @since SDK 1.8
 *
 * Interfaces with user and utilizes the SolveMaze class to determine whether the maze shown below is solvable or not, and which
 * path the user can take to get through it, as denoted by 'x', and dead-ends denoted with '@'. The available paths are denoted with
 * '.' and the blocking paths, or walls, are denoted by '#'.
 */

public class MazeTraversalMain {

    public static void main(String [] args) throws IOException, InterruptedException {

        //Template maze -- change to your desire
        char [][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '.'},
            {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#'},
            {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        //Opening explanation & prompt
        System.out.println("-- Welcome to the maze traversal program! --");
        System.out.println("-- Select the entry point for your maze. --\n" +
                           "-- For template: pick row 3, column 1 --");

        //Prints maze for user reference
        System.out.println("\n-- The maze for reference --");
        SolveMaze.printMazeforStartMenu(maze);

        //User inputs desired row & column to start in maze
        int row = SolveMaze.chooseRow();
        int column = SolveMaze.chooseColumn();

        //SolveMaze object that brings in  the desired row & column to determine maze solvability.
        SolveMaze solver = new SolveMaze(row, column);
        boolean solved = solver.mazeTraversal(maze, row, column);

        //Ternary to deal with true/false relationship
        System.out.println(solved ? "The maze has been solved!" : "The maze could not be solved!");
    }
}
