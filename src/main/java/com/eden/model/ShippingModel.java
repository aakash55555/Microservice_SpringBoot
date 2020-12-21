package com.eden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ShippingDAO.
 */
@Getter
@Setter
@Entity
@Table(name = "shipping")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingModel {

	@Id
	@Column(name = "shipping_id", nullable = false)
	private int shippingID;

	@Column(name = "shipping_addressline1", nullable = false)
	private String shippingAddressline1;

	@Column(name = "shipping_addressline2", nullable = false)
	private String shippingAddressline2;

	@Column(name = "shipping_city", nullable = false)
	private String shippingCity;

	@Column(name = "shipping_state", nullable = false)
	private String shippingState;

	@Column(name = "shipping_zip", nullable = false)
	private String shippingZip;

	@Column(name = "shipping_method", nullable = false)
	private String shippingMethod;
}
