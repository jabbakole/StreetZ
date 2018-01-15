package game_client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

import game_client.components.BaseComponent;
import game_client.components.CharSelect;
import game_client.components.Controls;
import game_client.components.ModeSelect;
import game_client.components.StageSelect;
import game_client.components.StartScreen;

public class GameInterface extends JLayeredPane implements ActionListener
{

   public static State               state;
   public static InterfaceKeyAdapter adapt;
   private Timer                     timer;

   // Player Keys
   private PlayerKeys player1;
   private PlayerKeys player2;

   // Player Character id-ing
   private String character1;
   private String character2;
   
   // Stage id-ing
   private String stage;

   // Components & related stuff for different states
   private ArrayList<BaseComponent> componentList;
   private ModeSelect               modeSelect;
   private StartScreen              startScreen;
   private CharSelect               charSelect;
   private Controls                 controls;
   private StageSelect              stageSelect;

   private int compCount;

   public GameInterface()
   {
      // initialize buttons
      player1 = new PlayerKeys(1);
      player2 = new PlayerKeys(2);

      // initialize character ids
      character1 = "";
      character2 = "";

      // initialize all the components and related
      compCount = 0;
      componentList = new ArrayList<>();
      modeSelect = new ModeSelect();
      startScreen = new StartScreen();
      charSelect = new CharSelect(character1, character2);
      controls = new Controls(player1, player2);
      stageSelect = new StageSelect(stage);

      // add all the components
      addComp(modeSelect);
      addComp(charSelect);
      addComp(controls);
      addComp(stageSelect);
      addComp(startScreen);

      // initialize miscellaneous
      adapt = new InterfaceKeyAdapter(player1, player2);
      state = State.START_SCREEN;
      setFocusable(true);
      setOpaque(true);
      timer = new Timer(17, this); // close to 60fps (1000ms/60)
      addKeyListener(adapt);
      // make sure start timer comes after everything else lmao
      timer.start();
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
      // small problem: on start screen, all timers are running
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
      // somehow if requestFocus() isn't here, something else takes the focus and the
      // keyadapter doesn't work since it needs this to be focused
      requestFocus();
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
            bringCompToFront(controls);
            break;
         }
         case CHAR_SELECT:
         {
            bringCompToFront(charSelect);
            break;
         }
         case STAGE_SELECT:
         {
            bringCompToFront(stageSelect);
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
      if (!thisOne.timerIsRunning())
      {
         thisOne.startTimer();  
      }
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
