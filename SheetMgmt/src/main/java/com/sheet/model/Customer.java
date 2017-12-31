package com.sheet.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer", catalog = "matel_sheet_db_v1")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
	private Integer customerId;
	private String customerName;
	private String mobileNumber;
	private String advancePayment;

	// @JsonFormat
	// (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm a")
	private Timestamp purchaseDateTime;
	private String purchaseDateTimeSTR;
	private List<MetalDetail> metalDetails = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = MetalDetail.class, fetch = FetchType.LAZY)
	@JsonManagedReference
	public List<MetalDetail> getMetalDetails() {
		return metalDetails;
	}

	public void setMetalDetails(List<MetalDetail> metalDetails) {
		this.metalDetails = metalDetails;
	}

	@Column(name = "customer_name", unique = true, nullable = false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "mobile_number", unique = false, nullable = false)
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "advance_payment", unique = false, nullable = false)
	public String getAdvancePayment() {
		return advancePayment;
	}

	public void setAdvancePayment(String advancePayment) {
		this.advancePayment = advancePayment;
	}

	@Column(name = "purchase_datetime", unique = false, nullable = false)
	public Timestamp getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(Timestamp purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
		setPurchaseDateTimeSTR(formatter.format(this.purchaseDateTime));
	}

	public String getPurchaseDateTimeSTR() {
		return purchaseDateTimeSTR;
	}

	public void setPurchaseDateTimeSTR(String purchaseDateTimeSTR) {
		this.purchaseDateTimeSTR = purchaseDateTimeSTR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advancePayment == null) ? 0 : advancePayment.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((metalDetails == null) ? 0 : metalDetails.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((purchaseDateTime == null) ? 0 : purchaseDateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (advancePayment == null) {
			if (other.advancePayment != null)
				return false;
		} else if (!advancePayment.equals(other.advancePayment))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (metalDetails == null) {
			if (other.metalDetails != null)
				return false;
		} else if (!metalDetails.equals(other.metalDetails))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (purchaseDateTime == null) {
			if (other.purchaseDateTime != null)
				return false;
		} else if (!purchaseDateTime.equals(other.purchaseDateTime))
			return false;
		return true;
	}

}
