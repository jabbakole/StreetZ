package game_client;

import javax.swing.JFrame;

public class Client extends JFrame
{
   public static void main(String[] args)
   {
      try
      {
         Client client = new Client();
         GameInterface game = new GameInterface();
         client.add(game);
         client.setVisible(true);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public Client()
   {
      setBounds(500, 200, 1280, 720);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("StreetZ");
   }

}
