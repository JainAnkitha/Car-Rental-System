package domain;

/**
 * 
 * @author Ankitha
 * Below enum consist different types of Toyota and Honda Cars
 */

public enum CarType{

	TOYOTA1("Avalon"),
	
	TOYOTA2("Camry"),
	
	TOYOTA3("Corolla"),
	
	TOYOTA4("Highlander"),
	
	TOYOTA5("Prius"),
	
	HONDA1("Accord"),
	
	HONDA2("CRV"),
	
	HONDA3("Civic"),
	
	HONDA4("Odyssey"),
	
	HONDA5("Pilot");
	
	private final String carTypeName;

	public String getCarTypeName() {
		return carTypeName;
	}
	private CarType(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	
	public static CarType fromValue(String c){
		for(CarType v: CarType.values()){
			if(v.getCarTypeName().equalsIgnoreCase(c)){
				return v;
			}
		}
		throw new IllegalArgumentException(c);
	}
	
//	@Override
//	public String toString(){
//		return "CarType{ carName = "+ carTypeName + "}";
//	}
}
