/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs10pd;

/**
 *
 * @author Jade Anne
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newgame implements MouseListener{
    ImageIcon gameBGIcon;
    JFrame frame;
    ImageIcon chatBoxIcon;
    JLabel chatBox;
    JTextArea chatArea;
    ImageIcon imageicon;
    JLabel backToMM;
    ImageIcon img;
    String chat[];
    int chatIndex;
    JLabel nextButtonL;
    JLabel prevButtonL;
    
    JLabel princessAyaL1;
    JLabel princessAyaL2;
    JLabel castleTownL;
    JLabel monsterL;
    JLabel ruinedCastleL1;
    JLabel ruinedCastleL2;
    
    PlaySound newgameBG;
    PlaySound click;
    int soundMode;
    
    MyStyle ms;
    
    public newgame(){
        soundMode=0;
        click=new PlaySound();
        newgameBG=new PlaySound();
        chatIndex=0;
        chat=new String[]{
            "Hello there! Welcome to the game.",
            "Once upon a time, in a land called castle town,",
            "there lived a princess named Aya.",
            "But one day, a monster appeared and ravaged castle town!",
            "And the monster went off with the hostaged princess!",
            "It is now your mission to save princess Aya!"
        };
        
        frame=new JFrame("New Game");
        //gameBGIcon=new ImageIcon("Images/newgameBG.png");
        //frame.setContentPane(new JLabel(gameBGIcon));
        //setFrameBG("Images/newgameBG.png");
        
        imageicon=new ImageIcon("Images/backtomm.png");
        //img=new ImageIcon(imageicon.getImage().getScaledInstance(207, 64, Image.SCALE_DEFAULT));
        backToMM=new JLabel(imageicon);
        
        imageicon=new ImageIcon("Images/castletown.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(650, 650, Image.SCALE_DEFAULT));
        castleTownL=new JLabel(img);
        
        imageicon=new ImageIcon("Images/nextbutton.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(66, 30, Image.SCALE_DEFAULT));
        nextButtonL=new JLabel(img);
        
        imageicon=new ImageIcon("Images/prevbutton.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(66, 30, Image.SCALE_DEFAULT));
        prevButtonL=new JLabel(img);
        
        imageicon=new ImageIcon("Images/princessaya.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(200, 360, Image.SCALE_DEFAULT));
        princessAyaL1=new JLabel(img);
        
        imageicon=new ImageIcon("Images/princessaya.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(160, 320, Image.SCALE_DEFAULT));
        princessAyaL2=new JLabel(img);
        
        imageicon=new ImageIcon("Images/monster.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        monsterL=new JLabel(img);
        
        imageicon=new ImageIcon("Images/ruinedcastle.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(120, 150, Image.SCALE_DEFAULT));
        ruinedCastleL1=new JLabel(img);
        
        imageicon=new ImageIcon("Images/ruinedcastle.png");
        img=new ImageIcon(imageicon.getImage().getScaledInstance(360, 450, Image.SCALE_DEFAULT));
        ruinedCastleL2=new JLabel(img);
        
        chatBoxIcon=new ImageIcon("Images/chatbox.png");
        chatBox=new JLabel(chatBoxIcon);
        chatArea=new JTextArea(chat[chatIndex]);
        
        ms=new MyStyle();
    }
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(24,18)));
        frame.add(monsterL, new Rectangle(3,1,10,11));
        frame.add(ruinedCastleL1, new Rectangle(12,1,4,5));
        frame.add(prevButtonL, new Rectangle(17,16,2,1));
        frame.add(nextButtonL, new Rectangle(19,16,2,1));
        frame.add(chatArea, new Rectangle(3,14,18,2));
        frame.add(chatBox, new Rectangle(2,12,20,5));
        frame.add(princessAyaL2, new Rectangle(15,5,6,10));
        frame.add(princessAyaL1, new Rectangle(7,4,6,11));
        frame.add(backToMM, new Rectangle(2,1,5,2));
        frame.add(castleTownL, new Rectangle(2,0,20,20));
        frame.add(ruinedCastleL2, new Rectangle(6,0,14,15));
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(782,595);
        frame.setVisible(true);
        frame.setLocation(100,100);
        frame.setResizable(false);
        
        this.componentSettings();
        addListeners();
        
        newgameBG.playEffect("Audio/pokemonbg.wav");
    }
    
    /*public void setFrameBG(String im){
        gameBGIcon=new ImageIcon(im);
        frame.setContentPane(new JLabel(gameBGIcon));
    }*/
    
    public void hideAll(){
        princessAyaL1.setVisible(false);
        princessAyaL2.setVisible(false);
        castleTownL.setVisible(false);
        monsterL.setVisible(false);
        ruinedCastleL1.setVisible(false);
        ruinedCastleL2.setVisible(false);
    }
    
    public void componentSettings(){
        ms.changeFontRecursive(frame, new Font("Courier New", Font.PLAIN, 20));
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        princessAyaL1.setVisible(false);
        monsterL.setVisible(false);
        princessAyaL2.setVisible(false);
        ruinedCastleL1.setVisible(false);
        ruinedCastleL2.setVisible(false);
        frame.getContentPane().setBackground(new Color(150,225,207));
    }
    
    public void addListeners(){
        this.backToMM.addMouseListener(this);
        prevButtonL.addMouseListener(this);
        nextButtonL.addMouseListener(this);
    }
    
    public void setElements(){
        hideAll();
        if(chatIndex==0){
            castleTownL.setVisible(true);
        }
        else if(chatIndex==1){
            castleTownL.setVisible(true);
        }
        else if(chatIndex==2){
            castleTownL.setVisible(true);
            princessAyaL1.setVisible(true);
            if(soundMode==1){
                newgameBG.clip.stop();
                newgameBG.playEffect("Audio/pokemonbg.wav");
                soundMode=0;
            }
        }
        else if(chatIndex==3){
            princessAyaL2.setVisible(true);
            monsterL.setVisible(true);
            ruinedCastleL1.setVisible(true);
            newgameBG.clip.stop();
            newgameBG.playEffect("Audio/monstersummon.wav");
            soundMode=1;
        }
        else if(chatIndex==4){
            ruinedCastleL2.setVisible(true);
        }
    }
    
    /*public void checkMonsterScene(){
        
    }*/

    @Override
    public void mouseClicked(MouseEvent e) {
        click.playEffect("Audio/click2.wav");
        if(e.getSource()==backToMM){
            main mm=new main();
            Point p=frame.getLocation();
            mm.setFrame();
            mm.frame.setLocation(p);
            frame.dispose();
            newgameBG.clip.stop();
        }
        else if(e.getSource()==nextButtonL){
            if(chatIndex+1<chat.length){
                chatIndex++;
                chatArea.setText(chat[chatIndex]);
            }
            else{
                Dungeon1 mm=new Dungeon1();
                Point p=frame.getLocation();
                mm.setFrame();
                mm.frame.setLocation(p);
                frame.dispose();
                newgameBG.clip.stop();
            }
            setElements();
        }
        else if(e.getSource()==prevButtonL){
            if(chatIndex-1>=0){
                chatIndex--;
                chatArea.setText(chat[chatIndex]);
            }
            setElements();
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}