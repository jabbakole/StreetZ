package game_client;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
      timer = new Timer(17, this);
      timer.start();
      setOpaque(true);
      setVisible(true);
      setFocusable(true);
      setSize(1280, 720);
   }

   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon modeSelectImg = new ImageIcon("Data/modeselect/modes_" + InterfaceKeyAdapter.modeNum + ".png");
      g.drawImage(modeSelectImg.getImage(), 0, 0, null);
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
