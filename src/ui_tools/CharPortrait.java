package ui_tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CharPortrait
{

   private Image   unFocusedImg;
   private Image   p1focus;
   private Image   p2focus;
   private Image   doubleFocus;
   private boolean is1Focused;
   private boolean is2Focused;
   private int     width;
   private int     height;
   private String  characterName;

   public Image getImg()
   {
      if (is1Focused && is2Focused)
      {
         return doubleFocus;
      }
      else if (is1Focused && !is2Focused)
      {
         return p1focus;
      }
      else if (is2Focused && !is1Focused)
      {
         return p2focus;
      }
      return unFocusedImg;
   }

   public void set1Focused()
   {
      is1Focused = true;
   }

   public void set2Focused()
   {
      is2Focused = true;
   }

   public void set1Unfocused()
   {
      is1Focused = false;
   }

   public void set2Unfocused()
   {
      is2Focused = false;
   }

   public boolean is1Focused()
   {
      return is1Focused;
   }

   public boolean is2Focused()
   {
      return is2Focused;
   }

   public int getWidth()
   {
      return width;
   }

   public int getHeight()
   {
      return height;
   }

   public CharPortrait(String characterName, String p1focusLink, String p2focusLink, String doubleFocusLink, String unFocusedImgLink)
   {
      this.characterName = characterName;
      createFocusImages(p1focusLink, p2focusLink, doubleFocusLink, unFocusedImgLink);
   }

   private void createFocusImages(String p1focusLink, String p2focusLink, String doubleFocusLink, String unFocusedLink)
   {
      ImageIcon i = new ImageIcon(unFocusedLink);
      unFocusedImg = i.getImage();

      i = new ImageIcon(p1focusLink);
      p1focus = i.getImage();

      i = new ImageIcon(p2focusLink);
      p2focus = i.getImage();

      i = new ImageIcon(doubleFocusLink);
      doubleFocus = i.getImage();

      // }:^) all the images are the same width/height
      height = p1focus.getHeight(null);
      width = p1focus.getWidth(null);
   }

   @Override
   public String toString()
   {
      return characterName;
   }

}
