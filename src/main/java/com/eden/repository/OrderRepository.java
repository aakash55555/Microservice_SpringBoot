package com.eden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eden.model.OrderModel;

/**
 * The Interface OrderRepository.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

	/**
	 * Find by order ID.
	 *
	 * @param orderId the order id
	 * @return the order DAO
	 */
	OrderModel findByOrderID(int orderId);

	/* 
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	void deleteById(Integer id);
}
