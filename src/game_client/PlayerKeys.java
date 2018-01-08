package game_client;

import java.awt.event.KeyEvent;

public class PlayerKeys
{
   private int up;
   private int down;
   private int left;
   private int right;
   private int jabConfirm;
   private int kickBack;
   // can add more keys later :3
   // may want to modify the setters in the future to be booleans & restrict
   // certain keys (if user tries to pick bad key, return false and make user pick
   // new key)
   // also may want to turn this into a straight up player class? and have variable
   // for character, health, etc.. or perhaps pass objects of this type to the
   // player objects

   public PlayerKeys(int up, int down, int left, int right, int jabConfirm, int kickBack)
   {
      this.setUp(up);
      this.setDown(down);
      this.setLeft(left);
      this.setRight(right);
      this.setJabConfirm(jabConfirm);
      this.setKickBack(kickBack);
   }

   /**
    * @param playerNumber
    *           is for player1 or 2; sets default controls for p1 or 2
    */
   public PlayerKeys(int playerNumber)
   {
      if (playerNumber == 1)
      {
         setUp(KeyEvent.VK_W);
         setDown(KeyEvent.VK_S);
         setLeft(KeyEvent.VK_A);
         setRight(KeyEvent.VK_D);
         setJabConfirm(KeyEvent.VK_F);
         setKickBack(KeyEvent.VK_G);
      }
      else if (playerNumber == 2)
      {
         setUp(KeyEvent.VK_UP);
         setDown(KeyEvent.VK_DOWN);
         setRight(KeyEvent.VK_RIGHT);
         setLeft(KeyEvent.VK_LEFT);
         setJabConfirm(KeyEvent.VK_NUMPAD1);
         setKickBack(KeyEvent.VK_NUMPAD2);
      }
   }

   public int getUp()
   {
      return up;
   }

   public void setUp(int up)
   {
      this.up = up;
   }

   public int getDown()
   {
      return down;
   }

   public void setDown(int down)
   {
      this.down = down;
   }

   public int getLeft()
   {
      return left;
   }

   public void setLeft(int left)
   {
      this.left = left;
   }

   public int getRight()
   {
      return right;
   }

   public void setRight(int right)
   {
      this.right = right;
   }

   public int getJabConfirm()
   {
      return jabConfirm;
   }

   public void setJabConfirm(int jabConfirm)
   {
      this.jabConfirm = jabConfirm;
   }

   public int getKickBack()
   {
      return kickBack;
   }

   public void setKickBack(int kickBack)
   {
      this.kickBack = kickBack;
   }

   public int[] getKeyList()
   {
      return new int[]
      {
            up, down, left, right, jabConfirm, kickBack
      };
   }

}
