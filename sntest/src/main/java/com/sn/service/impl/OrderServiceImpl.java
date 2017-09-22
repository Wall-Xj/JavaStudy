package com.sn.service.impl;

import com.sn.entity.Order;
import com.sn.mapper.OrderMapper;
import com.sn.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public void save(Order order) {
        orderMapper.save(order);
    }

    @Override
    public List<Order> getList(int userId) {
        return orderMapper.getList(userId);
    }

    @Override
    public Order findByIdAndUserId(int oId, int userId) {
        return orderMapper.findByIdAndUserId(oId,userId);
    }

    @Override
    public int delete(int oId) {
        return orderMapper.delete(oId);
    }
}
