package org.sunil.addressbook.entity;

import javax.persistence.Entity;

@Entity
public class ResidenceAddress extends Address {
	String residenceType;

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
}
