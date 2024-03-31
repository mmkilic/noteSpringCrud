package mmk.crud.polymorphic;

public enum EnumEngineType {

	DIESEL(1),
	PETROL(2);
	
	private final int CODE;
	
	private EnumEngineType(int code) {
		this.CODE = code;
	}
	
	public int getCode() {
		return this.CODE;
	}
	
}
