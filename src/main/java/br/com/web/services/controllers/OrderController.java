package br.com.web.services.controllers;

import br.com.web.services.entities.Order;
import br.com.web.services.services.OrderService;
import br.com.web.services.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class OrderController {

   private final UserService userService;
   private final OrderService orderService;

   public OrderController(UserService userService, OrderService orderService){
       this.userService = userService;
       this.orderService = orderService;
   }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable("id") Long id){
        Optional<Order> order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
