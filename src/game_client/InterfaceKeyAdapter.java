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
         case MAIN_MENU:
         {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               GameInterface.state = State.MODE_SELECT;
            }
            break;
         }
         case MODE_SELECT:
         {
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
