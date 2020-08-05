-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Inventory-System`;

CREATE SCHEMA `Inventory-System`;
USE `Inventory-System` ;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Inventory-System`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Inventory-System`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `category` VARCHAR(255) DEFAULT NULL,
  `cost_price` DECIMAL(13,2) DEFAULT NULL,
  `selling_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `quantity` INT(11) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('FRUITS');

INSERT INTO PRODUCT (name,category,cost_price,selling_price,image_url,active,quantity,category_id)
VALUES ('Apple','Fruits',20.99,255.00,
'assets/images/products/apple.jpg'
,1,100,1);

INSERT INTO PRODUCT (name,category,cost_price,selling_price,image_url,active,quantity,category_id)
VALUES ('Orange','Fruits',20.99,30.00,
'assets/images/products/orange.jpg'
,1,100,1);

INSERT INTO PRODUCT (name,category,cost_price,selling_price,image_url,active,quantity,category_id)
VALUES ('Banana','Fruits',20.99,25.00,
'assets/images/products/banana.jpg'
,1,100,1);

INSERT INTO PRODUCT (name,category,cost_price,selling_price,image_url,active,quantity,category_id)
VALUES ('Kiwi','Fruits',20.99,100.00,
'assets/images/products/kiwi.jpg'
,1,100,1);

INSERT INTO PRODUCT (name,category,cost_price,selling_price,image_url,active,quantity,category_id)
VALUES ('Pomegrante','Fruits',20.99,50.00,
'assets/images/products/pomegranate.jpg'
,1,100,1);