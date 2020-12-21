package com.eden.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.eden.domainvalue.OrderStatus;
import com.eden.exception.ConstraintsViolationException;
import com.eden.exception.EntityNotFoundException;
import com.eden.model.BillingModel;
import com.eden.model.ItemModel;
import com.eden.model.OrderModel;
import com.eden.model.PaymentModel;
import com.eden.model.ShippingModel;
import com.eden.repository.OrderRepository;

/**
 * The Class OrderController.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderServiceImplTests {

	/** The order service. */
	@Mock
	private OrderService orderService;

	/** The repo. */
	@Mock
	private OrderRepository repo;

	/** The order service impl. */
	@InjectMocks
	OrderServiceImpl orderServiceImpl;

	/**
	 * Find test.
	 *
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void findTest() throws EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(repo.findById(5)).thenReturn(Optional.of(order));
		assertEquals(order.getOrderID(), orderServiceImpl.find(5).getOrderID());
	}

	/**
	 * Find all test.
	 *
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void findAllTest() throws EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.findAll()).thenReturn(list);
		assertEquals(list.size(), orderServiceImpl.findAll().size());
	}

	/**
	 * Delete test.
	 *
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void deleteTest() throws EntityNotFoundException {
		orderServiceImpl.delete(5);
		assertTrue(Boolean.TRUE);
	}

	/**
	 * Creates the test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void createTest() throws ConstraintsViolationException, EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(repo.save(Mockito.any())).thenReturn(order);
		assertEquals(order.getOrderID(), orderServiceImpl.create(order).getOrderID());
	}

	/**
	 * Creates the all test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void createAllTest() throws ConstraintsViolationException, EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.saveAll(Mockito.any())).thenReturn(list);
		assertEquals(list.size(), orderServiceImpl.createAll(list).size());
	}

	/**
	 * Update.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void update() throws ConstraintsViolationException, EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(repo.save(Mockito.any())).thenReturn(order);
		assertEquals(order.getOrderID(), orderServiceImpl.update(order).getOrderID());
	}

	/**
	 * Update all test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void updateAllTest() throws ConstraintsViolationException, EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.saveAll(Mockito.any())).thenReturn(list);
		assertEquals(list.size(), orderServiceImpl.updateAll(list).size());
	}

}
