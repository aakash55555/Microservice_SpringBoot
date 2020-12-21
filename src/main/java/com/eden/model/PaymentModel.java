package com.eden.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.eden.domainvalue.PaymentType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class PaymentDAO.
 */
@Getter
@Setter
@Entity
@Table(name = "payment")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentModel {

	/** The payment ID. */
	@Id
	@Column(name = "payment_id", nullable = false)
	private int paymentID;

	/** The payment method. */
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method", nullable = false)
	private PaymentType paymentMethod;

	/** The payment date. */
	@Column(name = "payment_date", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime paymentDate = ZonedDateTime.now();

	/** The payment confirmation number. */
	@Column(name = "payment_confirmation_number", nullable = false)
	private Integer paymentConfirmationNumber;

}
