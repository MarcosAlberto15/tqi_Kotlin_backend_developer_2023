CREATE TABLE order_product (
  order_order_number UUID NOT NULL,
   products INT,
   products_key BIGINT NOT NULL,
   CONSTRAINT pk_order_product PRIMARY KEY (order_order_number, products_key)
);


ALTER TABLE order_product ADD CONSTRAINT fk_order_product_on_order FOREIGN KEY (order_order_number) REFERENCES pedido (order_number);

ALTER TABLE order_product ADD CONSTRAINT fk_order_product_on_product FOREIGN KEY (products_key) REFERENCES product (id);