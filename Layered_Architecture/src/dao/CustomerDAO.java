package dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    public String newIdGenerate() throws SQLException, ClassNotFoundException ;

    public CustomerDTO findCustomer(String id) throws SQLException, ClassNotFoundException ;
}