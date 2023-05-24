package dao;

import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
    public boolean existItems(String code) throws SQLException, ClassNotFoundException ;
    public String generateId() throws SQLException, ClassNotFoundException ;

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException ;
}
