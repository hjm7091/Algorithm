package after;

public class Client {

	public static void main(String[] args) {
		Door door = new Door();
		Motor hyundaiMotor = new HyundaiMotor(door);
		hyundaiMotor.move(Direction.UP);
		
		Motor lgMotor = new LGMotor(door);
		lgMotor.move(Direction.DOWN);
	}
	
}
