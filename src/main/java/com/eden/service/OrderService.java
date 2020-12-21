package com.eden.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eden.exception.ConstraintsViolationException;
import com.eden.exception.EntityNotFoundException;
import com.eden.model.OrderModel;

/**
 * The Interface OrderService.
 */

public interface OrderService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<OrderModel> findAll();

	/**
	 * Find.
	 *
	 * @param orderID the order ID
	 * @return the order DAO
	 * @throws EntityNotFoundExceptionTests the entity not found exception
	 */
	OrderModel find(int orderID) throws EntityNotFoundException;

	/**
	 * Creates the.
	 *
	 * @param orderDO the order DO
	 * @return the order DAO
	 * @throws ConstraintsViolationExceptionTests the constraints violation exception
	 * @throws EntityNotFoundExceptionTests the entity not found exception
	 */
	OrderModel create(OrderModel orderDO) throws ConstraintsViolationException, EntityNotFoundException;

	/**
	 * Creates the all.
	 *
	 * @param orderDO the order DO
	 * @return the list
	 * @throws ConstraintsViolationExceptionTests the constraints violation exception
	 * @throws EntityNotFoundExceptionTests the entity not found exception
	 */
	List<OrderModel> createAll(List<OrderModel> orderDO) throws ConstraintsViolationException, EntityNotFoundException;

	/**
	 * Delete.
	 *
	 * @param orderID the order ID
	 * @throws EntityNotFoundExceptionTests the entity not found exception
	 */
	void delete(int orderID) throws EntityNotFoundException;

	/**
	 * Update.
	 *
	 * @param orderDAO the order DAO
	 * @return the order DAO
	 */
	OrderModel update(OrderModel orderDAO);

	/**
	 * Update all.
	 *
	 * @param orderDAO the order DAO
	 * @return the list
	 */
	List<OrderModel> updateAll(List<OrderModel> orderDAO);

}
