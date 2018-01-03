package game_client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class GameInterface extends JLayeredPane implements ActionListener
{

   public static State               state;
   public static InterfaceKeyAdapter adapt;
   private Timer                     timer;
   
   // Player Keys
   private PlayerKeys player1;
   private PlayerKeys player2;

   // Components & related stuff for different states
   private ArrayList<BaseComponent>  componentList;
   private ModeSelect                modeSelect;
   private StartScreen               startScreen;
   private CharSelect                charSelect;
   private int                       compCount;

   public GameInterface()
   {
      // initialize buttons
      player1 = new PlayerKeys(1);
      player2 = new PlayerKeys(2);
      
      // initialize miscellaneous
      adapt = new InterfaceKeyAdapter(player1, player2);
      state = State.START_SCREEN;
      setFocusable(true);
      setOpaque(true);
      timer = new Timer(17, this); // close to 60fps (1000ms/60)
      addKeyListener(adapt);
      timer.start();

      // initialize all the components and related
      compCount = 0;
      componentList = new ArrayList<>();
      modeSelect = new ModeSelect();
      startScreen = new StartScreen();
      charSelect = new CharSelect();

      // add all the components
      addComp(modeSelect);
      addComp(charSelect);
      addComp(startScreen);
   }

   /**
    * This method used to add components to the layered pane and also give the
    * component a layer number
    */
   private void addComp(BaseComponent comp)
   {
      ++compCount;
      add(comp, new Integer(compCount));
      componentList.add(comp);
   }

   /**
    * Switches comp with the front component
    * 
    * @param comp
    */
   private void bringCompToFront(BaseComponent comp)
   {
      int compZ = getLayer(comp);
      // if the component is already in front, return
      if (compZ == compCount)
      {
         return;
      }
      // there's only a method to return array of all components within a layer..
      Component[] frontComp = getComponentsInLayer(compCount);
      // We're only doin 1 component per layer so can hardcode the first one [0]
      setLayer(frontComp[0], compZ);
      setLayer(comp, compCount);
      stopAllTimersBut(comp);
   }

   public void tick()
   {
      switch (state)
      {
         case START_SCREEN:
         {
            bringCompToFront(startScreen);
            break;
         }
         case MODE_SELECT:
         {
            bringCompToFront(modeSelect);
            break;
         }
         case CONTROLS:
         {
            break;
         }
         case CHAR_SELECT:
         {
            bringCompToFront(charSelect);
            break;
         }
         case STAGE_SELECT:
         {
            break;
         }
         case VERSUS:
         {
            break;
         }
      }
   }

   // self documenting
   private void stopAllTimersBut(BaseComponent thisOne)
   {
      thisOne.startTimer();
      for (BaseComponent x : componentList)
      {
         if (x != thisOne)
         {
            x.stopTimer();
         }
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

}
