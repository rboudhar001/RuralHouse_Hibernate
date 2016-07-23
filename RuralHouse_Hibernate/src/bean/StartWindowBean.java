package bean;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.event.ValueChangeEvent;

import domain.Book;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;
import businessLogic.ApplicationFacadeInterface;
import businessLogic.FacadeImplementation;

public class StartWindowBean {
	
	//LOGICA DE NEGOCIO
	private ApplicationFacadeInterface facadeJSF;
	
	//CONSTRUCTOR
	public StartWindowBean() throws Exception {
		//facadeJSF = new FacadeImplementation();
		facadeJSF = FacadeSingleton.getInstance();
	}
	
	// START WINDOW
	//------------------------------------------------------------------------------------------
	public String eliminarDueno() {
		// TODO Auto-generated method stub
		return "removeOwner";
	}
	
	//
	public String anadirCasaRural() {
		// TODO Auto-generated method stub
		return "addRuralHouse";
	}
	
	//
	public String eliminarCasaRural() {
		// TODO Auto-generated method stub
		return "removeRuralHouse";
	}
	
	//
	public String crearOferta() {
		// TODO Auto-generated method stub
		return "setAvailability";
	}
	//
	public String eliminarOfertaUno() {
		// TODO Auto-generated method stub
		return "removeSetAvailabilityOne";
	}
	
	
	
	
	
	
	
	
	
	
	
	//
	public String consultarOferta() {
		// TODO Auto-generated method stub
		return "queryAvailability";
	}
	
	//
	public String consultarOfertaReserva() {
		// TODO Auto-generated method stub
		return "queryAvailabilityBook";
	}
	
	//
	public String reservarCasaRural() {
		// TODO Auto-generated method stub
		return "bookRuralHouse";
	}
	//------------------------------------------------------------------------------------------
}
