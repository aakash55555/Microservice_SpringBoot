package com.eden.domainvalue;

/**
 * The Enum PaymentType.
 */
public enum PaymentType {

	/** The creditcard. */
	CREDITCARD,
	/** The debitcard. */
	DEBITCARD,
	/** The paypal. */
	PAYPAL;

	/**
	 * From string.
	 *
	 * @param value
	 *            the value
	 * @return the payment type
	 */
	public static PaymentType fromString(String value) {
		for (PaymentType e : PaymentType.values()) {
			if (e.toString().equals(value))
				return e;
		}
		return null;
	}

}
