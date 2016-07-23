package configuration;


public class Config {


	private final String serverRMI = "localhost";

	private final String portRMI = "10099";

	private final String serviceRMI = "RuralHouses";
	
	//private final String javaPolicyPath="/Users/joniturrioz/Asignaturas/gradoISO/CasaRuralSG/java.policy";
	private final String javaPolicyPath = "C:\\Users\\Richi\\workspace\\workspace_RuralHouseJSF\\RuralHouse_JSF\\java.policy";
	//"C:\Users\Richi\workspace\workspace_RuralHouseJSF\RuralHouse_JSF"
	
	final static String db4oFilename = "C:\\Users\\Richi\\workspace\\workspace_RuralHouseJSF\\RuralHouse_JSF\\casas.db4o";
	//final static String db4oFilename = "/Users/joniturrioz/DB/ruralHouses.db4o";
	//private final  String db4oFilename = "/Users/joniturrioz/Desktop/DB/demo74.db";
	
	//Two possible values: "open" or "initialize"
	private final String dataBaseOpenMode="initialize";

	private static Config theInstance = new Config();

    private Config(){}
	

	

	public static Config getInstance() {
		return theInstance;
	}


	public String getServerRMI() {
		return serverRMI;
	}

	public String getPortRMI() {
		return portRMI;
	}

	public String getServiceRMI() {
		return serviceRMI;
	}
	public String getDb4oFilename(){
		return db4oFilename;
	}
	public String getJavaPolicyPath(){
		return javaPolicyPath;
	}
	public String getDataBaseOpenMode(){
		return dataBaseOpenMode;
	}

}
