package game_client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class GameInterface extends JLayeredPane implements ActionListener
{
   public static State               state;
   public static InterfaceKeyAdapter adapt;
   private Timer                     timer;
   private ModeSelect                modeSelect;
   private StartScreen               startScreen;
   private CharSelect                charSelect;
   private int                       compCount;

   public GameInterface()
   {
      // initialize miscellaneous
      adapt = new InterfaceKeyAdapter();
      compCount = 0;
      state = State.START_SCREEN;

      // initialize all the components
      modeSelect = new ModeSelect();
      startScreen = new StartScreen();
      charSelect = new CharSelect();

      // add all the components
      addComp(modeSelect);
      addComp(charSelect);
      addComp(startScreen);

      setFocusable(true);
      setOpaque(true);
      timer = new Timer(17, this); // close to 60fps (1000ms/60)
      addKeyListener(adapt);
      timer.start();
   }

   /**
    * This method used to add components to the layered pane and also give the
    * component a layer number
    */
   private void addComp(Component comp)
   {
      ++compCount;
      add(comp, new Integer(compCount));
   }

   /**
    * Switches comp with the front component
    * 
    * @param comp
    */
   private void bringCompToFront(Component comp)
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
   }

   public void tick()
   {
      // Graphics2D g2d = (Graphics2D) g;
      switch (state)
      {
         case START_SCREEN:
         {
            bringCompToFront(startScreen);
            // if line 41 active then
            // g2d.drawImage(startScreenImg.getImage(), 0, 0, null);
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

   @Override
   public void actionPerformed(ActionEvent e) // each time timer ticks, this method is called
   {
      tick();
   }

}
