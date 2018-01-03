package game_client;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import ui_tools.Button;

public class ModeSelect extends BaseComponent implements ActionListener
{
   private Button versus;
   private Button controls;
   private Button back;
   private Timer  timer;

   // private CircularLinkedList list; - to cycle through versus, controls, back

   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon modeSelectImg = new ImageIcon("Data/modeselect/modes_" + InterfaceKeyAdapter.modeNum + ".png");
      g.drawImage(modeSelectImg.getImage(), 0, 0, null);
   }
   
}
