package lift;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Starter {
	
	
     static Building building = new Building();
   private  static ElevatorPanel panel=new ElevatorPanel();
	public static void main(String[] args)
	{
	
		building.getContextUserInput();		
		initializeBuilding();
		building.showCurrentStatus();
		while(true){
		
		List<Integer> userInput = panel.getUserInput();
		for(int i=0;i<userInput.size();i++){
			userInput.get(i);
		}
		int src=userInput.get(0);
		int dest=userInput.get(1);
		Elevator nextElevator = building.getNextElevator(src, dest);
		System.out.println("Elevator #" + nextElevator.getId() + "  is availble for you...");
		System.out.println("Moving to your Destination....... ......");
		building.moveElevator(nextElevator, src, dest);
		System.out.println("Elevator " + nextElevator.getId() + "has reached to floor " + dest);
		building.showCurrentStatus();
	    
	}
	}
	
	
	public static void initializeBuilding()
	{
		Random ra=new Random();
		for(int i=1;i<=building.getLift();i++)
		{
			
		for(int j=i;j<=i;j++){
			System.out.println(" The floor number for Lift:"+i +"is"+":");
			int flor=(ra.nextInt(building.getFloor()-1)+1);
			System.out.println(flor);
			building.addElevator(new Elevator(i,flor));
			
		}
		
		
		
     
		
		}
		
	}
	
	
	
}
