package com.sn.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.sn.entity.Order;

import java.util.List;

@Repository
public interface OrderMapper {
    void save(Order order);

    List<Order> getList(@Param("userId") int userId);

    Order findByIdAndUserId(@Param("oId") int oId,@Param("userId") int userId);

    int delete(@Param("oId") int oId);
}
