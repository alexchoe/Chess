/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Alex Choe
 */

public class ChessGUI extends JFrame implements ActionListener {
    private JButton[][] buttons;
    Font f = new Font("SansSerif", Font.BOLD, 30);
    
    private JPanel panel = new JPanel();
    private JLabel win = new JLabel("hello");
    private Color beige = new Color(252, 238, 199);
    private Color maroon = new Color(77, 62, 50);    
    
    private Tile[][] tiles = new Tile[8][8];
    int tempX = 8;
    int tempY = 8;
    int move = 0;
    
    boolean b;
    
    public ChessGUI(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.setLayout(new GridLayout(8, 8, 0, 0));
        buttons = new JButton[8][8];
        
        //White pieces
        tiles[6][0] = new Tile(6, 0, new Pawn(6, 0, "pawn", true));
        tiles[6][1] = new Tile(6, 1, new Pawn(6, 1, "pawn", true));
        tiles[6][2] = new Tile(6, 2, new Pawn(6, 2, "pawn", true));
        tiles[6][3] = new Tile(6, 3, new Pawn(6, 3, "pawn", true));
        tiles[6][4] = new Tile(6, 4, new Pawn(6, 4, "pawn", true));
        tiles[6][5] = new Tile(6, 5, new Pawn(6, 5, "pawn", true));
        tiles[6][6] = new Tile(6, 6, new Pawn(6, 6, "pawn", true));
        tiles[6][7] = new Tile(6, 7, new Pawn(6, 7, "pawn", true));
        tiles[7][0] = new Tile(7, 0, new Rook(7, 0, "rook", true));
        tiles[7][1] = new Tile(7, 1, new Bishop(7, 1, "bishop", true));
        tiles[7][2] = new Tile(7, 2, new Knight(7, 2, "knight", true));
        tiles[7][3] = new Tile(7, 3, new King(7, 3, "king", true));
        tiles[7][4] = new Tile(7, 4, new Queen(7, 4, "queen", true));
        tiles[7][5] = new Tile(7, 5, new Knight(7, 5, "knight", true));
        tiles[7][6] = new Tile(7, 6, new Bishop(7, 6, "bishop", true));
        tiles[7][7] = new Tile(7, 7, new Rook(7, 7, "rook", true));
        
        //Black pieces
        tiles[1][0] = new Tile(1, 0, new Pawn(1, 0, "pawn", false));
        tiles[1][1] = new Tile(1, 1, new Pawn(1, 1, "pawn", false));
        tiles[1][2] = new Tile(1, 2, new Pawn(1, 2, "pawn", false));
        tiles[1][3] = new Tile(1, 3, new Pawn(1, 3, "pawn", false));
        tiles[1][4] = new Tile(1, 4, new Pawn(1, 4, "pawn", false));
        tiles[1][5] = new Tile(1, 5, new Pawn(1, 5, "pawn", false));
        tiles[1][6] = new Tile(1, 6, new Pawn(1, 6, "pawn", false));
        tiles[1][7] = new Tile(1, 7, new Pawn(1, 7, "pawn", false));
        tiles[0][0] = new Tile(0, 0, new Rook(0, 0, "rook", false));
        tiles[0][1] = new Tile(0, 1, new Bishop(0, 1, "bishop", false));
        tiles[0][2] = new Tile(0, 2, new Knight(0, 2, "knight", false));
        tiles[0][3] = new Tile(0, 3, new Queen(0, 3, "queen", false));
        tiles[0][4] = new Tile(0, 4, new King(0, 4, "king", false));
        tiles[0][5] = new Tile(0, 5, new Knight(0, 5, "knight", false));
        tiles[0][6] = new Tile(0, 6, new Bishop(0, 6, "bishop", false));
        tiles[0][7] = new Tile(0, 7, new Rook(0, 7, "rook", false));
        
        for(int i = 2;i<6;i++){
            for(int j = 0;j<8;j++){
                tiles[i][j] = new Tile(i, j, null);
            }
        }
        
        
        
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1){
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBackground(beige);
                } 
                else{
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBackground(maroon);
                }
                if(i == 1){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Bpawn.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 0 && (j == 0 || j == 7)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Brook.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 0 && (j == 1 || j == 6)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Bbishop.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 0 && (j == 2 || j == 5)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Bknight.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 0 && j==3){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Bqueen.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 0 && j==4){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Bking.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 6){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wpawn.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 7 && (j == 0 || j == 7)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wrook.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 7 && (j == 1 || j == 6)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wbishop.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 7 && (j == 2 || j == 5)){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wknight.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 7 && j == 3){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wking.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                else if(i == 7 && j == 4){
                    ImageIcon icon = new ImageIcon(ChessGUI.class.getResource("Wqueen.png"));
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                    icon = new ImageIcon(newimg);
                    buttons[i][j] = new JButton(icon);
                    panel.add(buttons[i][j]);                    
                }
                setBackground(i, j);
                //buttons[i][j].setFont(f);
                buttons[i][j].addActionListener(this);
                panel.add(buttons[i][j]);
            }
        }
        
        
        this.add(panel);
        setVisible(true);
        
    }
    public void setBackground(int i, int j){
        if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1){
            buttons[i][j].setBackground(beige);
        } 
        else{
            buttons[i][j].setBackground(maroon);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if (e.getSource() == buttons[i][j]) {
                    b = true;
                    if(move%2 == 0){
                        if(tiles[i][j].getPiece() == null){
                            break;
                        }
                    }
                    if(move%2 == 1){
                        try{
                            if(tiles[i][j].getPiece().getIsWhite() == tiles[tempX][tempY].getPiece().getIsWhite()){
                                b = false;
                            }
                        }catch(Exception e2){
                            
                        }
                        if(b == true){
                            try{
                                System.out.println("hello");
                                System.out.println(tiles[tempX][tempY].getPiece().canMove(tiles[tempX][tempY], tiles[i][j]));


                                if(tiles[tempX][tempY].getPiece().canMove(tiles[tempX][tempY], tiles[i][j])){

                                    ImageIcon icon = new ImageIcon(getIcon(tiles[tempX][tempY].getPiece()));
                                    Image image = icon.getImage();
                                    Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                                    icon = new ImageIcon(newimg);

                                    buttons[i][j].setIcon(icon);

                                    ImageIcon icon2 = new ImageIcon("");
                                    Image image2 = icon2.getImage();
                                    Image newimg2 = image2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);  
                                    icon2 = new ImageIcon(newimg2);

                                    buttons[tempX][tempY].setIcon(icon2);

                                    tiles[i][j].setPiece(tiles[tempX][tempY].getPiece());
                                    tiles[tempX][tempY].setPiece(null);
                                }
                            }catch(Exception ex){

                            }
                        }
                    }
                    tempX = i;
                    tempY = j;
                    
                    if(b == true){
                        move++;       
                    }
                    checkWin();
                }
            }
        }
    }
    
    public void checkWin(){
        int num = 0;
        String color;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                try{
                    if(tiles[i][j].getPiece().getName() == "king"){
                        num++;
                    }
                }catch(Exception e2){
                
                }
            }
        }
        if(num == 1){
            for(int i = 0; i<8; i++){
                for(int j = 0; j<8; j++){
                    try{    
                        if(tiles[i][j].getPiece().getName() == "king"){
                            if(tiles[i][j].getPiece().getIsWhite() == true){
                                color = "White";
                            }
                            else{
                                color = "Black";
                            }
                            
                            for(i = 0; i<8;i++){
                                for(j = 0; j<8;j++){
                                    panel.remove(buttons[i][j]);
                                }
                            }
                            
                            
                            
                            panel.setLayout(new FlowLayout());
                            panel.setBackground(new Color(255, 224, 158));
                            win.setText(color + " wins");
                            win.setPreferredSize(new Dimension(400, 100));
                            
                            win.setHorizontalAlignment(JLabel.CENTER);
                            win.setFont(f);
                            panel.add(win);
                            
                        }
                    }catch(Exception e3){
                        
                    }
                }
            }       
        }
    }
    
    public String getIcon(Piece piece){
        if(piece.getName()=="pawn" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wpawn.png").toString();
        }
        else if(piece.getName()=="pawn" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Bpawn.png").toString();
        }
        else if(piece.getName()=="rook" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wrook.png").toString();
        }
        else if(piece.getName()=="rook" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Brook.png").toString();
        }
        else if(piece.getName()=="bishop" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wbishop.png").toString();
        }
        else if(piece.getName()=="bishop" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Bbishop.png").toString();
        }
        else if(piece.getName()=="knight" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wknight.png").toString();
        }
        else if(piece.getName()=="knight" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Bknight.png").toString();
        }
        else if(piece.getName()=="king" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wking.png").toString();
        }
        else if(piece.getName()=="king" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Bking.png").toString();
        }
        else if(piece.getName()=="queen" && piece.getIsWhite()==true){
            return ChessGUI.class.getResource("Wqueen.png").toString();
        }
        else if(piece.getName()=="queen" && piece.getIsWhite()==false){
            return ChessGUI.class.getResource("Bqueen.png").toString();
        }
        else{
            return"";
        }
    }
    public static void main(String[] args){
        new ChessGUI();
    }

}


