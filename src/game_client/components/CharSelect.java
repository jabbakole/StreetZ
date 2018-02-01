package game_client.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import game_client.InterfaceKeyAdapter;
import ui_tools.CharPortrait;

public class CharSelect extends BaseComponent
{

   private CharPortrait ninjaGuy;
   private CharPortrait bobby;
   private CharPortrait melissa;
   private CharPortrait mrDinkle;
   private CharPortrait elise;
   private CharPortrait hugh;
   private CharPortrait zachary;
   private CharPortrait mrFrizzle;

   private Image bg;

   private CharPortrait[][] charTable;

   private String character1;
   private String character2;

   public static boolean is1Locked;
   public static boolean is2Locked;

   public CharSelect(String character1, String character2)
   {
      timer.stop();
      this.character1 = character1;
      this.character2 = character2;
      is1Locked = false;
      is2Locked = false;
      bg = new ImageIcon("Data/charselect/char_11.png").getImage();
      initializeCharacterTable();
      ninjaGuy.set1Focused();
      ninjaGuy.set2Focused();
      timer.start();
   }

   private void initializeCharacterPortraits()
   {
      String path = "Data/Characters/";
      ninjaGuy = new CharPortrait("ninjaGuy", path + "ninjaGuy_foc1.png", path + "ninjaGuy_foc2.png",
            path + "ninjaGuy_foc12.png", path + "ninjaGuy_unf.png");
      bobby = new CharPortrait("bobby", path + "bobby_foc1.png", path + "bobby_foc2.png", path + "bobby_foc12.png",
            path + "bobby_unf.png");
      melissa = new CharPortrait("melissa", path + "melissa_foc1.png", path + "melissa_foc2.png",
            path + "melissa_foc12.png", path + "melissa_unf.png");
      mrDinkle = new CharPortrait("mrDinkle", path + "mrDinkle_foc1.png", path + "mrDinkle_foc2.png",
            path + "mrDinkle_foc12.png", path + "mrDinkle_unf.png");
      elise = new CharPortrait("elise", path + "elise_foc1.png", path + "elise_foc2.png", path + "elise_foc12.png",
            path + "elise_unf.png");
      hugh = new CharPortrait("hugh", path + "hugh_foc1.png", path + "hugh_foc2.png", path + "hugh_foc12.png",
            path + "hugh_unf.png");
      zachary = new CharPortrait("zachary", path + "zachary_foc1.png", path + "zachary_foc2.png",
            path + "zachary_foc12.png", path + "zachary_unf.png");
      mrFrizzle = new CharPortrait("mrFrizzle", path + "mrFrizzle_foc1.png", path + "mrFrizzle_foc2.png",
            path + "mrFrizzle_foc12.png", path + "mrFrizzle_unf.png");
   }

   private void initializeCharacterTable()
   {
      charTable = new CharPortrait[2][4];
      initializeCharacterPortraits();
      charTable[0][0] = ninjaGuy;
      charTable[0][1] = bobby;
      charTable[0][2] = melissa;
      charTable[0][3] = mrDinkle;
      charTable[1][0] = elise;
      charTable[1][1] = hugh;
      charTable[1][2] = zachary;
      charTable[1][3] = mrFrizzle;
   }

   @Override
   public void paintComponent(Graphics g)
   {
      // paint background
      g.drawImage(bg, 0, 0, this);
      for (int x = 0; x < 2; x++)
      {
         for (int y = 0; y < 4; y++)
         {
            g.drawImage(charTable[x][y].getImg(), 230 + (220 * y), 200 + (220 * x), this);
         }
      }

      // display text if players are locked in
      g.setColor(Color.RED);
      g.setFont(new Font("Arial", Font.BOLD, 36));
      if (is1Locked && is2Locked)
      {
         g.drawString("both locked", 600, 600);
         g.drawString("press not-back key to continue", 400, 650);
      }
      else if (is1Locked)
      {
         g.drawString("p1 locked in", 100, 200);
      }
      else if (is2Locked)
      {
         g.drawString("p2 locked in", 1100, 200);
      }

   }

   @Override
   public void tick()
   {
      if (!is1Locked || !is2Locked)
      {
         setAllUnfocused();
         // update which portraits are focused
         charTable[InterfaceKeyAdapter.charRow1][InterfaceKeyAdapter.charCol1].set1Focused();
         charTable[InterfaceKeyAdapter.charRow2][InterfaceKeyAdapter.charCol2].set2Focused();
      }
      else
      {
         character1 = findp1Char();
         character2 = findp2Char();
      }
      repaint();
   }

   private void setAllUnfocused()
   {
      for (int x = 0; x < 2; x++)
      {
         for (int y = 0; y < 4; y++)
         {
            charTable[x][y].set1Unfocused();
            charTable[x][y].set2Unfocused();
         }
      }
   }

   private String findp1Char()
   {
      for (int x = 0; x < 2; x++)
      {
         for (int y = 0; y < 4; y++)
         {
            if (charTable[x][y].is1Focused())
            {
               return charTable[x][y].toString();
            }
         }
      }
      // as in Controls.java, empty string should not occur..
      return "";
   }

   private String findp2Char()
   {
      for (int x = 0; x < 2; x++)
      {
         for (int y = 0; y < 4; y++)
         {
            if (charTable[x][y].is2Focused())
            {
               return charTable[x][y].toString();
            }
         }
      }
      // as in Controls.java, empty string should not occur..
      return "";
   }

}
