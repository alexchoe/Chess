/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Choe
 */
public class Tile{ 
    int tileX;
    int tileY;
    Piece pieceOnTile;
    
    public Tile(int tileX, int tileY, Piece pieceOnTile){
        this.tileX = tileX;
        this.tileY = tileY;
        this.pieceOnTile = pieceOnTile;
    }
    
    public boolean isOccupied(){
        if(pieceOnTile == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void setPiece(Piece piece){
        pieceOnTile = piece;
    }
    public Piece getPiece(){
        return this.pieceOnTile;
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }
    
}
