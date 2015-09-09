package com.insightaction;

import com.google.gson.Gson;
import com.insightaction.db.Tables;
import com.insightaction.db.routines.UpdateShelfPrice;
import com.insightaction.db.tables.pojos.StoreDataView;
import com.insightaction.db.tables.pojos.Product;
import com.insightaction.db.tables.pojos.Store;
import com.insightaction.db.tables.pojos.StoreProductData;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brucechristie on 15-09-03.
 */
public class APIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map data = new HashMap();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIServlet() {
        super();

    }


    public void init(ServletConfig config) throws ServletException {
        String userName = config.getInitParameter("dbuser");
        String password = config.getInitParameter("dbpasssword");
        String url = config.getInitParameter("dburl");

        try {
            initData(userName,password,url);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }


    }

    private void initData(String username, String password, String url) throws SQLException {

        Connection conn = DriverManager.getConnection(url, username, password);
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        List<Product> products = create.select().from(Tables.PRODUCT).fetchInto(Product.class);
        List<Store> stores  = create.select().from(Tables.STORE).fetchInto(Store.class);
        List<StoreDataView> storeDataView  = create.select().from(Tables.STORE_DATA_VIEW).fetchInto(StoreDataView.class);

        View view = new View();
        view.setProducts(products);
        view.setStores(stores);
        view.setStoreData(storeDataView);
        data.put("data",view);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = null;
        try {
            json = getData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(json);
        out.flush();
        out.close();

    }

    private String getData() throws SQLException {
        Gson gson = new Gson();
        return gson.toJson(data.get("data"));
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UpdateShelfPrice update = new UpdateShelfPrice();
        update.setPrice(getBigDecimal(request.getParameter("shelfPrice")));
        update.setProductId(Integer.valueOf(request.getParameter("storeId")));
        update.setStoreId(Integer.valueOf(request.getParameter("productId")));
        update.execute();

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.println(gson.toJson("success"));
        out.flush();
        out.close();
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

}