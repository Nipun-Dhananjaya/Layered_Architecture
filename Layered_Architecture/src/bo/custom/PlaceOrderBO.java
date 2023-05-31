package bo.custom;

import bo.SuperBO;
import model.OrderDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
