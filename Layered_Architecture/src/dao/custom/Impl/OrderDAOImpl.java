package dao.custom.Impl;

import dao.custom.OrderDAO;
import entity.Order;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(), Date.valueOf(dto.getOrderDate()),dto.getCustomerId());
    }

    @Override
    public boolean update(Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String orderId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();
    }

    @Override
    public String newIdGenerate() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public Order find(String orderId) throws SQLException, ClassNotFoundException {
        return null;
    }
}
