/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazefinder;

/**
 * Program to take a maze array of chars, with starting position on edge, find start
 * then recursively find finish marked with F
 * @author John Watts
 */
public class MazeFinder {
    private static final char[][] arIn = new char[][]{//maze array in
            {'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','.','.','.','#'},
            {'.','.','#','.','#','.','#','#','#','#','.','#'},
            {'#','#','#','.','#','.','.','.','.','#','.','#'},
            {'#','.','.','.','.','#','#','#','.','#','.','#'},
            {'#','#','#','#','.','#','F','#','.','#','.','#'},
            {'#','.','.','#','.','#','.','#','.','#','.','#'},
            {'#','#','.','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','#'},
            {'#','#','#','#','.','#','.','#','#','#','.','#'},
            {'#','.','.','.','.','#','.','#','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'},
            };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Driver runMaze = new Driver(arIn);
       runMaze.findStart();//finds and sets start values and direction
       runMaze.findPath();//recursivly prints while finding finish
       
    }
}
