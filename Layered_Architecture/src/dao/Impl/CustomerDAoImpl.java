package dao.Impl;

import dao.CustomerDAO;
import db.DBConnection;
import model.CustomerDTO;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAoImpl implements CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allcustomers=new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");

        while(rst.next()){
            CustomerDTO customerDTO=new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
            allcustomers.add(customerDTO);
        }
        return allcustomers;
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet= CrudUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return resultSet.next();
    }

    public String newIdGenerate() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO findCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id+ "");
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }
}
