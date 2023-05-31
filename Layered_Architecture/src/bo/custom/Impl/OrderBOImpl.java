package bo.custom.Impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.OrderDAO;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public String newIdGenerate() throws SQLException, ClassNotFoundException {
        return orderDAO.newIdGenerate();
    }
}
