package game_client;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class StartScreen extends BaseComponent
{
   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon startScreenImg = new ImageIcon("Data/startscreen.png");
      g.drawImage(startScreenImg.getImage(), 0, 0, null);
   }
   
}
