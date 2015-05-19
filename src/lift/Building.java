package lift;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Building {
	 
	private int floor;
	private int lift;
	private int basement;
	private int[][] contextmatrix=null;
	public void initialContext()
			{
		
		int i=getFloor()+getBasement();
		int j=getLift();
	   for(int row=0;row<i;row++)
	   {		   
		for(int col=0;col<j;col++){	
		contextmatrix[row][col]=0;
	
		}
	  }
	   	}
	
	public void getContextUserInput(){
		
		getflor();
		getbasement();
		getlif();
		
		contextmatrix=new int[floor+basement][lift];	
	}
	public int getflor(){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the floors");
		if(in.hasNextInt()){
			int fo=in.nextInt();
			if(fo>0){
			floor=fo;
			
		}
		else{
			System.out.println("Invalid floors number !!!");
			getflor();
		}
		}	
		else{
				System.out.println("Invalid floors number !!!");
				getflor();
			}
		return floor;
		
	}
	public int getbasement(){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the Basements:");
		if(in.hasNextInt()){
			int base=in.nextInt();
			if(base>0){
				basement=base;	
				}
				else{
					System.out.println("Invalid Basements number !!!");
					getbasement();
				}
		}
		else{
			System.out.println("Invalid Basements number !!!");
			getbasement();
		}
		
		return basement ;
	}
	public int getlif(){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the lifts");
		if(in.hasNextInt()){
			int li=in.nextInt();
			if(li>0){
				lift=li;	
			}
			else{
				System.out.println("Invalid lifts number !!!");
				getlif();
			}
		}
		else{
			System.out.println("Invalid lifts number !!!");
			getlif();
		}
		return lift;
		
	}
	
	public int getFloor() {
	
		return floor;
		
	}

	public void setFloor(int floor) {
		this.floor = floor;
		
	}

	public int getLift() {
		return lift;
	}

	public void setLift(int lift) {
		this.lift = lift;
	}
	
	public int getBasement() {
		return basement;
	}

	public void setBasement(int basement) {
		this.basement = basement;
	}
	 
	 private List<Elevator> elevators = null;
	 
	
	 
	 public Building() {
		this.elevators = new ArrayList<Elevator>();
		
	}
	 
	 public void addElevator(Elevator e){
		 this.elevators.add(e);
	 }
	 
	 

	public void showCurrentStatus() {
		int fno=getFloor()-1;
		System.out.println("**********************************************************");
		System.out.println("************     Welcome To The Building        ************");
		System.out.println("**********************************************************");
		int i=getFloor()+getBasement();
		int j=getLift();
		initialContext();
		
		for ( Elevator e : elevators) {
			contextmatrix[e.getCurrentFloor()+basement][e.getId()-1]=1;
			
			System.out.println( "Elevator #" + e.getId() + " is in  Floor#" + e.getCurrentFloor() );
			
		}

		for(int row=i-1;row>=0;row--){
			for(int col=0;col<j;col++){
				if(contextmatrix[row][col]==0){
					System.out.print("@"+" ");
				
				}
				else{
					System.out.print("*"+" ");
					
				}
				
			}
			System.out.print("    ");
			System.out.print("-----");
			System.out.print("Floor no:"+fno--);
			System.out.println();
			System.out.println();
		}
	}
	public  Elevator chooseElevatorToMoveUp(int src){
		Elevator downElv = null;
		Map<Elevator, Integer> diffMap = new HashMap<>();
		
		for ( Elevator e : elevators) {
			int  diff= e.getCurrentFloor()-src;
			diff=Math.abs(diff);
			diffMap.put(e, diff);

			}
		
		List<Integer> valueList = new ArrayList<>(diffMap.values());
		Collections.sort(valueList);
		valueList.get(0);
		for (Elevator e : diffMap.keySet()){
			if(diffMap.get(e)==valueList.get(0)){
				downElv=e;	
			}
			
		}
		return downElv;
	
	}
	public  Elevator chooseElevatorToMoveDown(int src){
		
		Elevator downElv = null;
		Map<Elevator, Integer> diffMap = new HashMap<>();
		
		for ( Elevator e : elevators) {
			int  diff= src-e.getCurrentFloor();
			diff=Math.abs(diff);
			
			diffMap.put(e, diff);
		}
		List<Integer> valueList = new ArrayList<>(diffMap.values());
		Collections.sort(valueList);
		valueList.get(0);
		for (Elevator e : diffMap.keySet()) {
			if( diffMap.get(e)==valueList.get(0)){
				downElv = e;
			}
		}
		return downElv;
	  
	
	}

	public Elevator getNextElevator(int src, int dest) {
		Elevator next = null;
		if(src > dest){
			next = chooseElevatorToMoveDown(src);
		}else{
			next = chooseElevatorToMoveUp(src);
		}
		return next;
	}

	public void moveElevator(Elevator nextElevator, int src, int dest) {
		// TODO Auto-generated method stub
		
		if(src>dest){
			int i=1;
			while(nextElevator.getCurrentFloor()!=src){
				if(nextElevator.getCurrentFloor()>src){
					nextElevator.moveDownByOneFloor();
				}
				else{
					nextElevator.moveUpByOneFloor();
				}
				i++;
			}
			for(int j=nextElevator.getCurrentFloor();j>dest;j--){
				
				
				nextElevator.moveDownByOneFloor();
					
				}
			
			
			}
		
		else{
			
			int i=1;
			while(nextElevator.getCurrentFloor()!=src){
			
				if(nextElevator.getCurrentFloor()>src){
					
					nextElevator.moveDownByOneFloor();				
				}
				else{
					nextElevator.moveUpByOneFloor();
					
				}
				i++;
				
			}
			
			
			
			for(int j=nextElevator.getCurrentFloor();j<dest;j++)
			
			{
			
				nextElevator.moveUpByOneFloor();
		}
			
		}
	}
	

}
	


	
	

	
	
	 
	
	



