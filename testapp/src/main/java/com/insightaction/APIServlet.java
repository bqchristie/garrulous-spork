package com.insightaction;

import com.google.gson.Gson;
import com.insightaction.db.Tables;
import com.insightaction.db.tables.pojos.Product;
import com.insightaction.db.tables.pojos.Store;
import com.insightaction.db.tables.pojos.StoreProductData;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by brucechristie on 15-09-03.
 */
public class APIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIServlet() {
        super();
        // TODO Auto-generated constructor stub
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

        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/insightaction";

        Connection conn = DriverManager.getConnection(url, userName, password);
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

        View view = new View();

        List<Product> products = create.select().from(Tables.PRODUCT).fetchInto(Product.class);
        List<Store> stores  = create.select().from(Tables.STORE).fetchInto(Store.class);

        view.setData(products);
        Gson gson = new Gson();

        return gson.toJson(view);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    public static void main(String args[]) {
        APIServlet m = new APIServlet();

        try {
            m.getData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}