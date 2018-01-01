package game_client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InterfaceKeyAdapter implements KeyListener
{
   static int count = 1;

   @Override
   public void keyPressed(KeyEvent e)
   {
      switch (GameInterface.state)
      {
         case START_SCREEN:
         {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               GameInterface.state = State.MODE_SELECT;
            }
            break;
         }
         case MODE_SELECT:
         {
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               if (count < 3)
                  count++;
               else if (count == 3)
                  count = 1;
               // there'll be circular linked list in mode select jcomponent; focus the next
               // mode in the list
            } else if (e.getKeyCode() == KeyEvent.VK_UP)
            {
               if (count > 1)
                  count--;
               else if (count == 1)
                  count = 3;
               // same as above
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            {
               GameInterface.state = State.START_SCREEN;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               // depending on which button is focused in the circular list, go to that state
               // (controls, char sel, stage sel)
               switch (count)
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
