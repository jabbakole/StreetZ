package game_client;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class CharSelect extends BaseComponent implements ActionListener
{

   // private CircularLinkedList list; - to cycle through versus, controls, back

   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon modeSelectImg = new ImageIcon(
            "Data/charselect/char_" + InterfaceKeyAdapter.charRow + InterfaceKeyAdapter.charCol + ".png");
      g.drawImage(modeSelectImg.getImage(), 0, 0, this);
   }

}
