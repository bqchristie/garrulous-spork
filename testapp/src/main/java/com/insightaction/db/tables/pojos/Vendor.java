/**
 * This class is generated by jOOQ
 */
package com.insightaction.db.tables.pojos;


import java.io.Serializable;
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
public class Vendor implements Serializable {

	private static final long serialVersionUID = 322796136;

	private Integer   id;
	private Timestamp createdate;
	private Timestamp modifieddate;
	private String    vendor;
	private String    vendornumber;

	public Vendor() {}

	public Vendor(Vendor value) {
		this.id = value.id;
		this.createdate = value.createdate;
		this.modifieddate = value.modifieddate;
		this.vendor = value.vendor;
		this.vendornumber = value.vendornumber;
	}

	public Vendor(
		Integer   id,
		Timestamp createdate,
		Timestamp modifieddate,
		String    vendor,
		String    vendornumber
	) {
		this.id = id;
		this.createdate = createdate;
		this.modifieddate = modifieddate;
		this.vendor = vendor;
		this.vendornumber = vendornumber;
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

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendornumber() {
		return this.vendornumber;
	}

	public void setVendornumber(String vendornumber) {
		this.vendornumber = vendornumber;
	}
}
