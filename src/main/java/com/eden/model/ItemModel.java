package com.eden.model;

import java.io.Serializable;

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
 * The Class ItemDAO.
 */
@Getter
@Setter
@Entity
@Table(name = "item")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The item ID. */
	@Id
	@Column(name = "item_id", nullable = false)
	private int itemID;

	/** The item name. */
	@Column(name = "item_name", nullable = false)
	private String itemName;

	/** The item qty. */
	@Column(name = "item_qty", nullable = false)
	private int itemQty;

	/** The subtotal. */
	@Column(name = "subtotal", nullable = false)
	private int subtotal;

	/** The tax. */
	@Column(name = "tax", nullable = false)
	private int tax;

	// @Column(name = "order_id")
	// @ManyToOne
	// private OrderDAO orderDAO;

	/** The shipping charges. */
	@Column(name = "shipping_charges", nullable = false)
	private int shippingCharges;

	/** The total. */
	@Column(name = "total", nullable = false)
	private int total;
}
