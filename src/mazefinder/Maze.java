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
//maze class create array of char's has methods to operate array
public class Maze {
    private int playerY;
    private int playerX; 
    private int handY; 
    private int handX; 
    private static char [][] mazeAr;
    public Maze(char[][] in) {
        mazeAr = in;
        //playerX = 0;
        //playerY = 2;
        //handX = 0;
        //handY = 4;
    }
    //set methods
    public void setPlayerY(int a) {
        playerY = a;
}
    public void setPlayerX(int a) {
        playerX = a;
    }
    public void setHandY(int a) {
        handY = a;
    }
    public void setHandX(int a) {
        handX = a;
    }
    public void setMazeAr(int a, int b, char c) {//set array value, used to mark X
        mazeAr[a][b] = c;
    }
    public void setPlayerPos(int a, int b){//set position marker
        setMazeAr(a, b, 'O');
    }
    //get methods
    public int getPlayerX() {
        return playerX;
    }
    public int getPlayerY() {
        return playerY;
    }
    public int getHandX() {
        return handX;
    }
    public int getHandY() {
        return handY;
    }
    public char[][] getMazeAr() {
        return mazeAr;
    }
    public char seeCurrent() {
        return mazeAr[playerY][playerX];
    }
    
}

