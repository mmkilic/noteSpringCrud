package mmk.crud.fetch;

public enum EnumDepartments {

	NONE(0),
	PLANT_MANAGEMENT(1),
	FINANCE(2),
	HUMAN_RESOURCES(3),
	PURCHISING(4),
	SALES(5),
	IT(6),
	SUPPLY_CHAIN(7),
	QUALITY(8),
	SERVICE(9),
	PRODUCTION(10),
	ENGINEERING(11),
	PROJECT_MANAGEMENT(12);
	
	private final int CODE;
	
	private EnumDepartments(int code) {
		this.CODE = code;
	}
	
	public int getCode() {
		return this.CODE;
	}
	
}
