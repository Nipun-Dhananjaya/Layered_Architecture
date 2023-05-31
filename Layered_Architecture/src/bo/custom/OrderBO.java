package bo.custom;

import bo.SuperBO;
import model.OrderDTO;

import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    String newIdGenerate() throws SQLException, ClassNotFoundException;
}
