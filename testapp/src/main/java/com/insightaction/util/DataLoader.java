package com.insightaction.util;

import static com.insightaction.db.Tables.*;


import com.insightaction.db.tables.records.*;
import org.apache.commons.lang3.ArrayUtils;
import org.jooq.impl.DSL;
import org.jooq.*;
import org.jooq.tools.csv.CSVReader;


import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by brucechristie on 15-09-02.
 */
public class DataLoader {
    private static final String PENDING = "PENDING";
    public static final String DATA_STORES_CSV = "stores.csv";
    public static final String DATA_PRODUCTS_CSV = "products.csv";
    public static final String DATA_DATA_CSV = "data.csv";




    public static void main(String[] args) throws Exception{
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/insightaction";

        Connection conn = DriverManager.getConnection(url, userName, password);
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

        truncateData(create);
        loadToStaging(create);
        mapStoreData(create);
        mapProductData(create);
        mapStoreProductData(create);

    }

    private static void truncateData(DSLContext create) {
//        create.truncate(STORE_PRODUCT_DATA).execute();
//        create.truncate(STORE).execute();
//        create.truncate(PRODUCT).execute();
//        create.truncate(VENDOR).execute();
//        create.truncate(PRODUCT_CLASS_TYPE).execute();
//        create.truncate(CSV_IMPORT);
    }
/*
A Year,
B Period,
C StoreLicenseeName,
D StoreLicenseeNo,
E ProductName,
F Bottles,
G CasesActual,
H CasesStandard,
I Cases9Liter,
J RetailDollarVol,
K ShelfDollarVol,
L FOBDollarVol
 */

    private static void mapStoreProductData(DSLContext create) {
        Result<CsvImportRecord> csvData = create.selectFrom(CSV_IMPORT).where(CSV_IMPORT.FILENAME.eq(DATA_DATA_CSV)).fetch();

        for (CsvImportRecord r : csvData) {
            try {
                StoreProductDataRecord record = create.newRecord(STORE_PRODUCT_DATA);
                record.setCreatedate(getCurrentTimestamp());
                record.setBottles(Integer.valueOf(r.getF()));
                record.setCases9liter(getBigDecimal(r.getI()));
                record.setCasesactual(getBigDecimal(r.getG()));
                record.setCasesstandard(getBigDecimal(r.getH()));
                record.setFobdollarvol(getBigDecimal(r.getL()));
                record.setPeriod(Integer.valueOf(r.getB()));
                record.setYear(Integer.valueOf(r.getA()));
                record.setProductId(getProductId(create, r));
                record.setRetaildollarvol(getBigDecimal(r.getJ()));
                record.setShelfdollarvol(getBigDecimal(r.getK()));
                record.setStoreId(getStoreId(create, r));
                record.store();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static BigDecimal getBigDecimal(String value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        BigDecimal bigDecimal = null;
        try {
            bigDecimal = (BigDecimal) decimalFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bigDecimal;
    }

    private static Integer getStoreId(DSLContext create, CsvImportRecord r) {
        Result<StoreRecord> storeDta = create.selectFrom(STORE).where(STORE.STORELICENSEENO.eq(r.getD())).fetch();

        if(storeDta.isNotEmpty() ) {
            System.out.println("STORE:" + storeDta.get(0).getId());
            return storeDta.get(0).getId();
        }
        else {
            throw new RuntimeException("Unknown Strie!!!" + r.getD());
        }
    }


    private static Integer getProductId(DSLContext create, CsvImportRecord r) {
        Result<ProductRecord> productDta = create.selectFrom(PRODUCT).where(PRODUCT.PRODUCTNAME.eq(r.getE())).fetch();

        if(productDta.isNotEmpty() ) {
            System.out.println("PRODUCT:" + productDta.get(0).getId());
            return productDta.get(0).getId();
        }
        else {
            ProductRecord product = create.newRecord(PRODUCT);
            product.setCreatedate(getCurrentTimestamp());
            product.setProductname(r.getE());
            product.store();
            System.out.println("Creating product!" + r.getE());
            return product.getId();

        }
    }

    private static void mapProductData(DSLContext create) {
        Result<CsvImportRecord> csvData = create.selectFrom(CSV_IMPORT).where(CSV_IMPORT.FILENAME.eq(DATA_PRODUCTS_CSV)).groupBy(CSV_IMPORT.D, CSV_IMPORT.F).fetch();
        for (CsvImportRecord r : csvData) {
            ProductRecord product = create.newRecord(PRODUCT);
            product.setBeveragetype(r.getE());
            product.setBottles(r.getQ());
            product.setBrand(r.getK());
            product.setClassid(r.getH());




            product.setCommoncode(r.getD());
            product.setCommoncodename(r.getL());
            product.setCommoncodeno(r.getM());


            product.setCreatedate(getCurrentTimestamp());
            product.setListedNonlisted(r.getN());
            product.setPacksize(r.getF());
            product.setPacksizeind(r.getP());
            product.setProductname(r.getA());
            product.setSize(r.getF());

            /* Add foreign keys */
            product.setVendorId(getVendorId(create, r));
            product.setProductClassTypeId(getProductClassTypeId(create, r));

            product.store();

            /* Update the CSV record */
            r.setStatus("PROCESSED");
            r.setProcessdate(getCurrentTimestamp());
            r.store();
        }
    }

    private static Integer getVendorId(DSLContext create, CsvImportRecord r) {
        Result<VendorRecord> vendorDta = create.selectFrom(VENDOR).where(VENDOR.VENDORNUMBER.eq(r.getG())).fetch();

        if(vendorDta.isNotEmpty() ) {
            return vendorDta.get(0).getId();
        }
        else {
            VendorRecord vendor = create.newRecord(VENDOR);
            vendor.setCreatedate(getCurrentTimestamp());
            vendor.setVendor(r.getB());
            vendor.setVendornumber(r.getG());
            vendor.store();
            return vendor.getId();
        }
    }

    private static Integer getProductClassTypeId(DSLContext create, CsvImportRecord r) {

        Result<ProductClassTypeRecord> productClassDta = create.selectFrom(PRODUCT_CLASS_TYPE).where(PRODUCT_CLASS_TYPE.CLASSTYPENO.eq(r.getI())).fetch();

        if(productClassDta.isNotEmpty() ) {
            return productClassDta.get(0).getId();
        }
        else {
            ProductClassTypeRecord productClassType = create.newRecord(PRODUCT_CLASS_TYPE);
            productClassType.setCreatedate(getCurrentTimestamp());
            productClassType.setClasstype(r.getC());
            productClassType.setClasstypename(r.getI());
            productClassType.setClasstypeno(r.getJ());
            productClassType.store();
            return productClassType.getId();
        }
    }

    private static void mapStoreData(DSLContext create) {
        Result<CsvImportRecord> csvData = create.selectFrom(CSV_IMPORT).where(CSV_IMPORT.FILENAME.eq(DATA_STORES_CSV)).fetch();

        for (CsvImportRecord r : csvData) {
            StoreRecord store = create.newRecord(STORE);
            store.setAddress1(r.getF());
            store.setCity(r.getG());
            store.setCreatedate(getCurrentTimestamp());
            store.setState(r.getB());
            store.setStorelicenseeind(r.getC());
            store.setStorelicenseename(r.getA());
            store.setStorelicenseeno(r.getE());
            store.setZip(r.getD());
            store.store();

            /* Update the CSV record */
            r.setStatus("PROCESSED");
            r.setProcessdate(getCurrentTimestamp());
            r.store();
        }
    }

    private static void loadToStaging(DSLContext create) throws IOException {
        File dir = new File("data");
        Collection<String> files = Arrays.asList(dir.list());

        for(String file: files) {
            System.out.println(file);
            CSVReader reader = new CSVReader(new FileReader("data/"  + file));

            String[] nextLine;

            while((nextLine = reader.readNext())!=null) {
                /* Prevent index out of bounds */
                nextLine  = ArrayUtils.addAll(nextLine, new String[20]);
                CsvImportRecord record = create.newRecord(CSV_IMPORT);
                record.setFilename(file);
                record.setStatus(PENDING);
                record.setImportdate(getCurrentTimestamp());
                record.setA(nextLine[0]);
                record.setB(nextLine[1]);
                record.setC(nextLine[2]);
                record.setD(nextLine[3]);
                record.setE(nextLine[4]);
                record.setF(nextLine[5]);
                record.setG(nextLine[6]);
                record.setH(nextLine[7]);
                record.setI(nextLine[8]);
                record.setJ(nextLine[8]);
                record.setK(nextLine[10]);
                record.setL(nextLine[11]);
                record.setM(nextLine[12]);
                record.setN(nextLine[13]);
                record.setO(nextLine[14]);
                record.setP(nextLine[15]);
                record.setQ(nextLine[16]);
                record.setR(nextLine[17]);
                record.setS(nextLine[18]);
                record.setT(nextLine[19]);
                record.store();
            }
        }
    }


    public static Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

}
