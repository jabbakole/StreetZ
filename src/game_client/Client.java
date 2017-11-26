package game_client;

import javax.swing.JFrame;

public class Client extends JFrame
{
   public static void main(String[] args)
   {
      try
      {
         Client client = new Client();
         client.setVisible(true);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public Client()
   {
      setBounds(100, 100, 450, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}
