package com.sheet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "METAL_DETAIL", catalog = "matel_sheet_db_v1")
public class MetalDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "metal_id", unique = true, nullable = false)
	private Integer metalDetailId;
	@Column(name = "QTY", nullable = false)
	private Double qty;
	@Column(name = "GAZE", nullable = false)
	private String gaze;
	@Column(name = "RATE", nullable = true)
	private Double rate;
	@Column(name = "SHEET_SIZE", nullable = false)
	private String sheetSize;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	@JsonBackReference
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getMetalDetailId() {
		return metalDetailId;
	}

	public void setMetalDetailId(Integer metalDetailId) {
		this.metalDetailId = metalDetailId;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getSheetSize() {
		return sheetSize;
	}

	public void setSheetSize(String sheetSize) {
		this.sheetSize = sheetSize;
	}

	public String getGaze() {
		return gaze;
	}

	public void setGaze(String gaze) {
		this.gaze = gaze;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gaze == null) ? 0 : gaze.hashCode());
		result = prime * result + ((metalDetailId == null) ? 0 : metalDetailId.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((sheetSize == null) ? 0 : sheetSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetalDetail other = (MetalDetail) obj;
		if (gaze == null) {
			if (other.gaze != null)
				return false;
		} else if (!gaze.equals(other.gaze))
			return false;
		if (metalDetailId == null) {
			if (other.metalDetailId != null)
				return false;
		} else if (!metalDetailId.equals(other.metalDetailId))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (sheetSize == null) {
			if (other.sheetSize != null)
				return false;
		} else if (!sheetSize.equals(other.sheetSize))
			return false;
		return true;
	}

}
