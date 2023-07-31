CREATE TABLE pedido (
  order_number UUID NOT NULL,
   total_price DOUBLE PRECISION NOT NULL,
   payment_method INT NOT NULL,
   CONSTRAINT pk_pedido PRIMARY KEY (order_number)
);



