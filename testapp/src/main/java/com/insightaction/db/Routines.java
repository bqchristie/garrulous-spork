/**
 * This class is generated by jOOQ
 */
package com.insightaction.db;


import com.insightaction.db.routines.UpdateShelfPrice;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in insightaction
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

	/**
	 * Call <code>insightaction.UPDATE_SHELF_PRICE</code>
	 */
	public static String updateShelfPrice(Configuration configuration, Integer storeId, Integer productId, BigDecimal price) {
		UpdateShelfPrice f = new UpdateShelfPrice();
		f.setStoreId(storeId);
		f.setProductId(productId);
		f.setPrice(price);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get <code>insightaction.UPDATE_SHELF_PRICE</code> as a field
	 */
	public static Field<String> updateShelfPrice(Integer storeId, Integer productId, BigDecimal price) {
		UpdateShelfPrice f = new UpdateShelfPrice();
		f.setStoreId(storeId);
		f.setProductId(productId);
		f.setPrice(price);

		return f.asField();
	}

	/**
	 * Get <code>insightaction.UPDATE_SHELF_PRICE</code> as a field
	 */
	public static Field<String> updateShelfPrice(Field<Integer> storeId, Field<Integer> productId, Field<BigDecimal> price) {
		UpdateShelfPrice f = new UpdateShelfPrice();
		f.setStoreId(storeId);
		f.setProductId(productId);
		f.setPrice(price);

		return f.asField();
	}
}
