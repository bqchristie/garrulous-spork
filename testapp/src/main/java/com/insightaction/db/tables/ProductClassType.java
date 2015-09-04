/**
 * This class is generated by jOOQ
 */
package com.insightaction.db.tables;


import com.insightaction.db.Insightaction;
import com.insightaction.db.Keys;
import com.insightaction.db.tables.records.ProductClassTypeRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class ProductClassType extends TableImpl<ProductClassTypeRecord> {

	private static final long serialVersionUID = 1211699221;

	/**
	 * The reference instance of <code>insightaction.PRODUCT_CLASS_TYPE</code>
	 */
	public static final ProductClassType PRODUCT_CLASS_TYPE = new ProductClassType();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ProductClassTypeRecord> getRecordType() {
		return ProductClassTypeRecord.class;
	}

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.id</code>.
	 */
	public final TableField<ProductClassTypeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.createDate</code>.
	 */
	public final TableField<ProductClassTypeRecord, Timestamp> CREATEDATE = createField("createDate", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.modifiedDate</code>.
	 */
	public final TableField<ProductClassTypeRecord, Timestamp> MODIFIEDDATE = createField("modifiedDate", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.classType</code>.
	 */
	public final TableField<ProductClassTypeRecord, String> CLASSTYPE = createField("classType", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.classTypeName</code>.
	 */
	public final TableField<ProductClassTypeRecord, String> CLASSTYPENAME = createField("classTypeName", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>insightaction.PRODUCT_CLASS_TYPE.classTypeNo</code>.
	 */
	public final TableField<ProductClassTypeRecord, String> CLASSTYPENO = createField("classTypeNo", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * Create a <code>insightaction.PRODUCT_CLASS_TYPE</code> table reference
	 */
	public ProductClassType() {
		this("PRODUCT_CLASS_TYPE", null);
	}

	/**
	 * Create an aliased <code>insightaction.PRODUCT_CLASS_TYPE</code> table reference
	 */
	public ProductClassType(String alias) {
		this(alias, PRODUCT_CLASS_TYPE);
	}

	private ProductClassType(String alias, Table<ProductClassTypeRecord> aliased) {
		this(alias, aliased, null);
	}

	private ProductClassType(String alias, Table<ProductClassTypeRecord> aliased, Field<?>[] parameters) {
		super(alias, Insightaction.INSIGHTACTION, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ProductClassTypeRecord, Integer> getIdentity() {
		return Keys.IDENTITY_PRODUCT_CLASS_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ProductClassTypeRecord> getPrimaryKey() {
		return Keys.KEY_PRODUCT_CLASS_TYPE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ProductClassTypeRecord>> getKeys() {
		return Arrays.<UniqueKey<ProductClassTypeRecord>>asList(Keys.KEY_PRODUCT_CLASS_TYPE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductClassType as(String alias) {
		return new ProductClassType(alias, this);
	}

	/**
	 * Rename this table
	 */
	public ProductClassType rename(String name) {
		return new ProductClassType(name, null);
	}
}
