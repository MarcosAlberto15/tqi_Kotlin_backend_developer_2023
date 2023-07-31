CREATE TABLE product (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255) NOT NULL,
   unit VARCHAR(255) NOT NULL,
   price DOUBLE PRECISION NOT NULL,
   quantity INT NOT NULL,
   category_id BIGINT,
   CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);