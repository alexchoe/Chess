/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Choe
 */
public class King extends Piece{
    public King(int x, int y, String n, boolean w){
        super(x, y, n, w);
    }
    @Override
    public boolean canMove(Tile start, Tile end){
        if(tileAvailable(end) == true){
            int x = Math.abs(start.getTileX() - end.getTileX());
            int y = Math.abs(start.getTileY() - end.getTileY());
            if((y==0||y==1)&&(x==0||x==1)){
                return true;
            }
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

