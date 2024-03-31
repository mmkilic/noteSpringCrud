package mmk.crud.polymorphic;

public enum EnumDoorType {

	NONE(0),
	FRONT_LEFT(11),
	FRONT_RIGHT(12),
	REAR_LEFT(21),
	REAR_RIGHT(22);
	
	private final int CODE;
	
	private EnumDoorType(int code) {
		this.CODE = code;
	}
	
	public int getCode() {
		return this.CODE;
	}
	
}
