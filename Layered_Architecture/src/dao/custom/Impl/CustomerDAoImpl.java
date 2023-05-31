package dao.custom.Impl;

import dao.custom.CustomerDAO;
import entity.Customer;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAoImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allcustomers=new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");

        while(rst.next()){
            Customer customer=new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
            allcustomers.add(customer);
        }
        return allcustomers;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet= CrudUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return resultSet.next();
    }

    @Override
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

    @Override
    public Customer find(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id+ "");
        rst.next();
        return new Customer(id + "", rst.getString("name"), rst.getString("address"));
    }
}
