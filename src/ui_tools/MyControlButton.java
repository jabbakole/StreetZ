package ui_tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class MyControlButton extends FocusableImage
{
   private int key;

   public MyControlButton(int height, int width, int key)
   {
      this.height = height;
      this.width = width;
      this.key = key;
      createFocusImages();
   }

   public Image getImg()
   {
      if (isFocused)
      {
         return focusedImg;
      }
      return unFocusedImg;
   }

   public void setFocused()
   {
      isFocused = true;
   }

   public void setUnfocused()
   {
      isFocused = false;
   }

   public boolean isFocused()
   {
      return isFocused;
   }

   public int getWidth()
   {
      return width;
   }

   public int getHeight()
   {
      return height;
   }

   private void createFocusImages()
   {
      BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      Graphics g = buff.getGraphics();
      // hardcoded the x, y position of the text
      g.setFont(new Font("Arial", Font.BOLD, 38));
      String s = getStringFromKey();
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, width, height);
      g.setColor(Color.RED);
      g.drawString(s, 100, 36);
      focusedImg = buff;
      buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      g = buff.getGraphics();
      g.setFont(new Font("Arial", Font.BOLD, 36));
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, width, height);
      g.setColor(Color.BLACK);
      g.drawString(s, 100, 36);
      unFocusedImg = buff;
   }

   private String getStringFromKey()
   {
      String s = "" + (char) key;
      if (key > 36 && key < 41)
      {
         if (key == 37)
         {
            s = "\u2190";
         }
         else if (key == 38)
         {
            s = "\u2191";
         }
         else if (key == 39)
         {
            s = "\u2192";
         }
         else if (key == 40)
         {
            s = "\u2193";
         }
      }
      if (key > 95 && key < 106)
      {
         s = "" + (char) (key - 48);
      }
      return s;
   }

}
