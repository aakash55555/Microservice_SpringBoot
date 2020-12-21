package com.eden.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eden.exception.ConstraintsViolationException;
import com.eden.exception.EntityNotFoundException;
import com.eden.model.OrderModel;
import com.eden.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

/** The Constant log. */
@Slf4j

@Service
public class OrderServiceImpl implements OrderService {

	/** The order repository. */
	@Autowired
	private OrderRepository orderRepository;

	/*
	 *
	 * 
	 * @see com.eden.service.OrderService#find(int)
	 */
	@Override
	public OrderModel find(int orderId) throws EntityNotFoundException {
		log.debug("Finding the order by id");
		OrderModel dao = orderRepository.findById(orderId).get();
		//OrderModel order = dao.get();
		return dao;
	}

	/*
	 *
	 * 
	 * @see com.eden.service.OrderService#findAll()
	 */
	@Override
	public List<OrderModel> findAll() {
		log.debug("Finding all the orders");
		return orderRepository.findAll();
	}

	/*
	 *
	 * 
	 * @see
	 * com.eden.service.OrderService#create(com.eden.domainaccessobject.OrderDAO)
	 */
	@Override
	public OrderModel create(OrderModel orderDAO)
			throws ConstraintsViolationException, javax.persistence.EntityNotFoundException {
		log.debug("Creating an order");
		return orderRepository.save(orderDAO);
	}

	/*
	 *
	 * 
	 * @see com.eden.service.OrderService#createAll(java.util.List)
	 */
	@Override
	public List<OrderModel> createAll(List<OrderModel> orderDAO)
			throws ConstraintsViolationException, javax.persistence.EntityNotFoundException {
		log.debug("Creating the bulk orders");
		return (List<OrderModel>) orderRepository.saveAll(orderDAO);
	}

	/*
	 *
	 * 
	 * @see com.eden.service.OrderService#delete(int)
	 */
	@Override
	public void delete(int orderID) throws javax.persistence.EntityNotFoundException {
		log.debug("Deleting the order");
		orderRepository.deleteById(orderID);
	}

	/*
	 * 
	 * 
	 * @see
	 * com.eden.service.OrderService#update(com.eden.domainaccessobject.OrderDAO)
	 */
	@Override
	public OrderModel update(OrderModel orderDAO) {
		log.debug("Updating the order by id");
		return orderRepository.save(orderDAO);
	}

	/*
	 *
	 * 
	 * @see com.eden.service.OrderService#updateAll(java.util.List)
	 */
	@Override
	public List<OrderModel> updateAll(List<OrderModel> orderDAO) {
		log.debug("Updating the bulk orders");
		return (List<OrderModel>) orderRepository.saveAll(orderDAO);
	}
}
