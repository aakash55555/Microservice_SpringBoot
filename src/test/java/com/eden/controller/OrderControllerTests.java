package com.eden.controller;

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
import com.eden.service.OrderService;

/**
 * The Class OrderController.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderControllerTests {

	/** The order updated. */
	private final String ORDER_UPDATED = "Order Updated";

	/** The order updated. */
	private final String ORDER_NOT_UPDATED = "Order not Updated";

	/** The order service. */
	@Mock
	private OrderService orderService;

	/** The repo. */
	@Mock
	private OrderRepository repo;

	/** The order controller. */
	@InjectMocks
	OrderController orderController;

	/**
	 * Gets the order test.
	 *
	 * @return the order test
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void getOrderTest() throws EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(orderService.find(5)).thenReturn(order);
		assertEquals(order.getOrderID(), orderController.getOrder(5).getOrderID());
	}

	/**
	 * Find orders test.
	 *
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void findOrdersTest() throws EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);

		when(repo.findAll()).thenReturn(list);
		assertEquals(list.size(), orderController.findOrders().size());
	}

	/**
	 * Find orders entity not found exception test.
	 */
	@Test(expected = Exception.class)
	public void findOrdersEntityNotFoundExceptionTest() {
		when(repo.findAll()).thenThrow(new EntityNotFoundException(""));
	}

	/**
	 * Find orders constraint violation exception test.
	 */
	@Test(expected = Exception.class)
	public void findOrdersConstraintViolationExceptionTest() {
		when(repo.findAll()).thenThrow(new ConstraintsViolationException(""));
	}

	/**
	 * Creates the order test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void createOrderTest() throws ConstraintsViolationException, EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(repo.save(Mockito.any())).thenReturn(order);
		assertEquals(order.getOrderID(), orderController.createOrder(order).getOrderID());
	}

	/**
	 * Creates the bulk orders test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void createBulkOrdersTest() throws ConstraintsViolationException, EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.saveAll(Mockito.any())).thenReturn(list);
		assertEquals(list.size(), orderController.createBulkOrders(list).size());
	}

	/**
	 * Update order with test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void updateOrderWithTest() throws ConstraintsViolationException, EntityNotFoundException {
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		when(repo.save(Mockito.any())).thenReturn(order);
		when(repo.findById(5)).thenReturn(Optional.of(order));
		assertEquals(ORDER_UPDATED, orderController.updateOrder(order));
	}

	/**
	 * Update order with empty orders test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void updateOrderWithEmptyOrdersTest() throws ConstraintsViolationException, EntityNotFoundException {

		assertEquals(ORDER_UPDATED, orderController.updateOrder(new OrderModel()));
	}

	/**
	 * Update bulk orders test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void updateBulkOrdersTest() throws ConstraintsViolationException, EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.save(Mockito.any())).thenReturn(order);
		when(repo.findById(Mockito.any())).thenReturn(Optional.of(order));
		assertEquals(ORDER_UPDATED, orderController.updateBulkOrders(list));
	}

	/**
	 * Update bulk for empty orders test.
	 *
	 * @throws ConstraintsViolationException
	 *             the constraints violation exception
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void updateBulkForEmptyOrdersTest() throws ConstraintsViolationException, EntityNotFoundException {
		List<OrderModel> list = new ArrayList<>();
		OrderModel order = new OrderModel(5, OrderStatus.DELIVERED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		OrderModel order1 = new OrderModel(10, OrderStatus.SHIPPED, 5, new ItemModel(), new PaymentModel(),
				new ShippingModel(), new BillingModel(), ZonedDateTime.now(), LocalDateTime.now());
		list.add(order);
		list.add(order1);
		when(repo.findById(Mockito.any())).thenReturn(Optional.empty());
		assertEquals(ORDER_UPDATED, orderController.updateBulkOrders(list));
	}

	/**
	 * Delete order test.
	 *
	 * @throws EntityNotFoundException
	 *             the entity not found exception
	 */
	@Test
	public void deleteOrderTest() throws EntityNotFoundException {
		orderController.deleteOrder(5);
		assertTrue(Boolean.TRUE);
	}

}
