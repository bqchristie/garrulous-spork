/**
 * This class is generated by jOOQ
 */
package com.insightaction.db.tables;


import com.insightaction.db.Insightaction;
import com.insightaction.db.tables.records.StoreDataViewRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * VIEW
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreDataView extends TableImpl<StoreDataViewRecord> {

	private static final long serialVersionUID = -1882161742;

	/**
	 * The reference instance of <code>insightaction.store_data_view</code>
	 */
	public static final StoreDataView STORE_DATA_VIEW = new StoreDataView();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StoreDataViewRecord> getRecordType() {
		return StoreDataViewRecord.class;
	}

	/**
	 * The column <code>insightaction.store_data_view.id</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>insightaction.store_data_view.createDate</code>.
	 */
	public final TableField<StoreDataViewRecord, Timestamp> CREATEDATE = createField("createDate", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>insightaction.store_data_view.modifiedDate</code>.
	 */
	public final TableField<StoreDataViewRecord, Timestamp> MODIFIEDDATE = createField("modifiedDate", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>insightaction.store_data_view.Year</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> YEAR = createField("Year", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>insightaction.store_data_view.Period</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> PERIOD = createField("Period", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>insightaction.store_data_view.STORE_ID</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> STORE_ID = createField("STORE_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>insightaction.store_data_view.PRODUCT_ID</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> PRODUCT_ID = createField("PRODUCT_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>insightaction.store_data_view.Bottles</code>.
	 */
	public final TableField<StoreDataViewRecord, Integer> BOTTLES = createField("Bottles", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>insightaction.store_data_view.CasesActual</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> CASESACTUAL = createField("CasesActual", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.CasesStandard</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> CASESSTANDARD = createField("CasesStandard", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.Cases9Liter</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> CASES9LITER = createField("Cases9Liter", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.RetailDollarVol</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> RETAILDOLLARVOL = createField("RetailDollarVol", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.ShelfDollarVol</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> SHELFDOLLARVOL = createField("ShelfDollarVol", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.FOBDollarVol</code>.
	 */
	public final TableField<StoreDataViewRecord, BigDecimal> FOBDOLLARVOL = createField("FOBDollarVol", org.jooq.impl.SQLDataType.DECIMAL.precision(8, 2), this, "");

	/**
	 * The column <code>insightaction.store_data_view.storeLicenseeName</code>.
	 */
	public final TableField<StoreDataViewRecord, String> STORELICENSEENAME = createField("storeLicenseeName", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>insightaction.store_data_view.ProductName</code>.
	 */
	public final TableField<StoreDataViewRecord, String> PRODUCTNAME = createField("ProductName", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * Create a <code>insightaction.store_data_view</code> table reference
	 */
	public StoreDataView() {
		this("store_data_view", null);
	}

	/**
	 * Create an aliased <code>insightaction.store_data_view</code> table reference
	 */
	public StoreDataView(String alias) {
		this(alias, STORE_DATA_VIEW);
	}

	private StoreDataView(String alias, Table<StoreDataViewRecord> aliased) {
		this(alias, aliased, null);
	}

	private StoreDataView(String alias, Table<StoreDataViewRecord> aliased, Field<?>[] parameters) {
		super(alias, Insightaction.INSIGHTACTION, aliased, parameters, "VIEW");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StoreDataView as(String alias) {
		return new StoreDataView(alias, this);
	}

	/**
	 * Rename this table
	 */
	public StoreDataView rename(String name) {
		return new StoreDataView(name, null);
	}
}
