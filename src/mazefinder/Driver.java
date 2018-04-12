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
    
    private Maze mazeOne;
    public Driver(char[][] arrayIn) {
        mazeOne = new Maze(arrayIn);
        //mazeOne.setPlayerX(0);
        //mazeOne.setPlayerY(2);
        //mazeOne.setPlayerPos(mazeOne.getPlayerY(), mazeOne.getPlayerX());
    }
    //method to find finish
    public void findPath(){
        
        //start of recursion loop
        if(mazeOne.seeCurrent() == 'F'){//clause out when finish found
            
            printAr();
            System.out.println("Finish Found");
        }
        else{
            mazeOne.setPlayerPos(mazeOne.getPlayerY(), mazeOne.getPlayerX());
                    printAr();
                    System.out.println("");
            //4 direction slots of logic for recursion to run down,
            switch (direction) {
                case 1:
                    //facing east, if right hand open take south, else rotate 90degree left, facing north. find path North.
                    mazeOne.setHandX(mazeOne.getPlayerX());
                    mazeOne.setHandY(mazeOne.getPlayerY()+1);
                    if(checkHand() == true){
                        forwardSouth();
                        direction = 4;
                        findPath();
                    }else{
                        direction = 2;
                        findPath();
                    }   break;
                case 2:
                    //facing north, if right hand open, take west, else rotate
                    mazeOne.setHandX(mazeOne.getPlayerX()+1);
                    mazeOne.setHandY(mazeOne.getPlayerY());
                    if(checkHand() == true){
                        forwardEast();
                        direction = 1;
                        findPath();
                    }else{
                        direction = 3;
                        findPath();
                    }   break;
                case 3:
                    //facing west, if right hand open take north, else rotate
                    mazeOne.setHandX(mazeOne.getPlayerX());
                    mazeOne.setHandY(mazeOne.getPlayerY()-1);
                    if(checkHand() == true){
                        forwardNorth();
                        direction = 2;
                        findPath();
                    }else{
                        direction = 4;
                        findPath();
                    }   break;
                case 4:
                    //facing south, if right hand open take west, else turn left to east
                    mazeOne.setHandX(mazeOne.getPlayerX()-1);
                    mazeOne.setHandY(mazeOne.getPlayerY());
                    if(checkHand() == true){
                        forwardWest();
                        direction = 3;
                        findPath();
                    }else{
                        direction = 1;
                        findPath();
                    }   break;
                default:
                    break;
            }
        } 
    }
    //print method
    private void forwardEast(){//move player pos foward direction of hand
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
    public void printAr(){//print array
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 12; x++){
                System.out.print(" " + mazeOne.getMazeAr()[y][x]);
            }
            System.out.println();
        }
        
    }
    public boolean checkHand(){//check to see if can move direction of hand
        if(mazeOne.getMazeAr()[mazeOne.getHandY()][mazeOne.getHandX()] == '#'){
            return false;
        }
        return true;
    }
    public void findStart(){//method to test edges of 12x12 array and find '.' as start
        for(int i = 0; i < mazeOne.getMazeAr().length; i++){ //look at top of array for start
            if(mazeOne.getMazeAr()[0][i] == '.'){
                mazeOne.setPlayerX(i);
                mazeOne.setPlayerY(0);
            }
            
        }
        for(int i = 0; i < mazeOne.getMazeAr().length; i++){ //look at left side of array for start
            if(mazeOne.getMazeAr()[i][0] == '.'){
                mazeOne.setPlayerX(0);
                mazeOne.setPlayerY(i);
            }
        }
        for(int i = 0; i < mazeOne.getMazeAr().length; i++){ //look at bottom of array for start
            if(mazeOne.getMazeAr()[11][i] == '.'){
                mazeOne.setPlayerX(i);
                mazeOne.setPlayerY(11);
                direction = 2;
            }
        }
        for(int i = 0; i < mazeOne.getMazeAr().length; i++){ //look at right side of array for start
            if(mazeOne.getMazeAr()[i][11] == '.'){
                mazeOne.setPlayerX(11);
                mazeOne.setPlayerY(i);
                direction = 3;
            }
        }
        
    }
}
