/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazefinder;

/**
 *
 * @author 10kwa
 */
public class Driver {
    private Maze mazeOne;
    public Driver() {
        mazeOne = new Maze();
    }
    public void findPath(){
        mazeOne.setPlayerX(0);
        mazeOne.setPlayerY(2);
        mazeOne.setPlayerPos(mazeOne.getPlayerY(), mazeOne.getPlayerX());
        printAr();
    }
    public void printAr(){
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 12; x++){
                System.out.print(" " + mazeOne.getMazeAr()[y][x]);
            }
            System.out.println();
        }
        
    }
}
