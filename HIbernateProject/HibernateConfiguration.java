package com.project.project;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	private static Scanner scan=new Scanner(System.in);
	private static BusMangement bus = new BusMangement();
    public static void toCreateConnection(Scanner scan) {
    
    try {
    			Configuration config = new Configuration().configure().addAnnotatedClass(BusMangement.class);//<hibernate-configuration> </hibernate-configuration>
    			SessionFactory sessionFact = config.buildSessionFactory(); //<sessionFactory> </sessionFactory>
    			Session session = sessionFact.openSession();
    			toManipulateData(sessionFact,session);
                 }
        		catch(HibernateException obj) {

        		}
        		catch(Exception obj) {

        		}
        	}

    		public static void toManipulateData(SessionFactory sessionFact,Session session)	{
    			System.out.println(" choose the option 1.create the BusManagement, 2.Display the BusManagement,3.update the BusManagement,4..Delete the BusManagement,5.LogOut");
                byte userInput;
    		         do {
    				userInput=scan.nextByte();
    				switch (userInput) {
    					case 1:
    						createBusManagement(session);
    		    			break;
    					case 2:
    		    			displayByBusId(session);
    		    			break;
    					case 3:
    		    			updateByBusId(session);
                           break;
    					
    		    	     case 4:
    						deleteByBusId(session);
    						break;
    					case 5:
    						BusMangement.toLogout();
    						session.close();
    						break;
    					case 6:
    						session.close();
    						break;
    			}
    			}
    			
    		while(userInput!=6) ;
    				
    			}
    		public static void main (String args[]) {
    			System.out.println(" Enter the userName");
    			String userName=scan.next();
    			System.out.println("Enter the password");
    			String password=scan.next();
    			BusMangement.toLogin(userName,password);
    		}

            private static void createBusManagement(Session session) {
    		session.beginTransaction();
    		session.save(getBusManagement());
    		int busId= bus.getBusId();
    		System.out.println("Bus Information is inserted  :"+busId);
    		session.getTransaction().commit();
    	}
    	private static void deleteByBusId(Session session) {
    		System.out.println("Enter the busId");
    		int busId=scan.nextInt();
    		BusMangement bus = session.get(BusMangement.class,busId);
             if(bus != null) {
    			session.beginTransaction();
    			session.remove(bus);
    			session.getTransaction().commit();
    		}
    		else {
    			System.out.println("BusId  doesnt exists..");

    		}	
    	}
    	private static void updateByBusId(Session session) {
    		System.out.println("Enter the busId");
    		int busId=scan.nextInt();
             BusMangement bus = session.get(BusMangement.class, busId);
    		if(bus != null) {
    			System.out.println("Enter the DriverName ");
    			bus.setDriverName(scan.next());
    			System.out.println("Enter the BusType ");
    			bus.setBusType(scan.next());
                session.beginTransaction();
    			session.persist(bus);
    			session.getTransaction().commit();
    		}
    		else {
    			System.out.println("BusId doesnt exists..");

    		}	
    	}
    	private static void displayByBusId(Session session){
    		System.out.println("Enter the BusId");
    		int busId=scan.nextInt();
    		BusMangement bus = session.get(BusMangement.class,busId);
    		if(bus != null) {
    			System.out.println(bus);
    		}
    		else {
    			System.out.println("BusId doesnt exists..");

    		}
    	}
    	private static BusMangement getBusManagement() {
    		BusMangement bus = new BusMangement();
    		System.out.println("Enter the StartingPoint ");
    		bus.setEndingPoint(scan.next());
    		System.out.println("Enter the EndingPoint ");
    		bus.setEndingPoint(scan.next());
    		System.out.println("Enter the DriverName ");
    		bus.setDriverName(scan.next());
    		System.out.println("Enter the DriverNo ");
    		bus.setDriverNumber( scan.nextLong());
    		System.out.println("Enter the BusNo ");
    		bus.setBusNumber(scan.next());
    		System.out.println("Enter the BusType ");
    		bus.setBusType(scan.next());
    		return bus;
    	}
    }

    




