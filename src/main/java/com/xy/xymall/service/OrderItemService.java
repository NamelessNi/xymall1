package com.xy.xymall.service;

import com.xy.xymall.dao.OrderItemDAO;
import com.xy.xymall.entity.Order;
import com.xy.xymall.entity.OrderItem;
import com.xy.xymall.entity.Product;
import com.xy.xymall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ProductImageService productImageService;

    public void fill(List<Order> orders) {
        for (Order order : orders)
            fill(order);
    }

    public void fill(Order order) {
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
            productImageService.setFirstProdutImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }

    public List<OrderItem> listByOrder(Order order) {

        return orderItemDAO.findByOrderOrderByIdDesc(order);
    }
    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }
    public void update(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }
    public void add(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }
    public OrderItem get(int id) {
        return orderItemDAO.findOne(id);
    }

    public void delete(int id) {
        orderItemDAO.delete(id);
    }

    public int getSaleCount(Product product) {
        List<OrderItem> ois =listByProduct(product);
        int result =0;
        for (OrderItem oi : ois) {
            if(null!=oi.getOrder())
                if(null!= oi.getOrder() && null!=oi.getOrder().getPayDate())
                    result+=oi.getNumber();
        }
        return result;
    }

    public List<OrderItem> listByUser(User user) {
        return orderItemDAO.findByUserAndOrderIsNull(user);
    }
}
