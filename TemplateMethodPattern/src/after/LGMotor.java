package after;

public class LGMotor extends Motor{

	public LGMotor(Door door) {
		super(door);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void moveMotor(Direction direction) {
		System.out.println("LGMotor 구동시킴");
	}

}
