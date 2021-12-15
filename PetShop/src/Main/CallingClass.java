package Main;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import Class.Animalorders;
import Class.Animals;
import Class.AnimalsCustomers;
import Class.AnimalsOrderItems;
import Dao.AnimalCustomerDao;
import Dao.AnimalOrderItemsDao;
import Dao.AnimalOrdersDao;
import Dao.AnimalsDao;

public class CallingClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
      
        System.out.println("enter the values");
        String data=scan.nextLine();
        String [] splitdata=data.split(",");
//        AnimalsCustomers acobj=new AnimalsCustomers(Integer.parseInt(splitdata[0]),splitdata[1],splitdata[2],splitdata[3]
//        		,splitdata[4],splitdata[5],Long.parseLong(splitdata[6]),Long.parseLong(splitdata[7]),splitdata[8]);
//        AnimalCustomerDao obj=new AnimalCustomerDao();
       
//        Animals acobj=new Animals(Integer.parseInt(splitdata[0]),splitdata[1],
//        		splitdata[2],splitdata[3],splitdata[4],splitdata[5],splitdata[6],
//        		Double.parseDouble(splitdata[7]),Integer.parseInt(splitdata[8]));
//        System.out.println(acobj);
//        AnimalsDao obj=new AnimalsDao();
        
//        Animalorders oobj=new Animalorders(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),
//        		splitdata[2],Double.parseDouble(splitdata[3]));
////        AnimalOrdersDao obj=new AnimalOrdersDao();
//        
        AnimalsOrderItems oobj = new AnimalsOrderItems(Integer.parseInt(splitdata[0]),Integer.parseInt(splitdata[1]),Integer.parseInt(splitdata[2]),
        		Integer.parseInt(splitdata[3]),Double.parseDouble(splitdata[4]),Double.parseDouble(splitdata[5]));
//        
        try {
        	
        	AnimalOrderItemsDao obj=new AnimalOrderItemsDao();
        	obj.insertAnimalsorderitemsDao(oobj);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           		
	}

}
