package lift;

public class Elevator {
	
	private int Id;
	private int currentFloor;
    
	public  Elevator(int elevatorId,int initialFloor) {
		Id=elevatorId;
		currentFloor=initialFloor;
	
	}
	public Elevator() {
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	 
	
	 public void moveUpByOneFloor(){
		
		setCurrentFloor(getCurrentFloor() + 1);
	 }
	 
	 public void moveDownByOneFloor(){
		
	 setCurrentFloor(getCurrentFloor()-1);
}
	

}
