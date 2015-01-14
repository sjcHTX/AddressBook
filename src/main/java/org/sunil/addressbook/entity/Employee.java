package org.sunil.addressbook.entity;

import javax.persistence.Entity;

@Entity
public class Employee extends Contact {
	String workTitle;

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}

}
