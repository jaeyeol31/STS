package order.service;

import order.DTO.OrderDTO;

import javax.naming.NamingException;
import java.util.ArrayList;

public interface OrderService {
    public ArrayList<OrderDTO> orderSelectAll();
    public OrderDTO orderSelect(String orderlist_num);
    public OrderDTO orderInsert(OrderDTO orderDTO);
    public OrderDTO orderUpdate(OrderDTO orderDTO);
    public OrderDTO orderDelete(String orderlist_num);

 }
