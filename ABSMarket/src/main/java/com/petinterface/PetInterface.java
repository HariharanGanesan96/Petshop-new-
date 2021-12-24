package com.petinterface;

import com.model.PetDetails;

public interface PetInterface {

	public void insert(PetDetails pet);
	
	public void update(PetDetails pet);
	
	public void updateStatus(int petId,String status,int adminId);
	
	public void delete(PetDetails pet);
	
	public void showAllpets();
	
	public PetDetails showPet(int petId);
	
	public void showNotApprovedPetList();
	
	public void showMypetdetails(int cusId);
	
	public void updatePetAviQty(PetDetails pet);
	
}
