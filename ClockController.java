import javax.swing.*;
public class ClockController
{
   private MovingPointer pointer;  
   private AnimationClockWriter writer;
   private GiveTime time; 


   public ClockController(MovingPointer b, AnimationClockWriter w, GiveTime t)
   { 
      pointer = b;
      writer = w;
      time=t;

   }

   public void runAnimation()
   {
      int time_unit = 1;    
      int painting_delay = 1000;
    
      char command =  time.readCommand("Command (S,M,H,Q) and time:");
    
      if ( command == 'Q')  
      {JOptionPane.showMessageDialog(null,"You have quit the program");  }   
      else  { 
         if ( command == 'S' )  
         {
            int amount = time.readAmount();
            int count =0;  
            while ( count <amount )
            { 
               delay(painting_delay);
               pointer.move(time_unit);
               count++; 
               writer.repaint();  
            }
         }
                                
          if ( command == 'M' )  
         { 
            int amount = time.readAmount()*60;
            int count =0;  
            while ( count <amount )
            { 
               delay(painting_delay);
               pointer.move(time_unit);
               count++; 
               writer.repaint();  
            }
          
         }
                 
         else if ( command == 'H' )  
         { 
            int amount = time.readAmount()*3600; 
            int count =0;  
            while ( count <amount )
            { 
               delay(painting_delay);
               pointer.move(time_unit);
               count++; 
               writer.repaint();  
            }
            
         }
         else { JOptionPane.showMessageDialog(null, "Time's up"); }
      }    
   } 

  
   private void delay(int how_long)
   { 
      try { Thread.sleep(how_long); }
      catch (InterruptedException e) { }
   }
}