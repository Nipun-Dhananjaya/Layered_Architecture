package bo;


import bo.custom.Impl.CustomerBOImpl;
import bo.custom.Impl.ItemBOImpl;
import bo.custom.Impl.OrderBOImpl;
import bo.custom.Impl.PlaceOrderBOImpl;

public class BOFactory {
    private BOFactory(){}
    private static BOFactory boFactory;

    public static BOFactory getBoFactory() {
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,ORDER,PLACE_ORDER
    }
    public static SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:return new CustomerBOImpl();
            case ITEM:return new ItemBOImpl();
            case ORDER:return new OrderBOImpl();
            case PLACE_ORDER:return new PlaceOrderBOImpl();
            default: return null;
        }
    }
}
