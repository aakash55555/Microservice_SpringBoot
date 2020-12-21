/**
 * CREATE Script for init of DB
 */

DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS billing;
DROP TABLE IF EXISTS shipping;
DROP TABLE IF EXISTS orders;

CREATE TABLE item (
  item_id INT  PRIMARY KEY,
  item_name VARCHAR(250) NOT NULL,
  item_qty INT NOT NULL,
  subtotal INT NOT NULL,
  tax INT NOT NULL,
  shipping_charges INT NOT NULL,
  total INT NOT NULL
);	

CREATE TABLE payment (
  payment_id INT   PRIMARY KEY,
  payment_method VARCHAR(250) NOT NULL,
  payment_date DATE NOT NULL,
  payment_confirmation_number INT NOT NULL
);

CREATE TABLE billing (
  billing_id INT   PRIMARY KEY,
  billing_addressline1 VARCHAR(250) NOT NULL,
  billing_addressline2 VARCHAR(250) NOT NULL,
  billing_city VARCHAR(250) NOT NULL,
  billing_state VARCHAR(250) NOT NULL,
  billing_zip VARCHAR(250) NOT NULL
);

CREATE TABLE shipping (
  shipping_id INT   PRIMARY KEY,
  shipping_addressline1 VARCHAR(250) NOT NULL,
  shipping_addressline2 VARCHAR(250) NOT NULL,
  shipping_city VARCHAR(250) NOT NULL,
  shipping_state VARCHAR(250) NOT NULL,
  shipping_zip VARCHAR(250) NOT NULL,
   shipping_method VARCHAR(25) NOT NULL	
);

CREATE TABLE orders (
  order_id INT   PRIMARY KEY,
  order_status VARCHAR(250) NOT NULL,
  customer_id INT NOT NULL,
  item_id INT NOT NULL,
  payment_id INT NOT NULL,
  billing_id INT NOT NULL,
  shipping_id INT NOT NULL,
  order_date DATE NOT NULL,
  modified_date DATE NOT NULL,
  foreign key (item_id) references item(item_id) ON DELETE RESTRICT,
  foreign key (payment_id) references payment(payment_id) ON DELETE RESTRICT,
  foreign key (billing_id) references billing(billing_id) ON DELETE RESTRICT,
  foreign key (shipping_id) references shipping(shipping_id) ON DELETE RESTRICT
);


insert into item  values (1,'Alexa mini', 1, 100, 10, 10, 120); 
insert into item  values (2,'Laptop', 1, 1200, 120, 10, 1330);
insert into payment values(1,'CREDITCARD', now(), 12345);
insert into payment values(2,'DEBITCARD', now(), 54284);
insert into billing values(1, '202 Lemon St', '100','Tempe', 'Arizona', '85281');
insert into billing values(2, '201 Lemon St', '200','Los Angeles', 'California', '95290');
insert into shipping values(1, '202 Lemon St', '100','Tempe', 'Arizona', '85281','HOMEDELIVERY');
insert into shipping values(2, '201 Lemon St', '200','Los Angeles', 'California', '95290', 'CURBSIDE');
insert into orders values(1,'SHIPPED',1,1,1,1,1, now(), now());
insert into orders values(2,'DELIVERED',2,2,2,2,2, now(), now());