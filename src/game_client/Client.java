package game_client;
// test

import javax.swing.JFrame;

public class Client extends JFrame
{
   public static void main(String[] args)
   {
      Client client = new Client();
   }

   public Client()
   {
      setBounds(500, 200, 1280, 720);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      setTitle("StreetZ");
      GameInterface game = new GameInterface();
      game.setSize(1280, 720);
      game.setOpaque(true);
      setContentPane(game);
   }

   public void exit()
   {
      System.exit((Integer) null);
   }

}
