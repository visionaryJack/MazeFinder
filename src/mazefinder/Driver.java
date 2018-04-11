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
    private static int direction = 1;
    private char[][] arrayIn = new char[][]{
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
    private Maze mazeOne;
    public Driver() {
        mazeOne = new Maze(arrayIn);
        mazeOne.setPlayerX(0);
        mazeOne.setPlayerY(2);
        mazeOne.setPlayerPos(mazeOne.getPlayerY(), mazeOne.getPlayerX());
    }
    //method to find finish
    public void findPath(){
        
        //start of recursion loop
        if(mazeOne.seeCurrent() == 'F'){
            printAr();
            System.out.println("Finish Found");
        }
        else{
            mazeOne.setPlayerPos(mazeOne.getPlayerY(), mazeOne.getPlayerX());
                    printAr();
                    System.out.println("");
            //4 direction slots of logic for recursion to run down, 
            if (direction == 1){//facing east, if right hand open take south, else rotate 90degree left, facing north. find path North.
                mazeOne.setHandX(mazeOne.getPlayerX());
                mazeOne.setHandY(mazeOne.getPlayerY()+1);
                if(checkHand() == true){
                    forwardSouth();
                    direction = 4;
                    findPath();
                }else{
                    direction = 2;
                    findPath();
                }
            }
            if (direction == 2) {//facing north, if right hand open, take west, else rotate
                mazeOne.setHandX(mazeOne.getPlayerX()+1);
                mazeOne.setHandY(mazeOne.getPlayerY());
                if(checkHand() == true){
                    forwardEast(); 
                    direction = 1;
                    findPath();
                }else{
                    direction = 3;
                    findPath();
                }
                
            }
            if (direction == 3) {//facing west, if right hand open take north, else rotate 
                mazeOne.setHandX(mazeOne.getPlayerX());
                mazeOne.setHandY(mazeOne.getPlayerY()-1);
                if(checkHand() == true){
                    forwardNorth();
                    direction = 2;
                    findPath();
                }else{
                    direction = 4;
                    findPath();
                }
                
                
            }
            if (direction == 4) {//facing south, if right hand open take west, else turn left to east
                mazeOne.setHandX(mazeOne.getPlayerX()-1);
                mazeOne.setHandY(mazeOne.getPlayerY());
                if(checkHand() == true){
                    forwardWest();
                    direction = 3;
                    findPath();
                }else{
                    direction = 1;
                    findPath();
                }
            }
        }
        
    }
    //print method
    private void forwardEast(){
        mazeOne.setMazeAr(mazeOne.getPlayerY(), mazeOne.getPlayerX(), 'X');
        mazeOne.setPlayerX(mazeOne.getPlayerX() + 1);
    }
    private void forwardNorth(){
        mazeOne.setMazeAr(mazeOne.getPlayerY(), mazeOne.getPlayerX(), 'X');
        mazeOne.setPlayerY(mazeOne.getPlayerY() - 1);
    }
    private void forwardWest(){
        mazeOne.setMazeAr(mazeOne.getPlayerY(), mazeOne.getPlayerX(), 'X');
        mazeOne.setPlayerX(mazeOne.getPlayerX() - 1);
    }
    private void forwardSouth(){
        mazeOne.setMazeAr(mazeOne.getPlayerY(), mazeOne.getPlayerX(), 'X');
        mazeOne.setPlayerY(mazeOne.getPlayerY() + 1);
    }
    public void printAr(){
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 12; x++){
                System.out.print(" " + mazeOne.getMazeAr()[y][x]);
            }
            System.out.println();
        }
        
    }
    public boolean checkHand(){
        if(mazeOne.getMazeAr()[mazeOne.getHandY()][mazeOne.getHandX()] == '#'){
            return false;
        }
        return true;
    }
}
