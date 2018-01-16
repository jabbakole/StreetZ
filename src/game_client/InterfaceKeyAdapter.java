package game_client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game_client.components.CharSelect;
import game_client.components.Controls;
import game_client.components.StageSelect;

public class InterfaceKeyAdapter implements KeyListener
{

   private PlayerKeys p1;
   private PlayerKeys p2;

   public InterfaceKeyAdapter(PlayerKeys p1, PlayerKeys p2)
   {
      super();
      this.p1 = p1;
      this.p2 = p2;
   }

   // FOR MODESELECT
   public static int modeNum = 1;
   // 1 = fight
   // 2 = controls
   // 3 = quit

   // FOR CHARSELECT
   public static int charCol1 = 0;
   public static int charRow1 = 0;
   public static int charCol2 = 0;
   public static int charRow2 = 0;
   // 11 = somedude
   // 12 = someotherdude
   // ...
   // 21 = someotherotherdude
   // ...

   // FOR CONTROLS
   public static int p1Row = 0;
   public static int p2Row = 0;
   // [0] = up;
   // [1] = right;
   // [2] = down;
   // [3] = left;
   // [4] = jabConfirm;
   // [5] = kickBack;
   public static int keypress = -1;
   // for setting a new key in controls
   // -1 is not one of the key constants in keyevent

   // FOR STAGESELECT
   public static int stageCycler = 0;

   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      switch (GameInterface.state)
      {
         case START_SCREEN:
         {
            if ((key == KeyEvent.VK_ENTER) || (key == p1.getJabConfirm()) || (key == p2.getJabConfirm()))
            {
               GameInterface.state = State.MODE_SELECT;
            }
            break;
         }
         case MODE_SELECT:
         {
            if ((key == p1.getDown()) || (key == p2.getDown()))
            {
               // there'll be circular linked list in mode select jcomponent; focus the next
               // mode in the list
               if (modeNum < 3)
                  modeNum++;
               else if (modeNum == 3)
                  modeNum = 1;
            }
            else if ((key == p1.getUp()) || (key == p2.getUp()))
            {
               if (modeNum > 1)
                  modeNum--;
               else if (modeNum == 1)
                  modeNum = 3;
               // same as above
            }
            else if ((key == KeyEvent.VK_BACK_SPACE) || (key == p1.getKickBack()) || (key == p2.getKickBack()))
            {
               GameInterface.state = State.START_SCREEN;
            }
            else if ((key == KeyEvent.VK_ENTER) || (key == p1.getJabConfirm()) || (key == p2.getJabConfirm()))
            {
               // depending on which button is focused in the circular list, go to that state
               // (controls, char sel, stage sel)
               switch (modeNum)
               {
                  case (1):
                  {
                     GameInterface.state = State.CHAR_SELECT;
                     break;
                  }
                  case (2):
                  {
                     GameInterface.state = State.CONTROLS;
                     break;
                  }
                  case (3):
                  {
                     System.exit(1); // no idea how graceful this is??
                     break;
                  }
               }
            }
            break;
         }
         case CONTROLS:
         {
            switch (Controls.state)
            {
               case (0):
               {
                  if (key == p1.getDown())
                  {
                     ++p1Row;
                     if (p1Row > 5)
                     {
                        p1Row = 0;
                     }
                  }
                  else if (key == p2.getDown())
                  {
                     ++p2Row;
                     if (p2Row > 5)
                     {
                        p2Row = 0;
                     }
                  }
                  else if (key == p1.getUp())
                  {
                     --p1Row;
                     if (p1Row < 0)
                     {
                        p1Row = 5;
                     }
                  }
                  else if (key == p2.getUp())
                  {
                     --p2Row;
                     if (p2Row < 0)
                     {
                        p2Row = 5;
                     }
                  }
                  else if (key == p1.getJabConfirm())
                  {
                     Controls.state = 1;
                  }
                  else if (key == p2.getJabConfirm())
                  {
                     Controls.state = 2;
                  }
                  else if ((key == p1.getKickBack()) || (key == p2.getKickBack()) || (key == KeyEvent.VK_BACK_SPACE))
                  {
                     GameInterface.state = State.MODE_SELECT;
                  }
                  break;
               }
               case (1):
               {
                  keypress = key;
                  // this only works cuz it's 60 fps laolmao
                  // would like to fix but it's 99.9% a nonissue
                  break;
               }
               case (2):
               {
                  keypress = key;
                  break;
               }
               case (3):
               {
                  Controls.state = 0;
                  break;
               }
            }
            break;
         }
         case CHAR_SELECT:
         {
            if (CharSelect.is1Locked && CharSelect.is2Locked)
            {
               if (key == p1.getKickBack())
               {
                  CharSelect.is1Locked = false;
               }
               else if (key == p2.getKickBack())
               {
                  CharSelect.is2Locked = false;
               }
               // if neither presses back, and someone presses anything, go to stageselect
               else
               {
                  GameInterface.state = State.STAGE_SELECT;
                  // reset everything
                  CharSelect.is1Locked = false;
                  CharSelect.is2Locked = false;
                  charCol1 = 0;
                  charCol2 = 0;
                  charRow1 = 0;
                  charRow2 = 0;
               }
            }
            else
            {
               // handle p1:
               if (!CharSelect.is1Locked)
               {
                  if ((key == p1.getRight()) && charCol1 < 3)
                  {
                     charCol1++;
                  }
                  else if ((key == p1.getLeft()) && charCol1 > 0)
                  {
                     charCol1--;
                  }
                  else if ((key == p1.getDown()) && (charRow1 == 0))
                  {
                     charRow1++;
                  }
                  else if ((key == p1.getUp()) && (charRow1 == 1))
                  {
                     charRow1--;
                  }
                  else if (key == p1.getKickBack())
                  {
                     // reset everything
                     CharSelect.is1Locked = false;
                     CharSelect.is2Locked = false;
                     charCol1 = 0;
                     charCol2 = 0;
                     charRow1 = 0;
                     charRow2 = 0;
                     GameInterface.state = State.MODE_SELECT;
                  }
                  else if (key == p1.getJabConfirm())
                  {
                     CharSelect.is1Locked = true;
                  }
               }
               else
               {
                  if (key == p1.getKickBack())
                  {
                     CharSelect.is1Locked = false;
                  }
               }

               // handle p2:
               if (!CharSelect.is2Locked)
               {
                  if ((key == p2.getRight()) && charCol2 < 3)
                  {
                     charCol2++;
                  }
                  else if ((key == p2.getLeft()) && charCol2 > 0)
                  {
                     charCol2--;
                  }
                  else if ((key == p2.getDown()) && (charRow2 == 0))
                  {
                     charRow2++;
                  }
                  else if ((key == p2.getUp()) && (charRow2 == 1))
                  {
                     charRow2--;
                  }
                  else if (key == p2.getKickBack())
                  {
                     // reset everything
                     CharSelect.is1Locked = false;
                     CharSelect.is2Locked = false;
                     charCol1 = 0;
                     charCol2 = 0;
                     charRow1 = 0;
                     charRow2 = 0;
                     GameInterface.state = State.MODE_SELECT;
                  }
                  else if (key == p2.getJabConfirm())
                  {
                     CharSelect.is2Locked = true;
                  }
               }
               else
               {
                  if (key == p2.getKickBack())
                  {
                     CharSelect.is2Locked = false;
                  }
               }
            }
            break;
         }
         case STAGE_SELECT:
         {
            if (!StageSelect.isStageSelected)
            {
               if (key == p1.getKickBack())
               {
                  GameInterface.state = State.CHAR_SELECT;
               }
               else if (key == p2.getKickBack())
               {
                  GameInterface.state = State.CHAR_SELECT;
               }
               else if (key == p1.getRight() || key == p2.getRight())
               {
                  stageCycler = 1;
               }
               else if (key == p1.getLeft() || key == p2.getLeft())
               {
                  stageCycler = -1;
               }
               else if (key == p1.getJabConfirm() || key == p2.getJabConfirm())
               {
                  StageSelect.isStageSelected = true;
               }
            }
            else
            {
               if (key == p1.getKickBack() || key == p2.getKickBack())
               {
                  StageSelect.isStageSelected = false;
               }
               else
               {
                  StageSelect.isStageSelected = false;
                  stageCycler = 0;
                  GameInterface.state = State.VERSUS;
               }
            }
            break;
         }
         case VERSUS:
         {
            if (key == p1.getKickBack() || key == p2.getKickBack())
            {
               GameInterface.state = State.STAGE_SELECT;
            }
            break;
         }
      }

   }

   @Override
   public void keyReleased(KeyEvent e)
   {

   }

   @Override
   public void keyTyped(KeyEvent e)
   {

   }

}
