package game_client;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class StartScreen extends JComponent
{
   public StartScreen()
   {
      setOpaque(true);
      setFocusable(true);
      setVisible(true);
      setSize(1280, 720);
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
      ImageIcon startScreenImg = new ImageIcon("Data/startscreen.png");
      g.drawImage(startScreenImg.getImage(), 0, 0, null);
   }
}
