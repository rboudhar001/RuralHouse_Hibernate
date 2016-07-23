package bean;

import java.util.Date;
import java.util.List;

import businessLogic.ApplicationFacadeInterface;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;

public class SetAvailabilityBean {

	//LOGICA DE NEGOCIO
	private ApplicationFacadeInterface facadeJSF;
	
	//CONSTRUCTOR
	public SetAvailabilityBean() throws Exception {
		facadeJSF = FacadeSingleton.getInstance();
	}
	
	// OFFER
	//------------------------------------------------------------------------------------------
	//Para SetAvailability.xhtml
	private Date firstDay;
	private Date lastDay;
	private int price;
	
	//Para RemoveSetAvailability.xhtml
	private Owner owner = FacadeSingleton.getOwnerLoged();
	private RuralHouse ruralHouse = FacadeSingleton.getRuralHouseSelected();
	private Offer offer;
	
	//Listas
	private List<RuralHouse> listaRuralHouses;
	private List<Offer> listaOffers;
	//------------------------------------------------------------------------------------------
	
	// FUNCIONES : OFFER
	//------------------------------------------------------------------------------------------
	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public Date getLastDay() {
		return lastDay;
	}

	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public RuralHouse getRuralHouse() {
		return ruralHouse;
	}

	public void setRuralHouse(RuralHouse ruralHouse) {
		this.ruralHouse = ruralHouse;
	}
	
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public String addOffer() throws Exception {
		
		if ( facadeJSF.createOffer(this.ruralHouse, this.firstDay, this.lastDay, this.price) != null ) {
			return "ok";
		}
		
		return "error";
	}
	
	//
	public String eliminarOfertaDos() {
		FacadeSingleton.setRuralHouseSelected(this.ruralHouse);
		
		// TODO Auto-generated method stub
		return "removeSetAvailabilityTwo";
	}
	
	//
	public String removeOffer() throws Exception {
		
		this.offer.setRuralHouse(this.ruralHouse);
		if ( facadeJSF.thisOfferHaveBook(offer) == false ) {
			
			if ( facadeJSF.removeOffer(offer) != null ) {
				return "ok";
			}
		}
		
		System.out.println("\nERROR, esta oferta tiene una reserva pendiente, no se puede borrar.");
		return "error";
	}
	//------------------------------------------------------------------------------------------
	
	// LISTAS DESPLEGABLES
	//------------------------------------------------------------------------------------------
	public List<RuralHouse> getListaRuralHouses() throws Exception {
		listaRuralHouses = facadeJSF.getRuralHouses(this.owner);
		return listaRuralHouses;
	}
	
	public List<Offer> getListaOffers() throws Exception {
		listaOffers = facadeJSF.getAllOffers(this.ruralHouse);
		return listaOffers;
	}
	//------------------------------------------------------------------------------------------
}
