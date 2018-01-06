package game_client;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ui_tools.MyButton;

public class Controls extends BaseComponent
{
   private MyButton   p1up;
   private MyButton   p1down;
   private MyButton   p1left;
   private MyButton   p1right;
   private MyButton   p1jabConfirm;
   private MyButton   p1kickBack;

   private MyButton   p2up;
   private MyButton   p2down;
   private MyButton   p2left;
   private MyButton   p2right;
   private MyButton   p2jabConfirm;
   private MyButton   p2kickBack;

   private MyButton[] p1Controls;
   private MyButton[] p2Controls;

   private int        p1Offset;
   private int        p2Offset;
   private int        p1XStart;
   private int        p2XStart;

   public Controls()
   {
      // hardcoded lol
      p1Offset = 29;
      p2Offset = 29;
      initializeButtons();
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
   }

   @Override
   public void paintComponent(Graphics g)
   {
      // paint background
      ImageIcon bg = new ImageIcon("Data/controls/controlsbg.png");
      g.drawImage(bg.getImage(), 0, 0, null);

      // paint buttons.. hardcoded
      for (int x = 0; x < 6; x++)
      {
         g.drawImage(p1Controls[x].getImg(), 347, 157 + (p1Offset * x), null);
         g.drawImage(p2Controls[x].getImg(), 785, 157 + (p2Offset * x), null);
      }
   }

}
