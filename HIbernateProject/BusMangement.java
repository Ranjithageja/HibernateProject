package com.project.project;

	import java.util.Scanner;

import org.hibernate.annotations.DynamicUpdate;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	
	/* Here class name is taken as table name (Student) 
	 * because of the @Entity annotation.
	 */
    @Entity
	@DynamicUpdate
	public class BusMangement {
    	/* scanner object private to this class is created to accept userInput */
    	private static final Scanner scan=new Scanner(System.in);

		private String startingPoint;
		private String endingPoint;
		private String driverName;
		private Long driverNumber;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@Column(name="Bus_number",length=10,unique=true)
		private int  busId;
		public int  getBusId() {
			return busId;
		}

		/*public void setBusId(Integer busId) {
			this.busId = busId;
		}*/

		private String busNumber;
		private String busType;
		
		private static String userName="SRN";
		private static String Password="672030";
 
		public String getStartingpoint() {
			return startingPoint;
		}
	
		public String getStartingPoint() {
			return startingPoint;
		}
		public void setStartingPoint(String startingPoint) {
			this.startingPoint = startingPoint;
		}
		public String getEndingPoint() {
			return endingPoint;
		}
		public void setEndingPoint(String endingPoint) {
			this.endingPoint = endingPoint;
		}
		public String getDriverName() {
			return driverName;
		}
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public Long getDriverNumber() {
			return driverNumber;
		}
		
		public void setDriverNumber(Long driverNumber) {
			this.driverNumber = driverNumber;
		}
		
       public String getBusNumber() {
			return busNumber;
		}
		public void setBusNumber(String busNumber) {
			this.busNumber = busNumber;
		}
		public String getBusType() {
			return busType;
		}
		public void setBusType(String busType) {
			this.busType = busType;
		}
		
		/*
		 * Defining a login method using if condition to check username and password,
		 * entered by user is equal to the value initialized or not. Only when the
		 * conditions are true, the system gets logged in and display the menu. Else,
		 * the system fails to login
		 */
		public void toReadInput() {
			System.out.println("!!! Login First !!!");
			System.out.print("Enter username: ");
			String userName = scan.nextLine();
			System.out.print("Enter password: ");
			String password = scan.nextLine();
			/* calling the toLogin method */
			toLogin(userName, password);
		}
		public static void toLogin(String userName, String password) {
			if (userName.equals("SRN") && password.equals("672030")) { 
				System.out.println("successfully logged in");
				HibernateConfiguration.toCreateConnection(scan);
				
			}
			/* If the if-condition fails, then the else part is executed */
			else {
				System.out.println("Login Failed!!!");
			}
		}

		
		/* Defining logout() method for logging out the system */
		public static void toLogout() {
			System.out.println("Logged out!!! \nThank You! Visit Again!!!");
		}
	
                @Override
                public String toString() {
				return "BusMangement [startingPoint=" + startingPoint + ", endingPoint=" + endingPoint + ", driverName="
						+ driverName + ", driverNumber=" + driverNumber + ", busId=" + busId + ", busNumber="
						+ busNumber + ", busType=" + busType + "]";
			}

			
				
				
			}
	
	
		
		
		
		
		
		

	

	



