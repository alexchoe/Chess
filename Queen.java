/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Choe
 */
public class Queen extends Piece{
    public Queen(int x, int y, String n, boolean w){
        super(x, y, n, w);
    }
    @Override
    public boolean canMove(Tile start, Tile end){
        if(tileAvailable(end) == true){
            int x = Math.abs(start.getTileX() - end.getTileX());
            int y = Math.abs(start.getTileY() - end.getTileY());
            boolean a; 
            boolean b = false;
            a = (y == 0 ^ x == 0);
            if(a == false){
                try{
                    b = (y/x == 1);
                }catch(Exception e){
                
                }
            }
            return a||b;
        }
        return false;
    }
    @Override
    public boolean tileAvailable(Tile tile){
        if(tile.isOccupied() == false || tile.getPiece().getIsWhite() != this.getIsWhite()){
            return true;
        }
        else{
            return false;
        }
    }
    
}

