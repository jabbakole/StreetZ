package game_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public abstract class BaseComponent extends JComponent implements ActionListener
{
   private Timer timer;
   
   public BaseComponent()
   {
      timer = new Timer(17, this);
      setSize(1280, 720);
      setFocusable(true);
      setVisible(true);
      setOpaque(true);
      timer.start();
   }
   
   @Override
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

   public void tick()
   {
      repaint();
   }
   
   public void startTimer()
   {
      timer.start();
   }
   
   public void stopTimer()
   {
      timer.stop();
   }
   
}
