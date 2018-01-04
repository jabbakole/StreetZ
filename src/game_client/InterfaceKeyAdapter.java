package game_client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InterfaceKeyAdapter implements KeyListener
{

   private PlayerKeys p1;
   private PlayerKeys p2;

   public InterfaceKeyAdapter(PlayerKeys p1, PlayerKeys p2)
   {
      this.p1 = p1;
      this.p2 = p2;
   }

   public static int modeNum = 1;
   // 1 = fight
   // 2 = controls
   // 3 = quit

   public static int charCol = 1;
   public static int charRow = 1;
   // 11 = somedude
   // 12 = someotherdude
   // ...
   // 21 = someotherotherdude
   // ...

   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      switch (GameInterface.state)
      {
         case START_SCREEN:
         {
            if ((key == KeyEvent.VK_ENTER) || (key == p1.getJabConfirm()) || (key == p2.getJabConfirm()))
            {
               GameInterface.state = State.MODE_SELECT;
            }
            break;
         }
         case MODE_SELECT:
         {
            if ((key == p1.getDown()) || (key == p2.getDown()))
            {
               // there'll be circular linked list in mode select jcomponent; focus the next
               // mode in the list
               if (modeNum < 3)
                  modeNum++;
               else if (modeNum == 3)
                  modeNum = 1;
            }
            else if ((key == p1.getUp()) || (key == p2.getUp()))
            {
               if (modeNum > 1)
                  modeNum--;
               else if (modeNum == 1)
                  modeNum = 3;
               // same as above
            }
            else if ((key == KeyEvent.VK_BACK_SPACE) || (key == p1.getKickBack()) || (key == p2.getKickBack()))
            {
               GameInterface.state = State.START_SCREEN;
            }
            else if ((key == KeyEvent.VK_ENTER) || (key == p1.getJabConfirm()) || (key == p2.getJabConfirm()))
            {
               // depending on which button is focused in the circular list, go to that state
               // (controls, char sel, stage sel)
               switch (modeNum)
               {
                  case (1):
                  {
                     GameInterface.state = State.CHAR_SELECT;
                     break;
                  }
                  case (2):
                  {
                     GameInterface.state = State.CONTROLS;
                     break;
                  }
                  case (3):
                  {
                     System.exit(1); // no idea how graceful this is??
                     break;
                  }
               }
            }
            break;
         }
         case CONTROLS:
         {
            
            break;
         }
         case CHAR_SELECT:
         {
            if ((key == KeyEvent.VK_RIGHT) && charCol < 4)
            {
               charCol++;
            }
            else if ((key == KeyEvent.VK_LEFT) && charCol > 1)
            {
               charCol--;
            }
            else if ((key == KeyEvent.VK_DOWN) && (charRow == 1))
            {
               charRow++;
            }
            else if ((key == KeyEvent.VK_UP) && (charRow == 2))
            {
               charRow--;
            }
            else if (key == KeyEvent.VK_BACK_SPACE)
            {
               GameInterface.state = State.MODE_SELECT;
            }
            else if (key == KeyEvent.VK_ENTER)
            {
               GameInterface.state = State.STAGE_SELECT;
            }
            break;
         }
         case STAGE_SELECT:
         {
            break;
         }
         case VERSUS:
         {
            break;
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {

   }

   @Override
   public void keyTyped(KeyEvent e)
   {

   }

}
