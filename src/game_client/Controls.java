package game_client;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import ui_tools.MyButton;

public class Controls extends BaseComponent
{
   private MyButton p1up;
   private MyButton p1down;
   private MyButton p1left;
   private MyButton p1right;
   private MyButton p1jabConfirm;
   private MyButton p1kickBack;

   private MyButton p2up;
   private MyButton p2down;
   private MyButton p2left;
   private MyButton p2right;
   private MyButton p2jabConfirm;
   private MyButton p2kickBack;

   private MyButton[] p1Controls;
   private MyButton[] p2Controls;

   private int p1Offset;
   private int p2Offset;
   
   private Image bg;

   public Controls()
   {
      // hardcoded lol
      p1Offset = 29;
      p2Offset = 29;
      initializeButtons();
      bg = new ImageIcon("Data/controls/controlsbg.png").getImage();
   }

   private void initializeButtons()
   {
      p1up = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p1down = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p1left = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p1right = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p1jabConfirm = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p1kickBack = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);

      p1Controls = new MyButton[6];

      p1Controls[0] = p1up;
      p1Controls[1] = p1down;
      p1Controls[2] = p1left;
      p1Controls[3] = p1right;
      p1Controls[4] = p1jabConfirm;
      p1Controls[5] = p1kickBack;

      p2up = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p2down = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p2left = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p2right = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p2jabConfirm = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);
      p2kickBack = new MyButton("Data/controls/unfocusedimg.png", "Data/controls/focusedimg.png", 52, 229);

      p2Controls = new MyButton[6];

      p2Controls[0] = p2up;
      p2Controls[1] = p2down;
      p2Controls[2] = p2left;
      p2Controls[3] = p2right;
      p2Controls[4] = p2jabConfirm;
      p2Controls[5] = p2kickBack;

      p1up.setFocused();
      p2up.setFocused();
   }

   @Override
   public void paintComponent(Graphics g)
   {
      // paint background
      g.drawImage(bg, 0, 0, this);

      // paint buttons.. hardcoded
      for (int x = 0; x < 6; x++)
      {
         g.drawImage(p1Controls[x].getImg(), 347, 157 + ((48 + p1Offset) * x), this);
         g.drawImage(p2Controls[x].getImg(), 790, 157 + ((48 + p2Offset) * x), this);
      }
   }

   @Override
   public void tick()
   {
      for (int x = 0; x < 6; x++)
      {
         p1Controls[x].setUnfocused();
         p2Controls[x].setUnfocused();
      }
      p1Controls[InterfaceKeyAdapter.p1Row].setFocused();
      p2Controls[InterfaceKeyAdapter.p2Row].setFocused();
      repaint();
   }

   /**
    * Maybe something like this for future design. public void cyclep1Down() { for
    * (int x = 0; x < p1Controls.length; x++) { if (p1Controls[x].isFocused()) { if
    * (x == (p1Controls.length - 1)) { p1Controls[x].setUnfocused();
    * p1Controls[0].setFocused(); } else { p1Controls[x].setUnfocused();
    * p1Controls[x+1].setFocused(); } } } }
    */

}
