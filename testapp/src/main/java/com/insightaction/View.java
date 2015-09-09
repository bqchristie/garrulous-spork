package com.insightaction;

import com.insightaction.db.tables.pojos.StoreDataView;

import java.util.List;

/**
 * Created by brucechristie on 15-09-03.
 */
public class View {
    List products;
    List stores;
    private List<StoreDataView> storeData;

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public List getStores() {
        return stores;
    }

    public void setStores(List stores) {
        this.stores = stores;
    }

    public void setStoreData(List<StoreDataView> storeData) {
        this.storeData = storeData;
    }

    public List<StoreDataView> getStoreData() {
        return storeData;
    }
}
