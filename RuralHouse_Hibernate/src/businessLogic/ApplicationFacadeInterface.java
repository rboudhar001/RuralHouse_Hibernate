package businessLogic;

import java.rmi.*;
import java.util.List;
import java.util.Vector;
import java.util.Date;

import domain.Book;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;


import exceptions.OfferCanNotBeBooked; 


public interface ApplicationFacadeInterface {

	/**
	 * This method obtains owner rural houses
	 * 
	 * @param owner object
	 *            
	 * @return a list of Rural Houses
	 */
	public List<RuralHouse> getRuralHouses(Owner own);


	/**
	 * This method creates an offer with a house number, first day, last day and price
	 * 
	 * @param House
	 *            number, start day, last day and price
	 * @return None
	 */
	public Offer createOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay, float price);
	
	
	/**
	 * This method creates a book with a corresponding parameters
	 * 
	 * @param First
	 *            day, last day, house number and telephone
	 * @return a book
	 */
	public Book createBook(RuralHouse rh, Date firstDate, Date lastDate, String bookTelephoneNumber);

	
	/**
	 * This method obtains available offers for a concrete house in a certain period 
	 * 
	 * @param houseNumber, the house number where the offers must be obtained 
	 * @param firstDay, first day in a period range 
	 * @param lastDay, last day in a period range
	 * @return a vector of offers(Offer class)  available  in this period
	 */
	public List<Offer> getOffersNotBook(RuralHouse rh, Date firstDay, Date lastDay);
	
	
	/**
	 * This method existing  owners 
	 * 
	 */
	public List<Owner> getOwners();
	
	/**
	 * This method existing  owners 
	 * 
	 */
	public List<RuralHouse> getAllRuralHouses();
	
	//AÑADIDA
	public Owner addOwner(Owner own);
	
	//AÑADIDA
	public Owner removeOwner(Owner own);
	
	//AÑADIDA
	public RuralHouse addRuralHouse(RuralHouse rh);
	
	//AÑADIDA
	public RuralHouse removeRuralHouse(RuralHouse rh);
	
	//AÑADIDA
	public boolean thisOfferHaveBook(Offer offer);
	
	//AÑADIDA
	public Offer removeOffer(Offer offer);
	
	//AÑADIDA
	public List<Offer> getAllOffers(RuralHouse rh);
	
	//AÑADIDA
	public Book createBook(Offer offer, int phone);
}