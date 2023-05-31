package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(T dto) throws SQLException, ClassNotFoundException ;

    public boolean update(T dto) throws SQLException, ClassNotFoundException ;

    public boolean delete(ID id) throws SQLException, ClassNotFoundException ;

    public boolean exist(ID id) throws SQLException, ClassNotFoundException ;

    public ID newIdGenerate() throws SQLException, ClassNotFoundException ;

    public T find(ID id) throws SQLException, ClassNotFoundException ;
}
