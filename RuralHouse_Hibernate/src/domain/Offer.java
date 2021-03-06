package domain;

import java.io.*;
import java.util.Date;

import modelo.HibernateUtil;

import org.hibernate.Session;

import com.db4o.ObjectContainer;

import bean.FacadeSingleton;
import businessLogic.ApplicationFacadeInterface;

@SuppressWarnings("serial")
public class Offer implements Serializable {
	
	private int offerNumber;
	private Date firstDay;
	private Date lastDay;
	private float price;
	private RuralHouse ruralHouse;
	private Book book = null;
	
	//IS2 - JSF
	private String toString;
	
	public Offer() {
	}
	
	//CONSTRUCTOR
	public Offer(RuralHouse ruralHouse, Date firstDay, Date lastDay, float price){
		  this.firstDay = firstDay;
		  this.lastDay = lastDay;
		  this.price = price;
		  this.ruralHouse = ruralHouse;
	}
	/**
	 * Get the house number of the offer
	 * 
	 * @return the house number
	 */
	public RuralHouse getRuralHouse() {
		return this.ruralHouse;
	}

	/**
	 * Set the house number to a offer
	 * 
	 * @param house number
	 */
	public void setRuralHouse(RuralHouse ruralHouse) {
		this.ruralHouse = ruralHouse;
	}

	/**
	 * Get the offer number
	 * 
	 * @return offer number
	 */
	public int getOfferNumber() {
		return this.offerNumber;
	}

	/**
	 * Get the first day of the offer
	 * 
	 * @return the first day
	 */
	public Date getFirstDay() {
		return this.firstDay;
	}

	/**
	 * Set the first day of the offer
	 * 
	 * @param firstDay
	 *            The first day
	 */
	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	/**
	 * Get the last day of the offer
	 * 
	 * @return the last day
	 */
	public Date getLastDay() {
		return this.lastDay;
	}

	/**
	 * Set the last day of the offer
	 * 
	 * @param lastDay
	 *            The last day
	 */
	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	/**
	 * Get the price
	 * 
	 * @return price
	 */
	public float getPrice() {
		return this.price;
	}

	/**
	 * Set the price
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Get the book number
	 * 
	 * @return book object
	 */
	public Book getBook() {
		return this.book;
	}

	/**
	 * Set the book object
	 * 
	 * @param book
	 *            Book object
	 * @return None
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	
	/**
	 * This method creates a book with a corresponding parameters
	 * 
	 * @param First
	 *            day, last day, house number and telephone
	 * @return a book
	 */
	public Book createBook(java.sql.Date firstDate, java.sql.Date lastDate,String bookTelephoneNumber) {

		//ObjectContainer db = DB4oManager.getContainer();
		
		Book book = null;
		Book b = new Book(bookTelephoneNumber, this);
		
		//db.store(this);
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(b);
			session.getTransaction().commit();
			
			book = b;
		}
		catch (Exception e) {
			System.out.println("ERROR: FacadeImplementation:addOwner : No se pudo a�adir al Owner: " + e.toString());
		}
		
		return book;
	}
	
	//A�ADIDO
	public String getToString() {
		
		System.out.println("Seguir : 4");
		
		toString = "" + this.firstDay + " - " + this.lastDay + ", " + this.getPrice() + " �";
		return toString;
	}
	
	public String toString() {
	     return "" + this.firstDay + " - " + this.lastDay + ", " + this.getPrice() + " �";
	}
	
	//A�ADIDO
	public void setOfferNumber(int offerNumber) {
		this.offerNumber = offerNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (offerNumber != other.offerNumber)
			return false;
		return true;
	}
	
	/*
	@Override
	public boolean equals(Object other) {
		
	    return (other instanceof Offer)
	        ? (offerNumber == ((Offer) other).offerNumber)
	        : (other == this);
	}
	*/
}