package dao.Impl;

import dao.OrderDAO;
import db.DBConnection;
import model.OrderDTO;
import util.CrudUtil;

import java.sql.*;

public class OrderDAOImpl implements OrderDAO {
    public String generateOID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();
    }

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(), Date.valueOf(dto.getOrderDate()),dto.getCustomerId());
    }
}
