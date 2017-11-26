package game_client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class GameInterface extends JComponent implements KeyListener
{
   private State state;

   public GameInterface()
   {
      state = State.MAIN_MENU;
   }

   public void tick()
   {
      repaint();
   }
   
   @Override
   public void paint(Graphics g)
   {
      switch (state)
      {
         case MAIN_MENU:
         {
            //g.drawImage(img, x, y, observer)
            g.setColor(Color.BLUE);
            g.fillRoundRect(3, 3, 6, 6, 1, 1);
            break;
         }
         case MODE_SELECT:
         {
            g.setColor(Color.GREEN);
            g.fillRect(6, 6, 23, 2);
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
   public void keyPressed(KeyEvent e)
   {
      switch (state)
      {
         case MAIN_MENU:
         {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               state = State.MODE_SELECT;
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
