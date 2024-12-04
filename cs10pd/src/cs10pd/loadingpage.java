
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs10pd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loadingpage implements ActionListener{
    JFrame frame;
    
    ImageIcon loadingBGIcon;
    ImageIcon img;
    JButton loading;
    
    PlaySound newgameBG;
    PlaySound click;
    int soundMode;
    
    MyStyle ms;
    
    public loadingpage(){
        soundMode=0;
        click=new PlaySound();
        newgameBG=new PlaySound();
        
        
        loadingBGIcon=new ImageIcon("Images/loadingpage.png");
        img=new ImageIcon(loadingBGIcon.getImage().getScaledInstance(1100, 800, Image.SCALE_DEFAULT));
        frame=new JFrame("New Game");
        frame.setContentPane(new JLabel(img));
        //setFrameBG("Images/newgameBG.png");
        
        loading = new JButton("Loading Button");
    }    
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(20,30)));
        frame.add(loading, new Rectangle(14,27,4,2));
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
        loading.addActionListener(this);
    }
    
        public static void main(String[] args){
        loadingpage bg = new loadingpage();
        bg.setFrame();
    }
    
    //public static void main(String[] args){
    //    NewGame ng=new NewGame();
    //    ng.setFrame();
    //}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        click.playEffect("Audio/click2.wav");
        if(e.getSource()==loading){
            newgame ng=new newgame();
            Point p=frame.getLocation();
            ng.setFrame();
            ng.frame.setLocation(p);
            frame.dispose();
        }
    }
}
   