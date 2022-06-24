package ksy.errorproj.controller;


import ksy.errorproj.domain.Order;
import ksy.errorproj.exception.OrderIdEmptyException;
import ksy.errorproj.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;


    @GetMapping("/orders")
    public ResponseEntity getAllOrders(){
        log.info("주문목록");
        return new ResponseEntity(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity findByOrderId(@PathVariable String orderId){
        log.info("주문상세");
        if(orderId.equals("1")){
            throw new OrderIdEmptyException("잘못된 오류");
        }
        return new ResponseEntity(orderService.findByOrderId(orderId),HttpStatus.OK);
    }

    @PostMapping("/order")
    public void insert(@Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("비어있는 값이 있습니다.");
        }

        System.out.println(order.toString());
    }

    @PutMapping("/order/{orderId}")
    public void update(@PathVariable("orderId") String orderId){

    }

    @DeleteMapping("/order")
    public void delete(){

    }
}
