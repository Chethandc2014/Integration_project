package com.cluster.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address_type database table.
 * 
 */
@Entity
@Table(name="address_type")
@NamedQuery(name="AddressType.findAll", query="SELECT a FROM AddressType a")
public class AddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADDRESS_TYPE_ID")
	private int addressTypeId;

	@Column(name="ADDRESS_TYPE")
	private int addressType;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="addressType")
	private List<Address> addresses;

	public AddressType() {
	}

	public int getAddressTypeId() {
		return this.addressTypeId;
	}

	public void setAddressTypeId(int addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public int getAddressType() {
		return this.addressType;
	}

	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAddressType(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAddressType(null);

		return address;
	}

}