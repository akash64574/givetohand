package com.give2hand.common;

/**
 * GiveToHandEnum is the enum for the maintaining the values of the
 * Booking status details.
 * 
 * @author Amala.S
 * @since 14-02-2020
 * @version V1.1
 *
 */
public class GiveToHandEnum {

	
	/**
	 * Maintaining the role type such as Admine and user
	 * 
	 * @author Govindasamy
	 * @since 14-02-2020
	 */
	public enum Role {
		ADMINE, USER;

	}
	/**
	 * Maintaining the transaction Types such as Credit and Debit types.
	 * 
	 * @author Amala.S
	 * @since 14-02-2020
	 * @version V1.1
	 */
	public enum PaymentType {
		CREDIT, DEBIT;

	}
	
	/**
	 * Maintaining the transaction Types such as Credit and Debit types.
	 * 
	 * @author Amala.S
	 * @since 14-02-2020
	 * @version V1.1
	 */
	public enum PaymentStatus {
		SUCCESS, FAILURE;

	}


	
}
