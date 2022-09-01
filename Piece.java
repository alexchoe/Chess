/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Choe
 */
public abstract class Piece {
    private int PosX;
    private int PosY;
    private String name;
    private boolean isWhite;
    private boolean canMove;
    
    public Piece(int x, int y, String n, boolean w){
        PosX = x;
        PosY = y;
        name = n;
        isWhite = w;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int x) {
        PosX = x;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int y) {
        PosY = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public void setIsWhite(boolean w) {
        isWhite = w;
    }

    public abstract boolean canMove(Tile start, Tile end);
    
    public abstract boolean tileAvailable(Tile tile);
    
}
