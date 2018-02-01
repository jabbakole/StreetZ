package game_client.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class StartScreen extends BaseComponent
{
   private Image start;

   public StartScreen()
   {
      super();
      ImageIcon startScreenImg = new ImageIcon("Data/startscreen.png");
      start = startScreenImg.getImage();
   }

   @Override
   public void paintComponent(Graphics g)
   {
      g.drawImage(start, 0, 0, this);
   }

}
