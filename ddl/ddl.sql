
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_PRODUCT_CLASS_TYPE;
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_VENDOR;
ALTER TABLE STORE_PRODUCT_DATA DROP FOREIGN KEY FK_STORE;
ALTER TABLE STORE_PRODUCT_DATA DROP FOREIGN KEY FK_PRODUCT;

drop TABLE CSV_IMPORT;

create  TABLE CSV_IMPORT (
    id int(11) not null AUTO_INCREMENT,
    filename varchar(200) not null,
    importDate datetime not null,
    processDate datetime,
    status varchar(50) not null,
    A varchar(100),
    B varchar(100),
    C varchar(100),
    D varchar(100),
    E varchar(100),
    F varchar(100),
    G varchar(100),
    H varchar(100),
    I varchar(100),
    J varchar(100),
    K varchar(100),
    L varchar(100),
    M varchar(100),
    N varchar(100),
    O varchar(100),
    P varchar(100),
    Q varchar(100),
    R varchar(100),
    S varchar(100),
    T varchar(100),
    PRIMARY KEY (id)
);

drop TABLE STORE;

create TABLE STORE (
	 id int(11) not null AUTO_INCREMENT,
	 createDate datetime not null,
	 modifiedDate datetime,
	 storeLicenseeName varchar(100) not null,
	 state varchar(100) not null,
	 storeLicenseeInd varchar(100) not null,
	 zip varchar(100) not null,
	 storeLicenseeNo varchar(100) not null,
	 address1 varchar(100) not null,
	 city varchar(100) not null,
	 PRIMARY KEY (id)
);

drop TABLE PRODUCT_CLASS_TYPE;

create TABLE PRODUCT_CLASS_TYPE(
	id int(11) not null AUTO_INCREMENT,
	createDate datetime not null,
	modifiedDate datetime,
    classType varchar(100) not null,
    classTypeName varchar(100) not null,
    classTypeNo varchar(100) not null,
    PRIMARY KEY(id)
);


drop TABLE VENDOR;

create TABLE VENDOR(
	id int(11) not null AUTO_INCREMENT,
	createDate datetime not null,
	modifiedDate datetime,
    vendor varchar(100) not null,
    vendorNumber varchar(100) not null,
    PRIMARY KEY(id)
);

#Make vendor number unique


DROP TABLE IF EXISTS PRODUCT;

create TABLE PRODUCT (
	id int(11) not null AUTO_INCREMENT,
	createDate datetime not null,
	modifiedDate datetime,
	ProductName varchar(100) not null,
	classId varchar(100),
	PRODUCT_CLASS_TYPE_ID int(11),
	VENDOR_ID  int(11),
	CommonCode varchar(100),
	BeverageType varchar(100),
	Size varchar(100),
	Brand varchar(100),
	CommonCodeName varchar(100),
	CommonCodeNo varchar(100),
	Listed_NonListed varchar(100),
	PackSize varchar(100),
	PackSizeInd varchar(100),
	Bottles varchar(100),
	PRIMARY KEY (id)
);

##ADD FOREIGN KEYS FOR VENDOR AND PRODUCT CLASS TYPE

ALTER TABLE PRODUCT 
ADD CONSTRAINT FK_VENDOR
FOREIGN KEY (VENDOR_ID) REFERENCES VENDOR(id);

ALTER TABLE PRODUCT 
ADD CONSTRAINT FK_PRODUCT_CLASS_TYPE
FOREIGN KEY (PRODUCT_CLASS_TYPE_ID) REFERENCES PRODUCT_CLASS_TYPE(id);


DROP TABLE IF EXISTS STORE_DATA;

DROP TABLE IF EXISTS STORE_PRODUCT_DATA;

CREATE TABLE STORE_PRODUCT_DATA (
	id int(11) not null AUTO_INCREMENT,
	createDate datetime not null,
	modifiedDate datetime,
	Year int(4),
	Period int(2),
	STORE_ID int(11),
	PRODUCT_ID int(11),
	Bottles  int(11),
	CasesActual  DECIMAL(8,2),
	CasesStandard DECIMAL(8,2),
	Cases9Liter DECIMAL(8,2),
	RetailDollarVol DECIMAL(8,2),
	ShelfDollarVol DECIMAL(8,2),
	FOBDollarVol DECIMAL(8,2),
	PRIMARY KEY (id)
);
## ADD FOREIGN KEYS
ALTER TABLE STORE_PRODUCT_DATA
ADD CONSTRAINT FK_STORE
FOREIGN KEY (STORE_ID) REFERENCES STORE(id);

ALTER TABLE STORE_PRODUCT_DATA 
ADD CONSTRAINT FK_PRODUCT
FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(id);


DROP FUNCTION IF EXISTS UPDATE_SHELF_PRICE;

CREATE FUNCTION UPDATE_SHELF_PRICE(STORE_ID INT, PRODUCT_ID INT, PRICE DECIMAL(10,2)) RETURNS VARCHAR(10)
  BEGIN
   UPDATE STORE_PRODUCT_DATA SET ShelfDollarVol = PRICE
   WHERE STORE_ID = STORE_ID and PRODUCT_ID = PRODUCT_ID;
  RETURN "SUCCESS";
END;





