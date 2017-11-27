package game_client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class GameInterface extends JComponent implements ActionListener
{
   public static State state;
   private Timer       timer;

   public GameInterface()
   {
      setFocusable(true);
      state = State.MAIN_MENU;
      timer = new Timer(1070, this);
      addKeyListener(new InterfaceKeyAdapter());
      timer.start();
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
            // g.drawImage(img, x, y, observer)
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
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

}
