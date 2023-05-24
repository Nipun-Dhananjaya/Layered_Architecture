package dao.Impl;

import dao.OrderDetailsDAO;
import db.DBConnection;
import model.OrderDetailDTO;
import util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getUnitPrice(),dto.getQty());
    }
}
