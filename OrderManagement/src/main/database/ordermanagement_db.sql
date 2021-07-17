DROP DATABASE IF EXISTS ordermanagement;
CREATE DATABASE ordermanagement;

USE ordermanagement;

-- ==========================CREATE TABLE EMPLOYEE==========================
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(

	employeeID						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`							NVARCHAR(100) NOT NULL,
    age								INT NOT NULL,
    address							NVARCHAR(500) NOT NULL,
	phone							NVARCHAR(15) NOT NULL,
    `position`						NVARCHAR(50) NOT NULL,
    department						NVARCHAR(50) NOT NULL
);

-- ==========================CREATE TABLE CATEGORYPRODUCT==========================
DROP TABLE IF EXISTS categoryProduct;
CREATE TABLE categoryProduct(
	categoryId						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    categoryName					NVARCHAR(100) NOT NULL
    
);

-- ==========================CREATE TABLE PRODUCT==========================
DROP TABLE IF EXISTS product;
CREATE TABLE product(

	productID						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    categoryId						INT UNSIGNED ,
    productName						NVARCHAR(100) NOT NULL,
	quantity						INT NOT NULL,
    price							INT NOT NULL,
    importDate						DATE DEFAULT(NOW()),
    employeeID						INT	UNSIGNED,
    
    FOREIGN KEY(categoryId)			REFERENCES categoryProduct (categoryId),
    FOREIGN KEY(employeeID)			REFERENCES employee(employeeID)
);



-- ============================================INSERT DATA============================================

-- =========EMPLOYEE=========

INSERT INTO employee	(	`name`				,	age		,	address					,	phone			,	`position`			,	department		)
VALUES					(	'Tran Duc Luan'		,	'20'	,	'Hoang Mai, Ha Noi'		,	'0942273195'	,	'Nhan Vien Kho'		,	'Kho'			),
						(	'Hoang Ngoc Tung'	,	'20'	,	'Hoang Mai, Ha Noi'		,	'0456789123'	,	'Nhan Vien Kho'		,	'Kho'			),
                        (	'Ha Thi Thu Uyen'	,	'20'	,	'Hoang Mai, Ha Noi'		,	'0363821300'	,	'Nhan Vien Kho'		,	'Kho'			);
                        
                        
-- =========CATEGORYPRODUCT=========
                        
INSERT INTO categoryProduct	(	categoryName	)
VALUES						(	'Rau'			),
							(	'Thit'			),
							(	'Ca'			),
                            (	'Trai cay'		);

-- =========PRODUCT=========

INSERT INTO product		(	categoryId			,	productName					,	quantity			,	price			,	importDate		,	employeeID		)
VALUES					(	'1'					,	'Rau muong'					,	'20'				,	'2000'			,	'2021-07-02'	,	'1'				),
						(	'1'					,	'Rau ngot'					,	'20'				,	'2000'			,	'2021-07-02'	,	'1'				),
                        (	'2'					,	'Thit bo Kobe'				,	'20'				,	'100000'		,	'2021-07-02'	,	'1'				),
                        (	'2'					,	'Thit Ga'					,	'20'				,	'20000'			,	'2021-07-02'	,	'1'				),
                        (	'2'					,	'Thit heo'					,	'20'				,	'30000'			,	'2021-07-02'	,	'1'				),
                        (	'3'					,	'Ca hoi'					,	'20'				,	'200000'		,	'2021-07-02'	,	'1'				),
                        (	'3'					,	'Ca chep'					,	'20'				,	'2000'			,	'2021-07-02'	,	'1'				),
                        (	'3'					,	'Ca qua'					,	'20'				,	'10000'			,	'2021-07-02'	,	'1'				),
                        (	'4'					,	'Dua hau'					,	'20'				,	'10000'			,	'2021-07-02'	,	'1'				),
						(	'4'					,	'Cherry'					,	'20'				,	'10000'			,	'2021-07-02'	,	'1'				);
                        
INSERT INTO product		(	categoryId			,	productName					,	quantity			,	price			,	employeeID	)
VALUES					(	'4'					,	'Nho'						,	'20'				,	'10000'			,	'1'			);

                            
-- ========================================================================================================================================
DROP VIEW IF EXISTS orderManagement;
CREATE VIEW orderManagement
AS
SELECT `name` AS 'Người nhận', categoryName AS 'Loại hàng', productname AS 'Tên sản phẩm', quantity AS 'Số lượng', importDate AS 'Ngày nhập hàng'
FROM	employee AS a
JOIN	product AS c
ON		a.employeeID = c.employeeID
JOIN	categoryProduct AS d
ON		c.categoryId = d.categoryId;

SELECT * FROM orderManagement;
