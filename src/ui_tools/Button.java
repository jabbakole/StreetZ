package ui_tools;

import javax.swing.JButton;

public class Button extends JButton
{
   private int x;
   private int y;
   private int height;
   private int width;
   private boolean isFocused;
   
   public Button(int x, int y, int height, int width)
   {
      this.x = x;
      this.y = y;
      this.height = height;
      this.width = width;
   }
}
