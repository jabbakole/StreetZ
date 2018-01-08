package game_client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import ui_tools.MyControlButton;

public class Controls extends BaseComponent
{
   private MyControlButton p1up;
   private MyControlButton p1down;
   private MyControlButton p1left;
   private MyControlButton p1right;
   private MyControlButton p1jabConfirm;
   private MyControlButton p1kickBack;

   private MyControlButton p2up;
   private MyControlButton p2down;
   private MyControlButton p2left;
   private MyControlButton p2right;
   private MyControlButton p2jabConfirm;
   private MyControlButton p2kickBack;

   private MyControlButton[] p1Controls;
   private MyControlButton[] p2Controls;

   private int p1Offset;
   private int p2Offset;

   private Image bg;

   private PlayerKeys p1;
   private PlayerKeys p2;

   public static int state;
   // if state = 0, show the keys
   // if state = 1, p1 is entering a key
   // if state = 2, p2 is entering a key

   public Controls(PlayerKeys p1, PlayerKeys p2)
   {
      timer.stop();
      this.p1 = p1;
      this.p2 = p2;
      // hardcoded lol
      p1Offset = 29;
      p2Offset = 29;
      initializeButtons();
      bg = new ImageIcon("Data/controls/controlsbg.png").getImage();
      timer.start();
      state = 0;
   }

   private void initializeButtons()
   {
      p1up = new MyControlButton(52, 229, p1.getUp());
      p1down = new MyControlButton(52, 229, p1.getDown());
      p1left = new MyControlButton(52, 229, p1.getLeft());
      p1right = new MyControlButton(52, 229, p1.getRight());
      p1jabConfirm = new MyControlButton(52, 229, p1.getJabConfirm());
      p1kickBack = new MyControlButton(52, 229, p1.getKickBack());

      p1Controls = new MyControlButton[6];

      p1Controls[0] = p1up;
      p1Controls[1] = p1right;
      p1Controls[2] = p1down;
      p1Controls[3] = p1left;
      p1Controls[4] = p1jabConfirm;
      p1Controls[5] = p1kickBack;

      p2up = new MyControlButton(52, 229, p2.getUp());
      p2down = new MyControlButton(52, 229, p2.getDown());
      p2left = new MyControlButton(52, 229, p2.getLeft());
      p2right = new MyControlButton(52, 229, p2.getRight());
      p2jabConfirm = new MyControlButton(52, 229, p2.getJabConfirm());
      p2kickBack = new MyControlButton(52, 229, p2.getKickBack());

      p2Controls = new MyControlButton[6];

      p2Controls[0] = p2up;
      p2Controls[1] = p2right;
      p2Controls[2] = p2down;
      p2Controls[3] = p2left;
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
      if (state == 1 || state == 2)
      {
         g.setFont(new Font("Arial", Font.BOLD, 36));
         g.setColor(Color.RED);
         g.drawString("ENTER PLAYER " + state + " KEY", 430, 660);
      }
      else if (state == 3)
      {
         g.setFont(new Font("Arial", Font.BOLD, 36));
         g.setColor(Color.RED);
         g.drawString("EXISTING KEY BRUV PRESS A KEY TO RETURN BRUV", 190, 660);
      }
   }

   @Override
   public void tick()
   {
      switch (state)
      {
         case (0):
         {
            for (int x = 0; x < 6; x++)
            {
               p1Controls[x].setUnfocused();
               p2Controls[x].setUnfocused();
            }
            p1Controls[InterfaceKeyAdapter.p1Row].setFocused();
            p2Controls[InterfaceKeyAdapter.p2Row].setFocused();
            break;
         }
         case (1):
         {
            // if the keyadapter has a key for us
            if (InterfaceKeyAdapter.keypress != -1)
            {
               // find which button is focused
               int updatedKey = InterfaceKeyAdapter.keypress;

               // if it's an existing key, don't update anything
               if (isExistingKey(updatedKey))
               {
                  state = 3;
                  InterfaceKeyAdapter.keypress = -1;
                  break;
               }
               int x = findFocusedButton(p1Controls);

               // update the playerkeys object
               updatePlayerKeys(p1, x, updatedKey);

               // update the mybutton object and thus the view
               p1Controls[x] = new MyControlButton(52, 229, updatedKey);

               // reset stuff for use again
               InterfaceKeyAdapter.keypress = -1;
               state = 0;
            }
            break;
         }
         case (2):
         {
            if (InterfaceKeyAdapter.keypress != -1)
            {
               // find which button is focused
               int updatedKey = InterfaceKeyAdapter.keypress;

               // if it's an existing key, don't update anything
               if (isExistingKey(updatedKey))
               {
                  state = 3;
                  InterfaceKeyAdapter.keypress = -1;
                  break;
               }
               int x = findFocusedButton(p2Controls);

               // update the playerkeys object
               updatePlayerKeys(p2, x, updatedKey);

               // update the mybutton object and thus the view
               p2Controls[x] = new MyControlButton(52, 229, updatedKey);

               // reset stuff for use again
               InterfaceKeyAdapter.keypress = -1;
               state = 0;
            }
            break;
         }
         case (3):
         {
            break;
            // paintcomponent "u cant existin key bruh press any key to return
         }
      }
      repaint();
   }

   private int findFocusedButton(MyControlButton[] keys)
   {
      for (int x = 0; x < keys.length; x++)
      {
         if (keys[x].isFocused())
         {
            return x;
         }
      }
      // nothing is done with -1; there should always be a focused button
      return -1;
   }

   private boolean isExistingKey(int key)
   {
      int[] p1keys = p1.getKeyList();
      int[] p2keys = p2.getKeyList();
      for (int x = 0; x < 6; x++)
      {
         if (key == p1keys[x] || key == p2keys[x])
         {
            return true;
         }
      }
      return false;
   }

   private void updatePlayerKeys(PlayerKeys player, int x, int updatedKey)
   {
      switch (x)
      {
         case (0):
         {
            player.setUp(updatedKey);
            break;
         }
         case (1):
         {
            player.setRight(updatedKey);
            break;
         }
         case (2):
         {
            player.setDown(updatedKey);
            break;
         }
         case (3):
         {
            player.setLeft(updatedKey);
            break;
         }
         case (4):
         {
            player.setJabConfirm(updatedKey);
            break;
         }
         case (5):
         {
            player.setKickBack(updatedKey);
            break;
         }
      }
   }

   /**
    * Maybe something like this for future design. public void cyclep1Down() { for
    * (int x = 0; x < p1Controls.length; x++) { if (p1Controls[x].isFocused()) { if
    * (x == (p1Controls.length - 1)) { p1Controls[x].setUnfocused();
    * p1Controls[0].setFocused(); } else { p1Controls[x].setUnfocused();
    * p1Controls[x+1].setFocused(); } } } }
    */

}
