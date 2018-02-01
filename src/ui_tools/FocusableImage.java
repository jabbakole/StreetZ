package ui_tools;

import java.awt.Image;

public class FocusableImage
{
   protected Image   unFocusedImg;
   protected Image   focusedImg;
   protected boolean isFocused;
   protected int     width;
   protected int     height;

   public FocusableImage()
   {
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

}
