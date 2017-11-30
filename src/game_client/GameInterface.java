package game_client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GameInterface extends JComponent implements ActionListener
{
   public static State state;
   private boolean     isStartScreen;
   private Timer       timer;

   public GameInterface()
   {
      setFocusable(true);
      state = State.START_SCREEN;
      timer = new Timer(17, this); // close to 60fps (1000ms/60)
      addKeyListener(new InterfaceKeyAdapter());
      timer.start();
      isStartScreen = true;
   }

   public void tick()
   {
      repaint();
   }

   @Override
   public void paintComponent(Graphics g)
   {
      switch (state)
      {
         case START_SCREEN:
         {
            ImageIcon startScreenImg = new ImageIcon("Data/startscreen.png");
            g.drawImage(startScreenImg.getImage(), 0, 0, null);
            break;
         }
         case MODE_SELECT:
         {
            if (isStartScreen)
            {
               add(new ModeSelect());
               isStartScreen = false;
               timer.stop();
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
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

}
