package game_client;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

import ui_tools.Button;

public class CharSelect extends JComponent implements ActionListener
{
   private Timer timer;

   // private CircularLinkedList list; - to cycle through versus, controls, back

   public CharSelect()
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
      ImageIcon modeSelectImg = new ImageIcon(
            "Data/charselect/char_" + InterfaceKeyAdapter.charCol + InterfaceKeyAdapter.charRow + ".png");
      g.drawImage(modeSelectImg.getImage(), 0, 0, null);
   }

   @Override
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

   public void tick()
   {
      System.out.println("?");
      repaint();
   }

}
