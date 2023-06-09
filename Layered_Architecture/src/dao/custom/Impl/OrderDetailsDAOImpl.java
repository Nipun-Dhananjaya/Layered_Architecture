package dao.custom.Impl;

import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getUnitPrice(),dto.getQty());
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String newIdGenerate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
