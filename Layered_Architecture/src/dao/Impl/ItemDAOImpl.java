package dao.Impl;

import dao.ItemDAO;
import db.DBConnection;
import model.ItemDTO;
import util.CrudUtil;
import view.tdm.ItemTM;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> itms=new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item");
        while (rst.next()){
            itms.add(
                    new ItemDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getInt(3),
                            rst.getBigDecimal(4)
                    )
            );
        }
        return itms;
    }
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);

        return CrudUtil.execute("DELETE FROM Item WHERE code=?",code);
    }
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getQtyOnHand(),itemDTO.getUnitPrice());
    }
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(), itemDTO.getQtyOnHand(), itemDTO.getUnitPrice(), itemDTO.getCode());
    }
    public boolean existItems(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT code FROM Item WHERE code=?",code);
    }
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE code=?",code);
        rst.next();
        return new ItemDTO(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getBigDecimal(4));
    }

}
