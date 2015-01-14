package org.sunil.addressbook.entity;

import javax.persistence.Entity;

@Entity
public class BusinessAddress extends Address {
	String nameOfBusiness;

	public String getNameOfBusiness() {
		return nameOfBusiness;
	}

	public void setNameOfBusiness(String nameOfBusiness) {
		this.nameOfBusiness = nameOfBusiness;
	}
}
