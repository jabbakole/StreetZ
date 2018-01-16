package game_client.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Versus extends BaseComponent
{
   private Image bg;

   public Versus()
   {
      bg = new ImageIcon("Data/Versus/versusbg.png").getImage();
   }
      
   @Override
   public void paintComponent(Graphics g)
   {
      g.drawImage(bg, 0, 0, this);
   }

   @Override
   public void tick()
   {
      repaint();
   }
}
