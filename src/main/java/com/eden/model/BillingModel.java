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
 * The Class BillingDAO.
 */
@Getter
@Setter
@Entity
@Table(name = "billing")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingModel {

	/** The billing ID. */
	@Id
	@Column(name = "billing_id", nullable = false)
	private int billingID;

	/** The billing addressline 1. */
	@Column(name = "billing_addressline1", nullable = false)
	private String billingAddressline1;

	/** The billing addressline 2. */
	@Column(name = "billing_addressline2", nullable = false)
	private String billingAddressline2;

	/** The billing city. */
	@Column(name = "billing_city", nullable = false)
	private String billingCity;

	/** The billing state. */
	@Column(name = "billing_state", nullable = false)
	private String billingState;

	/** The billing zip. */
	@Column(name = "billing_zip", nullable = false)
	private String billingZip;

}
