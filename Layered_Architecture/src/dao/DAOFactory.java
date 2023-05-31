package dao;

import dao.custom.Impl.*;

public class DAOFactory {
    private DAOFactory(){}
    private static DAOFactory daoFactory;

    public static DAOFactory getDaoFactory() {
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY_DAO
    }
    public static SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:return new CustomerDAoImpl();
            case ITEM:return new ItemDAOImpl();
            case ORDER:return new OrderDAOImpl();
            case ORDER_DETAIL:return new OrderDetailsDAOImpl();
            case QUERY_DAO:return new QuaryDAOImpl();
            default: return null;
        }
    }
}
