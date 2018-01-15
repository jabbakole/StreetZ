package game_client.components;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import game_client.InterfaceKeyAdapter;

public class ModeSelect extends BaseComponent
{
//   private MyButton versus;
//   private MyButton controls;
//   private MyButton back;
   private Timer  timer;

   // private CircularLinkedList list; - to cycle through versus, controls, back

   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon modeSelectImg = new ImageIcon("Data/modeselect/modes_" + InterfaceKeyAdapter.modeNum + ".png");
      g.drawImage(modeSelectImg.getImage(), 0, 0, this);
   }
   
}
