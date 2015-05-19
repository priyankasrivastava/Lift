package lift;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ElevatorPanel {
	int source;
	int destination;
	
	 public   List<Integer> getUserInput(){
		 List<Integer> list=new ArrayList<Integer>();
		 
		 int s=getSource();
		  int d=getDest(); 
		 System.out.println("Source is"+s +""+"Destination is"+d);
		list.add(s);
		list.add(d);
		 
		 return list;
		
	 }
	 public int getSource(){
		 
		 Building building=Starter.building;
		 
		 Scanner in = new Scanner(System.in);
		 System.out.println("Where are you:");
		int so=in.nextInt();
		if(-1*building.getBasement()<=so && so<building.getFloor())
		{
			 source=so;
			System.out.println("-------------------------------");
		}
		else{
			System.out.println("Invalid floor number you Entered !!!");
			getSource();
		}
		 return source;
		 
	 }
	 public int getDest(){
	  Building building=Starter.building;
		 
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter the floor number you want to go:");
		 int de=in.nextInt();
		 if(-1*building.getBasement()<=de && de<building.getFloor()){
			 destination=de;
			 System.out.println("---------------------------------");
		 }
		 else{
			 System.out.println("Invalid floor number you Entered !!!");
			 getDest();
		 }
		
		return destination;
		 
	 }
	 
}
