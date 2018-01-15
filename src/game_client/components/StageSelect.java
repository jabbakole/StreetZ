package game_client.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class StageSelect extends BaseComponent
{
   private Image bg;
   
   // to set the stage when it is picked
   private String stage;
   
   public StageSelect(String stage)
   {
      this.stage = stage;
      timer.stop();
      bg = new ImageIcon("Data/stageselect/stagebg.png").getImage();
      timer.start();
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
