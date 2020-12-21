package com.eden.domainvalue;

/**
 * The Enum OrderStatus.
 */
public enum OrderStatus {

	/** The ordered. */
	ORDERED,
	/** The shipped. */
	SHIPPED,
	/** The delivered. */
	DELIVERED;

	/**
	 * From string.
	 *
	 * @param value
	 *            the value
	 * @return the order status
	 */
	public static OrderStatus fromString(String value) {
		for (OrderStatus e : OrderStatus.values()) {
			if (e.toString().equals(value))
				return e;
		}
		return null;
	}

}
