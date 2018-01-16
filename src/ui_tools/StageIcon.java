package ui_tools;

import java.awt.image.BufferedImage;

import javaxt.io.Image;

public class StageIcon
{
   private javaxt.io.Image center;
   private javaxt.io.Image left;
   private javaxt.io.Image right;
   private String name;

   public StageIcon(String centerLink, String name)
   {
      this.name = name;
      center = new javaxt.io.Image(centerLink);
      createLeftRightImages();
   }
   
   @Override
   public String toString()
   {
      return name;
   }

   private void createLeftRightImages()
   {
      left = center.copy();
      right = center.copy();
      int width = center.getWidth();
      int height = center.getHeight();
      left.setCorners((2 * width) / 3, height / 6, width, 0, width, height, (2 * width) / 3, (5 * height) / 6);
      right.setCorners(0, 0, width / 3, height / 6, width / 3, (5 * height) / 6, 0, height);
   }

   public BufferedImage getCenter()
   {
      return center.getBufferedImage();
   }
   
   public BufferedImage getLeft()
   {
      return left.getBufferedImage();
   }
   
   public BufferedImage getRight()
   {
      return right.getBufferedImage();
   }
}
