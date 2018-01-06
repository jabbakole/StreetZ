package game_client;

import javax.swing.JFrame;

public class Client extends JFrame
{
   public static void main(String[] args)
   {
      try
      {
         Client client = new Client();
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public Client()
   {
      setBounds(500, 200, 1280, 720);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      setTitle("StreetZ");
      GameInterface game = new GameInterface();
      game.setOpaque(true);
      setContentPane(game);
   }

   public void exit()
   {
      System.exit((Integer) null);
   }

}
