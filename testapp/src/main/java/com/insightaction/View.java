package com.insightaction;

import com.insightaction.db.tables.pojos.Product;
import com.insightaction.db.tables.pojos.Store;
import com.insightaction.db.tables.pojos.StoreProductData;

import java.util.List;

/**
 * Created by brucechristie on 15-09-03.
 */
public class View {
   List data;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
