package org.sunil.addressbook.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({@NamedQuery(name = "Contact.listContactAllDetails", query = "select distinct c from Contact c left join fetch c.addresses t")})
public class Contact {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="system-uuid")	
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "uuid", unique = true)
	private String id;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String lastName;
	private String telephone;
	private String email;
	@OneToMany(mappedBy="contact", cascade=CascadeType.ALL)
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Collection<Address> addresses = new ArrayList<Address>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

}
