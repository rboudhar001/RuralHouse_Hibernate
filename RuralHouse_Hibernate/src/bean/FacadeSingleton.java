package bean;

import java.util.Date;

import domain.Owner;
import domain.RuralHouse;
import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;

public class FacadeSingleton {
	
	private static ApplicationFacadeInterface instance = null;
	
	private static Owner owner = null;
	private static RuralHouse ruralHouse = null;
	private static Date firstDayBook;
	private static Date lastDayBook;
	
	protected FacadeSingleton() {
	}
	
	public static ApplicationFacadeInterface getInstance() {
		if(instance == null) {
			instance = new FacadeImplementation();
		}
		return instance;
	}
	
	public static Owner getOwnerLoged() {
		return owner;
	}
	
	public static void setOwnerLoged(Owner owner) {
		FacadeSingleton.owner = owner;
	}
	
	public static RuralHouse getRuralHouseSelected() {
		return ruralHouse;
	}
	
	public static void setRuralHouseSelected(RuralHouse ruralHouse) {
		FacadeSingleton.ruralHouse = ruralHouse;
	}
	
	public static Date getFirstDayBook() {
		return firstDayBook;
	}
	
	public static void setFirstDayBook(Date firstDayBook) {
		FacadeSingleton.firstDayBook = firstDayBook;
	}
	
	public static Date getLastDayBook() {
		return lastDayBook;
	}
	
	public static void setLastDayBook(Date lastDayBook) {
		FacadeSingleton.lastDayBook = lastDayBook;
	}
}
