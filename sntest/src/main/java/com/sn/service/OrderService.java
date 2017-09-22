package com.sn.service;
import com.sn.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> getList(int userId);

    Order findByIdAndUserId(int oId,int userId);

    int delete(int oId);
}
