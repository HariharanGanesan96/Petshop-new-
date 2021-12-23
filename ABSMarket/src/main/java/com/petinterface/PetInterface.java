package com.petinterface;

import com.model.PetDetails;

public interface PetInterface {

	public void insert(PetDetails pet);
	
	public void updateStatus(int petId,String status,int adminId);
	
	public void delete(PetDetails pet);
	
	public void showAllpets();
	
	public PetDetails showPet(int petId);
	
	public void showNotApprovedPetList();
	
	public void showMypetdetails(int cusId);
	
	public void updatePetType(PetDetails pet);
	
	public void updatePetName(PetDetails pet);
	
	public void updatePetGender(PetDetails pet);
	
	public void updatePetDob(PetDetails pet);
	
	public void updatePetDescription(PetDetails pet);
	
	public void updatePetColor(PetDetails pet);
	
	public void updatePetQty(PetDetails pet);
	
	public void updatePetAviQty(PetDetails pet);
	
	public void updatePetPrice(PetDetails pet);
	
	public void updatePetImage(PetDetails pet);
	
	public void updateadmin(int adminId,int petId);
	
}
