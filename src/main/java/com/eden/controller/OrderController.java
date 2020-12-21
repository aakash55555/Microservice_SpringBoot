package com.eden.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eden.exception.ConstraintsViolationException;
import com.eden.exception.EntityNotFoundException;
import com.eden.model.OrderModel;
import com.eden.repository.OrderRepository;
import com.eden.service.OrderService;

/**
 * The Class OrderController.
 */
@RestController
@RequestMapping("v1/orders")
public class OrderController {

	/** The order updated. */
	private final String ORDER_UPDATED = "Order Updated";
	
	/** The order updated. */
	private final String ORDER_NOT_UPDATED = "Order not Updated";
	
	/** The order service. */
	@Autowired
	private OrderService orderService;

	/** The repo. */
	@Autowired
	private OrderRepository repo;

	/**
	 * Find orders.
	 *
	 * @return the list
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<OrderModel> findOrders() {
		return repo.findAll();
	}

	/**
	 * Gets the order.
	 *
	 * @param orderId
	 *            the order id
	 * @return the order
	 * @throws EntityNotFoundExceptionTests
	 *             the entity not found exception
	 */
	@GetMapping(value = "/{orderId}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody OrderModel getOrder(@PathVariable int orderId) throws EntityNotFoundException {
		OrderModel dao = orderService.find(orderId);
		return dao;
	}

	/**
	 * Delete order.
	 *
	 * @param orderId
	 *            the order id
	 * @throws EntityNotFoundExceptionTests
	 *             the entity not found exception
	 */
	@DeleteMapping("/{orderId}")
	public void deleteOrder(@PathVariable int orderId) throws EntityNotFoundException {
		orderService.delete(orderId);
	}

	/**
	 * Creates the order.
	 *
	 * @param orderDAO
	 *            the order DAO
	 * @return the order DAO
	 * @throws ConstraintsViolationExceptionTests
	 *             the constraints violation exception
	 * @throws EntityNotFoundExceptionTests
	 *             the entity not found exception
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderModel createOrder(@Valid @RequestBody OrderModel orderDAO)
			throws ConstraintsViolationException, EntityNotFoundException {
		return repo.save(orderDAO);
	}

	/**
	 * Creates the bulk orders.
	 *
	 * @param orderDAO
	 *            the order DAO
	 * @return the list
	 */
	@PostMapping("bulk")
	public List<OrderModel> createBulkOrders(@RequestBody List<OrderModel> orderDAO) {
		return (List<OrderModel>) repo.saveAll(orderDAO);
	}

	/**
	 * Update order.
	 *
	 * @param orderDAO
	 *            the order DAO
	 * @return the string
	 * @throws ConstraintsViolationExceptionTests
	 *             the constraints violation exception
	 * @throws EntityNotFoundExceptionTests
	 *             the entity not found exception
	 */
	@PutMapping
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String updateOrder(@Valid @RequestBody OrderModel orderDAO)
			throws ConstraintsViolationException, EntityNotFoundException {
		if(!ObjectUtils.isEmpty(orderDAO)) {
		Optional<OrderModel> order = repo.findById(orderDAO.getOrderID());
		if (order.isPresent()) {
			order.get().setOrderStatus(orderDAO.getOrderStatus());
			order.get().setModifiedDate(LocalDateTime.now());
			repo.save(order.get());
		}
		return ORDER_UPDATED;
		}
		return ORDER_NOT_UPDATED;
	}

	/**
	 * Update bulk orders.
	 *
	 * @param orderDAO
	 *            the order DAO
	 * @return the string
	 * @throws EntityNotFoundExceptionTests
	 *             the entity not found exception
	 */
	@PutMapping("bulk")
	public String updateBulkOrders(@RequestBody List<OrderModel> orderDAO) throws EntityNotFoundException {
		orderDAO.stream().forEach(order -> {
			Optional<OrderModel> orderStatus = repo.findById(order.getOrderID());
			if (orderStatus.isPresent()) {
				orderStatus.get().setOrderStatus(order.getOrderStatus());
				repo.save(orderStatus.get());
			}
		});
		return ORDER_UPDATED;
	}
}
