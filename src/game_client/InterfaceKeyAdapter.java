package game_client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InterfaceKeyAdapter implements KeyListener
{

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
               // there'll be circular linked list in mode select jcomponent; focus the next
               // mode in the list
            } else if (e.getKeyCode() == KeyEvent.VK_UP)
            {
               // same as above
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            {
               GameInterface.state = State.START_SCREEN;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               // depending on which button is focused in the circular list, go to that state
               // (controls, char sel, stage sel)
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
