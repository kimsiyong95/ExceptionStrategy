package ksy.errorproj.service;


import ksy.errorproj.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getAllOrders(){
        List<Order> list = new ArrayList<>();

        list.add(new Order("1", "ksy"));
        list.add(new Order("2", "ksy"));

        return list;
    }

    public Order findByOrderId(String orderId){
        Order order = new Order("1", "ksy");
        return order;
    }

    public void insert(){

    }

    public void update(String orderId){

    }

    public void delete(){

    }
}
