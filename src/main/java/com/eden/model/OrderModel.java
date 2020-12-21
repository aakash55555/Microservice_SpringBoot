package com.eden.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.eden.domainvalue.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderModel.
 */
/* 
	 * @see java.lang.Object#hashCode()
	 */

/**
 * Gets the modified date.
 *
 * @return the modified date
 */

/**
 * Gets the modified date.
 *
 * @return the modified date
 */
@Getter

/**
 * Sets the modified date.
 *
 * @param modifiedDate
 *            the new modified date
 */

/**
 * Sets the modified date.
 *
 * @param modifiedDate the new modified date
 */
@Setter

/**
 * Instantiates a new order model.
 *
 * @param orderID
 *            the order ID
 * @param orderStatus
 *            the order status
 * @param customerID
 *            the customer ID
 * @param itemDAO
 *            the item DAO
 * @param paymentDAO
 *            the payment DAO
 * @param shippingDAO
 *            the shipping DAO
 * @param billingDAO
 *            the billing DAO
 * @param orderDate
 *            the order date
 * @param modifiedDate
 *            the modified date
 */

/**
 * Instantiates a new order model.
 *
 * @param orderID the order ID
 * @param orderStatus the order status
 * @param customerID the customer ID
 * @param itemDAO the item DAO
 * @param paymentDAO the payment DAO
 * @param shippingDAO the shipping DAO
 * @param billingDAO the billing DAO
 * @param orderDate the order date
 * @param modifiedDate the modified date
 */
@AllArgsConstructor

/**
 * Instantiates a new order model.
 */

/**
 * Instantiates a new order model.
 */
@NoArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
@Entity
@Table(name = "orders")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order ID. */
	@Id
	@Column(name = "order_id", nullable = false)
	private int orderID;

	/** The order status. */
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	private OrderStatus orderStatus;

	/** The customer ID. */
	@Column(name = "customer_id", nullable = false)
	private Integer customerID;

	/** The item Model. */
	@JoinColumn(name = "item_id")
	@OneToOne(cascade = CascadeType.ALL)
	private ItemModel itemDAO;

	/** The payment Model. */
	@JoinColumn(name = "payment_id")
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentModel paymentDAO;

	/** The shipping Model. */
	@JoinColumn(name = "shipping_id")
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingModel shippingDAO;

	/** The billing Model. */
	@JoinColumn(name = "billing_id")
	@OneToOne(cascade = CascadeType.ALL)
	private BillingModel billingDAO;

	/** The order date. */
	@Column(name = "order_date", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime orderDate = ZonedDateTime.now();

	/** The modified date. */
	@Column(name = "modified_date", nullable = false)
	private LocalDateTime modifiedDate;

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
