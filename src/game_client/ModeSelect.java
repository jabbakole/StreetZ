package game_client;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import ui_tools.Button;

public class ModeSelect extends JComponent implements ActionListener
{
   private Button versus;
   private Button controls;
   private Button back;
   private Timer  timer;

   // private CircularLinkedList list; - to cycle through versus, controls, back

   public ModeSelect()
   {
      // add(versus); this line breaks it
      timer = new Timer(17, this);
      timer.start();
      setFocusable(true);
      addKeyListener(new InterfaceKeyAdapter());
   }

   @Override
   public void paintComponent(Graphics g)
   {
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

}
