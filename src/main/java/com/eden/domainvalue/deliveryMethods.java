package com.eden.domainvalue;

public enum deliveryMethods {
	INSTOREPICKUP, CURBSIDE, HOMEDELIVERY, THIRDPARTY;

	/**
	 * From string.
	 *
	 * @param value
	 *            the value
	 * @return the delivery methods
	 */
	public static deliveryMethods fromString(String value) {
		for (deliveryMethods e : deliveryMethods.values()) {
			if (e.toString().equals(value))
				return e;
		}
		return null;
	}
}
