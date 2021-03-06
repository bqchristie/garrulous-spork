/**
 * This class is generated by jOOQ
 */
package com.insightaction.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreProductData implements Serializable {

	private static final long serialVersionUID = 1105254106;

	private Integer    id;
	private Timestamp  createdate;
	private Timestamp  modifieddate;
	private Integer    year;
	private Integer    period;
	private Integer    storeId;
	private Integer    productId;
	private Integer    bottles;
	private BigDecimal casesactual;
	private BigDecimal casesstandard;
	private BigDecimal cases9liter;
	private BigDecimal retaildollarvol;
	private BigDecimal shelfdollarvol;
	private BigDecimal fobdollarvol;

	public StoreProductData() {}

	public StoreProductData(StoreProductData value) {
		this.id = value.id;
		this.createdate = value.createdate;
		this.modifieddate = value.modifieddate;
		this.year = value.year;
		this.period = value.period;
		this.storeId = value.storeId;
		this.productId = value.productId;
		this.bottles = value.bottles;
		this.casesactual = value.casesactual;
		this.casesstandard = value.casesstandard;
		this.cases9liter = value.cases9liter;
		this.retaildollarvol = value.retaildollarvol;
		this.shelfdollarvol = value.shelfdollarvol;
		this.fobdollarvol = value.fobdollarvol;
	}

	public StoreProductData(
		Integer    id,
		Timestamp  createdate,
		Timestamp  modifieddate,
		Integer    year,
		Integer    period,
		Integer    storeId,
		Integer    productId,
		Integer    bottles,
		BigDecimal casesactual,
		BigDecimal casesstandard,
		BigDecimal cases9liter,
		BigDecimal retaildollarvol,
		BigDecimal shelfdollarvol,
		BigDecimal fobdollarvol
	) {
		this.id = id;
		this.createdate = createdate;
		this.modifieddate = modifieddate;
		this.year = year;
		this.period = period;
		this.storeId = storeId;
		this.productId = productId;
		this.bottles = bottles;
		this.casesactual = casesactual;
		this.casesstandard = casesstandard;
		this.cases9liter = cases9liter;
		this.retaildollarvol = retaildollarvol;
		this.shelfdollarvol = shelfdollarvol;
		this.fobdollarvol = fobdollarvol;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBottles() {
		return this.bottles;
	}

	public void setBottles(Integer bottles) {
		this.bottles = bottles;
	}

	public BigDecimal getCasesactual() {
		return this.casesactual;
	}

	public void setCasesactual(BigDecimal casesactual) {
		this.casesactual = casesactual;
	}

	public BigDecimal getCasesstandard() {
		return this.casesstandard;
	}

	public void setCasesstandard(BigDecimal casesstandard) {
		this.casesstandard = casesstandard;
	}

	public BigDecimal getCases9liter() {
		return this.cases9liter;
	}

	public void setCases9liter(BigDecimal cases9liter) {
		this.cases9liter = cases9liter;
	}

	public BigDecimal getRetaildollarvol() {
		return this.retaildollarvol;
	}

	public void setRetaildollarvol(BigDecimal retaildollarvol) {
		this.retaildollarvol = retaildollarvol;
	}

	public BigDecimal getShelfdollarvol() {
		return this.shelfdollarvol;
	}

	public void setShelfdollarvol(BigDecimal shelfdollarvol) {
		this.shelfdollarvol = shelfdollarvol;
	}

	public BigDecimal getFobdollarvol() {
		return this.fobdollarvol;
	}

	public void setFobdollarvol(BigDecimal fobdollarvol) {
		this.fobdollarvol = fobdollarvol;
	}
}
