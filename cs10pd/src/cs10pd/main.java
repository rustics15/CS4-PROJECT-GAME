/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cs10pd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main implements MouseListener{
    JFrame frame;
    JLabel newgame;
    ImageIcon newgameIcon;
    JLabel settings;
    ImageIcon settingsIcon;
    ImageIcon gameBGIcon;
    ImageIcon img;
    PlaySound click;
    
    public main(){
        click=new PlaySound();
        
        
        
        newgameIcon=new ImageIcon("images/newgame.png");    //259x80 px
        img=new ImageIcon(newgameIcon.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT));
        newgame=new JLabel(img);
        
        settingsIcon=new ImageIcon("images/settings.png");
        img=new ImageIcon(settingsIcon.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT));
        settings=new JLabel(img);
        
        gameBGIcon=new ImageIcon("images/mainbg.png");    //project
        img=new ImageIcon(gameBGIcon.getImage().getScaledInstance(1100, 800, Image.SCALE_DEFAULT));
        
        frame=new JFrame("Fallacy Game");
        frame.setContentPane(new JLabel(img));
    }
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(20,30)));
        frame.add(newgame, new Rectangle(3,20,6,4));
        frame.add(settings, new Rectangle(11,20,6,4));
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setSize(1100,800);
        
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);
        //frame.setLocation(100,100);
        frame.setResizable(false);
        addListeners();
    }
    
    public void addListeners(){
        newgame.addMouseListener(this);
    }
    
    public static void main(String[] args){
        main mm=new main();
        mm.setFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        click.playEffect("Audio/click2.wav");
        if(e.getSource()==newgame){
            loadingpage lp=new loadingpage();
            Point p=frame.getLocation();
            lp.setFrame();
            lp.frame.setLocation(p);
            frame.dispose();
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
        //do something here
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
