package Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.ABSClass.Customers;
import com.ABSClass.PetDetails;
import com.Dao.AnimalsDao;

public class petMain {
	
	public void petDetils(Customers customer) throws ClassNotFoundException, SQLException, ParseException {
		Scanner scan=new Scanner(System.in);
		AnimalsDao animalDao =new AnimalsDao();
		System.out.println("select your options");
		System.out.println("1.Register new pet\n2.update my pet detilas3.order item");
		int PetOperation=Integer.parseInt(scan.nextLine());
		
		switch(PetOperation) {
		// animal register
		case 1:		
			// pet type
			String petType;
			while (true) {
				System.out.println("enter the pet type");
				petType = scan.nextLine();
				if (petType.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (petType.length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}
			}

			// pet name
			String petName;
			while (true) {
				System.out.println("enter the pet name");
				petName = scan.nextLine();
				if (petName.matches("[a-zA-Z ]{3,20}")) {
					break;
				}
				if (petName.length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}

			}
			
			// pet gender
			String petGender;
			while (true) {
				System.out.println("male or female");
				petGender = scan.nextLine().toLowerCase();
				if (petGender.equals("male") || petGender.equals("female")) {
					break;
				}
				System.out.println("invalid input");
			}
			// pet Dob
			String petDob;
			SimpleDateFormat dateFormet=new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("enter the Pet dob dd-mm-yyyy");
			petDob=scan.nextLine();
			Date date=dateFormet.parse(petDob);
           
			// input Description
            String Description;
           		while (true) {
				System.out.println("enter the Description");
				Description = scan.nextLine();
 					if(Description.length() <= 30) {
					System.out.println("minmum 30 character");
				}
           									
			//color
 				String petColor;							
				while(true) {
				
				System.out.println("enter the color");
				petColor=scan.nextLine();
				if(petColor.matches("[a-zA-z]+")) {
					break;
				}
				else {
					System.out.println("invalid color name");
				}
			}
			
			// pet Qty
			String petQty;
		
				System.out.println("enter the quantity");
				petQty=scan.nextLine();
			//pet price
				
			String petPrice;
			System.out.println("enter the pet price");
			petPrice=scan.nextLine();
				
			//pet Image
			String petImage;
			System.out.println("enter link address of image");
			petImage=scan.nextLine();
			
			
			PetDetails pet=new PetDetails(petType,petName,petGender,date,
					Integer.parseInt(petQty),Description,petColor,Double.parseDouble(petPrice),
					petImage,customer.getCustomerId());
			
			animalDao.insert(pet);
           		
            break;
           		}
            case 2:
            	List<PetDetails> petList= new ArrayList<PetDetails>();
            	petList=animalDao.showMypetdetails(customer.getCustomerId());
            	for (PetDetails i : petList) {
    				System.out.println(i);
    			}
            	PetDetails pet=new PetDetails();
            	System.out.println("enter pet id value need to update");
            	int update=Integer.parseInt(scan.nextLine()); 	
            	pet.setCustomerId(update);
            	System.out.println("enter the update operation");
            	System.out.println("1.Update pettype\n" + "2.update PetName\n" + "3.update petGender\n"
						+ "4.update Dob\n" + "5.update qty\n" + "6.update price\n"
						+ "7.update description\n" + "8.update color\n" + "9.update image\n10.delete");
        
            	int updateOperation=Integer.parseInt(scan.nextLine());
            	
            	switch(updateOperation) {
            	
            	// update pet type
            	case 1:
            		while(true) {
            		System.out.println("enter the pet type");
            		petType=scan.nextLine();
            		if (petType.matches("[a-zA-Z]{3,20}")) {
    					break;
    				}
    				if (petType.length() <= 2) {
    					System.out.println("Must have minimum 3 character");
    				} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
    					System.out.println("Alphabet only");
    				}
                 		}
            		pet.setPetType(petType);
            		animalDao.updatePetType(pet);
            		break;
            	// update petName
            	case 2:
            		while(true) {
                		System.out.println("enter the pet Name");
                		petName=scan.nextLine();
                		if (petName.matches("[a-zA-Z]{3,20}")) {
        					break;
        				}
        				if (petName.length() <= 2) {
        					System.out.println("Must have minimum 3 character");
        				} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
        					System.out.println("Alphabet only");
        				}
                     		}
                		pet.setPetName(petName);
                		animalDao.updatePetName(pet);
            		break;
            	// update Pet Gender
            	case 3:
            		while(true) {
                		System.out.println("enter the pet type");
                		petGender=scan.nextLine();
                		if (petGender.matches("[a-zA-Z]{3,20}")) {
        					break;
        				}
        				if (petGender.length() <= 2) {
        					System.out.println("Must have minimum 3 character");
        				} else if (petGender.matches(".*\\W.*") || petGender.matches(".*\\d.*")) {
        					System.out.println("Alphabet only");
        				}
                     		}
                		pet.setPetGender(petGender);
                		animalDao.updatePetGender(pet);
            		break;
            	// update pet DOB
            	case 4:
            		
        			dateFormet=new SimpleDateFormat("dd-mm-yyyy");
        			System.out.println("enter the Pet dob dd-mm-yyyy");
        			petDob=scan.nextLine();
        			date=dateFormet.parse(petDob);
        			pet.setPetDob(date);
            		animalDao.updatePetDob(pet);

            		break;
            	// pet qty
            	case 5:
            		System.out.println("enter the quantity");
    				 int petQty=Integer.parseInt(scan.nextLine());
    				 pet.setPetQty(petQty);
    				 animalDao.updatePetQty(pet);
            		break;
            		
            	case 6:
            		System.out.println("enter the pet price");
        		    double petPrice=Double.parseDouble(scan.nextLine());
        		    pet.setPetprice(petPrice);
   				    animalDao.updatePetPrice(pet);
            		break;
            	// update description
            	case 7:
            		while (true) {
    				System.out.println("enter the Description");
    				Description = scan.nextLine();
     					if(Description.length() <= 30) {
    					System.out.println("minmum 30 character");
     					}
    					else {
    						break;
    					}
    				
            		}
            		pet.setDescription(Description);
   				    animalDao.updatePetDescription(pet);
            		break;
            	// update color
            		
            	case 8:
            		String petColor;
            		while(true) {
        				System.out.println("enter the color");
        				petColor=scan.nextLine();
        				if(petColor.matches("[a-zA-z]+")) {
        					break;
        				}
        				else {
        					System.out.println("invalid color name");
        				}
        			}
            		pet.setPetColor(petColor);
   				    animalDao.updatePetColor(pet);
            		break;
            		
            	// update Image
            	case 9:
            		System.out.println("enter link address of image");
        			String petImage=scan.nextLine();
        			 pet.setPetImage(petImage);
    				 animalDao.updatePetPrice(pet);
            		break;
            	// delete pet
            	case 10:
            		System.out.println("enter pet id need to delete");
            		 animalDao.delete(pet); 	
            	}                            	
            	break;
            case 3:
            	petList= new ArrayList<PetDetails>();
            	petList=animalDao.showAllpets();
            	for (PetDetails i : petList) {
    				System.out.println(i);
    			}
            	break;
            	
            
		}
		
	
		}

}
