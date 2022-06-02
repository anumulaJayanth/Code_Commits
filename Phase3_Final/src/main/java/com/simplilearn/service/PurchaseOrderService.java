package com.simplilearn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.PurchaseOrder;
import com.simplilearn.model.SportShoes;
import com.simplilearn.model.User;
import com.simplilearn.repo.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepo purchaseOrderRepo;

	@PostConstruct
	public void preAddedPurchaseOrders() {
		
		List<User> userlist = new ArrayList<User>();
		
		userlist.add(new User("user1", "password1", "fname1", "lname1", "address1", "email1"));
		userlist.add(new User("user2", "password2", "fname2", "lname2", "address2", "email2"));
		userlist.add(new User("user3", "password3", "fname3", "lname3", "address3", "email3"));
		userlist.add(new User("user4", "password4", "fname4", "lname4", "address4", "email4"));
		userlist.add(new User("user5", "password5", "fname2", "lname5", "address5", "email5"));
		userlist.add(new User("user6", "password6", "fname6", "lname6", "address6", "email6"));

		List<SportShoes> sportShoesList = new ArrayList<SportShoes>();
		List<SportShoes> shoeslist1 = new ArrayList<SportShoes>();		
		List<SportShoes> shoeslist2 = new ArrayList<SportShoes>();
		List<SportShoes> shoeslist3 = new ArrayList<SportShoes>();
		List<SportShoes> shoeslist4 = new ArrayList<SportShoes>();
		List<SportShoes> shoeslist5 = new ArrayList<SportShoes>();
		List<SportShoes> shoeslist6 = new ArrayList<SportShoes>();

		sportShoesList.add(new SportShoes("Leather","Male",6,"Grey",99.99));
		sportShoesList.add(new SportShoes("Formal","Female",6.5,"Yellow",89.99));
		sportShoesList.add(new SportShoes("Tennis","Female",9.5,"Orange",29.99));
		sportShoesList.add(new SportShoes("Soccer","Boy",6,"Grey",39.99));
		sportShoesList.add(new SportShoes("Leather","Male",9,"Pink",99.99));
		sportShoesList.add(new SportShoes("Sneakers","Female",10,"Purple",45.99));
		sportShoesList.add(new SportShoes("Leather","Boy",7,"Red",99.99));
		sportShoesList.add(new SportShoes("Sneakers","Boy",9,"Pink",45.99));
		sportShoesList.add(new SportShoes("Soccer","Girl",5,"White",39.99));
		sportShoesList.add(new SportShoes("Casual","Male",6,"Grey",69.99));
		sportShoesList.add(new SportShoes("Formal","Girl",8.5,"Brown",89.99));
		sportShoesList.add(new SportShoes("Casual","Female",5,"White",69.99));
		sportShoesList.add(new SportShoes("Running","Girl",9,"Pink",35.99));
		sportShoesList.add(new SportShoes("Sneakers","Male",5.5,"Black",45.99));
		sportShoesList.add(new SportShoes("Football","Female",7.5,"Blue",59.99));
		sportShoesList.add(new SportShoes("Basketball","Female",6,"Grey",49.99));
		sportShoesList.add(new SportShoes("Basketball","Girl",9.5,"Orange",49.99));
		sportShoesList.add(new SportShoes("Sneakers","Girl",6.5,"Yellow",45.99));
		sportShoesList.add(new SportShoes("Running","Male",8,"Green",35.99));
		sportShoesList.add(new SportShoes("Football","Male",10,"Purple",59.99));
		sportShoesList.add(new SportShoes("Tennis","Male",5,"White",29.99));
		sportShoesList.add(new SportShoes("Tennis","Boy",8.5,"Brown",29.99));
		sportShoesList.add(new SportShoes("Running","Female",5.5,"Black",35.99));
		sportShoesList.add(new SportShoes("Running","Boy",10,"Purple",35.99));
		sportShoesList.add(new SportShoes("Football","Boy",6.5,"Yellow",59.99));
		sportShoesList.add(new SportShoes("Football","Girl",5.5,"Black",59.99));
		sportShoesList.add(new SportShoes("Leather","Female",8,"Green",99.99));
		sportShoesList.add(new SportShoes("Formal","Male",7.5,"Blue",89.99));
		sportShoesList.add(new SportShoes("Formal","Boy",5.5,"Black",89.99));
		sportShoesList.add(new SportShoes("Soccer","Female",8.5,"Brown",39.99));
		sportShoesList.add(new SportShoes("Tennis","Girl",7.5,"Blue",29.99));
		sportShoesList.add(new SportShoes("Casual","Boy",8,"Green",69.99));
		sportShoesList.add(new SportShoes("Casual","Girl",7,"Red",69.99));
		sportShoesList.add(new SportShoes("Basketball","Male",7,"Red",49.99));
		sportShoesList.add(new SportShoes("Basketball","Boy",5,"White",49.99));
		sportShoesList.add(new SportShoes("Soccer","Male",9.5,"Orange",39.99));
		
		Date date1 = new GregorianCalendar(2021, 01, 31).getTime();
		Date date2 = new GregorianCalendar(2020, 12, 15).getTime();
		Date date3 = new GregorianCalendar(2021, 04, 01).getTime();
		Date date4 = new GregorianCalendar(2021, 01, 31).getTime();
//		Date date5 = new GregorianCalendar(2020, 11, 14).getTime();
//		Date date6 = new GregorianCalendar(2021, 04, 01).getTime();

		double bill = 0.0;
		for (int i = 0; i < 5; i++)
		{
			shoeslist1.add(sportShoesList.get(i));
			bill += sportShoesList.get(i).getPrice();
		}
			
		PurchaseOrder purchaseOrder1 = new PurchaseOrder(userlist.get(0), shoeslist1, date1, bill*1.10);

		userlist.get(0).getPurchaseOrders().add(purchaseOrder1);
		for (int i = 0; i < 5; i++)
		{
			sportShoesList.get(i).getPurchaseOrder().add(purchaseOrder1);
		}
		
		bill = 0.0;
		for (int i = 4; i < 16; i++)
		{
			shoeslist2.add(sportShoesList.get(i));
			bill += sportShoesList.get(i).getPrice();
		}
		
		PurchaseOrder purchaseOrder2 = new PurchaseOrder(userlist.get(1), shoeslist2, date2, bill*1.10);

		userlist.get(1).getPurchaseOrders().add(purchaseOrder2);
		for (int i = 4; i < 16; i++)
		{
			sportShoesList.get(i).getPurchaseOrder().add(purchaseOrder2);
		}
		
		bill = 0.0;
		for (int i = 13; i < 29; i++)
		{
			shoeslist3.add(sportShoesList.get(i));
			bill += sportShoesList.get(i).getPrice();
		}
		
		PurchaseOrder purchaseOrder3 = new PurchaseOrder(userlist.get(2), shoeslist3, date3, bill*1.10);
		
		userlist.get(2).getPurchaseOrders().add(purchaseOrder3);
		for (int i = 13; i < 29; i++)
		{
			sportShoesList.get(i).getPurchaseOrder().add(purchaseOrder3);
		}
		
		PurchaseOrder purchaseOrder4 = new PurchaseOrder(userlist.get(1), shoeslist1, date3, bill*1.10);
		
		userlist.get(1).getPurchaseOrders().add(purchaseOrder4);
		for (SportShoes shoes:shoeslist1)
		{
			shoes.getPurchaseOrder().add(purchaseOrder4);
		}
		
		//------
		bill = 0.0;
		for (int i = 0; i < 6; i++)
		{
			int index = (int)(Math.random() * sportShoesList.size());
			shoeslist4.add(sportShoesList.get(index));
			bill += sportShoesList.get(index).getPrice();
		}
			
		PurchaseOrder purchaseOrder5 = new PurchaseOrder(userlist.get(4), shoeslist4, date4, bill*1.10);

		userlist.get(4).getPurchaseOrders().add(purchaseOrder5);
		for (int i = 0; i < 6; i++)
		{
			purchaseOrder5.getShoes().get(i).getPurchaseOrder().add(purchaseOrder5);
		}
		
		//------
		bill = 0.0;
		for (int i = 0; i < 8; i++)
		{
			int index = (int)(Math.random() * sportShoesList.size());
			shoeslist5.add(sportShoesList.get(index));
			bill += sportShoesList.get(index).getPrice();
		}
			
		PurchaseOrder purchaseOrder6 = new PurchaseOrder(userlist.get(5), shoeslist5, date2, bill*1.10);

		userlist.get(5).getPurchaseOrders().add(purchaseOrder6);
		for (int i = 0; i < 8; i++)
		{
			purchaseOrder6.getShoes().get(i).getPurchaseOrder().add(purchaseOrder6);
		}
		
		//------
		bill = 0.0;
		for (int i = 0; i < 11; i++)
		{
			int index = (int)(Math.random() * sportShoesList.size());
			shoeslist6.add(sportShoesList.get(index));
			bill += sportShoesList.get(index).getPrice();
		}
		
		PurchaseOrder purchaseOrder7 = new PurchaseOrder(userlist.get(4), shoeslist5, date2, bill*1.10);
		
		userlist.get(4).getPurchaseOrders().add(purchaseOrder7);
		for (int i = 0; i < 8; i++)
		{
			purchaseOrder7.getShoes().get(i).getPurchaseOrder().add(purchaseOrder7);
		}
		
		//-----
		
		purchaseOrderRepo.save(purchaseOrder1);
		purchaseOrderRepo.save(purchaseOrder2);
		purchaseOrderRepo.save(purchaseOrder3);
		purchaseOrderRepo.save(purchaseOrder4);
		purchaseOrderRepo.save(purchaseOrder5);
		purchaseOrderRepo.save(purchaseOrder6);
		purchaseOrderRepo.save(purchaseOrder7);
	}

	public List<PurchaseOrder> retrievePurchaseOrder() {

		List<PurchaseOrder> purchaseOrders = (List<PurchaseOrder>) purchaseOrderRepo.findAll();
		System.out.println(purchaseOrders);
		return purchaseOrders;
	}

	public PurchaseOrder retrievePurchaseOrder(int id) {

		Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepo.findById(id);

		if (purchaseOrder.isPresent()) {
			return purchaseOrder.get();
		}

		return null;
	}
	
    public List<PurchaseOrder> searchPurchaseOrdersByDate(String date) {
    	
    	List<PurchaseOrder> allPurchaseOrders = (List<PurchaseOrder>) purchaseOrderRepo.findAll();

    	if (date == null) {
    	   return allPurchaseOrders;
       }

    	List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
       
       	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       	Date searchDate = null;
		try {
			searchDate = dateFormat.parse(date);
		} catch (ParseException e) {
    	   return allPurchaseOrders;
		}
       for(PurchaseOrder po: allPurchaseOrders)
       {    	   
    	   if(po.getPurchaseDate().compareTo(searchDate) == 0) {
    		   purchaseOrders.add(po);
    	   }
       }
       
       return purchaseOrders;
    }
    
    public List<PurchaseOrder> searchPurchaseOrdersByShoeType(String shoetype) {
    	
    	List<PurchaseOrder> allPurchaseOrders = (List<PurchaseOrder>) purchaseOrderRepo.findAll();

    	if (shoetype == null) {
    		return allPurchaseOrders;
    	}
    	List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
    	
    	for(PurchaseOrder po: allPurchaseOrders)
    	{
    		List<SportShoes> shoes = po.getShoes();
    		System.out.println(shoes);
    		
    		for (SportShoes s: shoes) {
    			
    			System.out.println(s);
    			System.out.println(shoes);
    			if(s.getShoetype().equals(shoetype)) {
    				if (!purchaseOrders.contains(po)) {
    					purchaseOrders.add(po);
    				}
    			}
    		}
    	}
    	return purchaseOrders;
    }

    public void addPurchaseOrder(User user, List<SportShoes>shoes, Date dateOfPurchase, double billedAmount) {
    	
    	purchaseOrderRepo.save(new PurchaseOrder(user, shoes, dateOfPurchase, billedAmount));
    }

}