package dao.Impl;

import dao.CrudDAO;
import model.ItemDTO;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements CrudDAO<ItemDTO,String> {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice(), dto.getCode());
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT code FROM Item WHERE code=?",code);
    }

    @Override
    public String newIdGenerate() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE code=?",code);
        rst.next();
        return new ItemDTO(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getBigDecimal(4));
    }
}
