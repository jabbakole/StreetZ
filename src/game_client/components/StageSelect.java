package game_client.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import game_client.InterfaceKeyAdapter;
import ui_tools.StageIcon;

public class StageSelect extends BaseComponent
{
   private Image bg;

   private StageIcon zebra;
   private StageIcon mars;
   private StageIcon palm;
   private StageIcon spook;
   private StageIcon tokyo;

   public static boolean isStageSelected;

   private class CircularDoublyLinked<T>
   {

      private Node<T> headNode;
      private Node<T> currNode;
      private int     size;

      private class Node<T>
      {

         private T       data;
         private Node<T> nextNode;
         private Node<T> prevNode;

         public Node(T data)
         {
            this.data = data;
         }

         public T getData()
         {
            return data;
         }

         public void setData(T data)
         {
            this.data = data;
         }

         public Node<T> getNextNode()
         {
            return nextNode;
         }

         public Node<T> getPrevNode()
         {
            return prevNode;
         }

         public void setNextNode(Node<T> a)
         {
            nextNode = a;
         }

         public void setPrevNode(Node<T> a)
         {
            prevNode = a;
         }
      }

      public CircularDoublyLinked(T headData)
      {
         headNode = new Node<T>(headData);
         currNode = headNode;
         headNode.setNextNode(headNode);
         headNode.setPrevNode(headNode);
         size = 1;
      }

      public void addData(T data)
      {
         if (size == 1)
         {
            Node<T> nextNode = new Node<T>(data);
            headNode.setNextNode(nextNode);
            headNode.setPrevNode(nextNode);
            nextNode.setPrevNode(headNode);
            nextNode.setNextNode(headNode);
         }
         else
         {
            Node<T> rightNode = headNode.getNextNode();
            Node<T> leftNode = headNode;
            Node<T> midNode = new Node<T>(data);

            leftNode.setNextNode(midNode);
            midNode.setPrevNode(leftNode);
            midNode.setNextNode(rightNode);
            rightNode.setPrevNode(midNode);
         }
         size++;
      }

      public T getPrevData()
      {
         return currNode.getPrevNode().getData();
      }

      public T getData()
      {
         return currNode.getData();
      }

      public T getNextData()
      {
         return currNode.getNextNode().getData();
      }

      public void cycleRight()
      {
         currNode = currNode.getNextNode();
      }

      public void cycleLeft()
      {
         currNode = currNode.getPrevNode();
      }

   }

   // to set the stage when it is picked
   private String stage;

   // circular list of all the stages
   private CircularDoublyLinked<StageIcon> stageList;

   public StageSelect(String stage)
   {
      timer.stop();
      this.stage = stage;
      initializeIcons();
      initializeStageList();
      isStageSelected = false;
      timer.start();
   }

   private void initializeStageList()
   {
      stageList = new CircularDoublyLinked<StageIcon>(zebra);
      stageList.addData(mars);
      stageList.addData(palm);
      stageList.addData(spook);
      stageList.addData(tokyo);
   }

   private void initializeIcons()
   {
      bg = new ImageIcon("Data/stageselect/stagebg.png").getImage();

      zebra = new StageIcon("Data/stageselect/giantzebra_icon.png", "GIANT ZEBRA");
      mars = new StageIcon("Data/stageselect/mars_icon.png", "MARS");
      palm = new StageIcon("Data/stageselect/palmofthebuddha_icon.png", "PALM OF THE BUDDHA");
      spook = new StageIcon("Data/stageselect/spookyland_icon.png", "SPOOKYLAND");
      tokyo = new StageIcon("Data/stageselect/tokyo_icon.png", "TOKYO");

   }

   @Override
   public void paintComponent(Graphics g)
   {
      g.drawImage(bg, 0, 0, this);

      g.drawImage(stageList.getPrevData().getLeft(), 200, 250, this);
      g.drawImage(stageList.getNextData().getRight(), 900, 250, this);
      g.drawImage(stageList.getData().getCenter(), 390, 250, this);
      g.setFont(new Font("Arial", Font.BOLD, 36));
      g.setColor(Color.WHITE);
      g.drawString(stageList.getData().toString(), 50, 650);
      if (isStageSelected)
      {
         g.drawString("Pls press kEy for CoNfIrmed? :)", 700, 650);
      }
   }

   @Override
   public void tick()
   {
      if (!isStageSelected)
      {
         if (InterfaceKeyAdapter.stageCycler == 1)
         {
            stageList.cycleRight();
            InterfaceKeyAdapter.stageCycler = 0;
         }
         else if (InterfaceKeyAdapter.stageCycler == -1)
         {
            stageList.cycleLeft();
            InterfaceKeyAdapter.stageCycler = 0;
         }
      }
      else
      {
         stage = stageList.getData().toString();
      }
      repaint();
   }
}
