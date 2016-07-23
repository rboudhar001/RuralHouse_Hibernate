package businessLogic;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;

import configuration.Config;

/**
 * Activate the remote server
 * 
 * @param None
 * @return None
 */

public class RemoteServer {
	public static void main(String[] args) {
		Config c=Config.getInstance();

		 
		System.setProperty("java.security.policy", c.getJavaPolicyPath());
		
		
		//System.setSecurityManager(new RMISecurityManager());
		
		try {
			java.rmi.registry.LocateRegistry.createRegistry(Integer.parseInt(c.getPortRMI()));
			// Create RMIREGISTRY
		} catch (Exception e) {
			System.out.println(e.toString() + "Rmiregistry already running.");
		}

		try {
			
			System.setProperty("java.security.policy", c.getJavaPolicyPath());

			//System.setProperty("java.security.policy","c:\\isoGrado\\CasaRural2010\\java2.policy");

			ApplicationFacadeInterface server = new FacadeImplementation();

			String service= "//"+c.getServerRMI() +":"+ c.getPortRMI()+"/"+c.getServiceRMI();
			
			// Register the remote server
			Naming.rebind(service, (Remote) server);
			System.out.println("Running service at:\n\t" + service);
			//This operation removes the actual database and initialize with predefined values
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}