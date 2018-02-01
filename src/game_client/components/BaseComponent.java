package game_client.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public abstract class BaseComponent extends JComponent implements ActionListener
{
   protected Timer timer;
   
   public BaseComponent()
   {
      timer = new Timer(17, this);
      setSize(1280, 720);
      setFocusable(false);
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
   
   public boolean timerIsRunning()
   {
      return timer.isRunning();
   }
   
}
