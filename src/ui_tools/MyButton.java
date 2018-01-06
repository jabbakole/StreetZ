package ui_tools;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MyButton
{
   private ImageIcon nonFocusedImg;
   private ImageIcon focusedImg;
   private boolean isFocused;
   private int width;
   private int height;
   
   public MyButton(String nonFocusedLink, String focusedLink, int height, int width)
   {
      nonFocusedImg = new ImageIcon(nonFocusedLink);
      focusedImg = new ImageIcon(focusedLink);
      this.height = height;
      this.width = width;
      isFocused = false;
   }
   
   public Image getImg()
   {
      if (isFocused)
      {
         return focusedImg.getImage();
      }
      return nonFocusedImg.getImage();
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
      return isFocused();
   }
   
   public int getWidth()
   {
      return width;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   
   
}
