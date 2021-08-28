package ru.gb.current.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.prev.Order;
import ru.gb.prev.OrderRepository;
import ru.gb.prev.Product;
import ru.gb.prev.ProductRepository;

import java.util.Arrays;

@Controller
public class OrderController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public OrderController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String getAddProductForm(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "orders-add";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String addProduct (@RequestParam("id") int id,
                              @RequestParam("products") int[] productIds) {
        Order order = new Order(id);
        System.out.println(Arrays.toString(productIds));
        for (int productId : productIds) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                order.addProduct(product);
            }
        }
        order.countOrderCost();
        orderRepository.add(order);
        return "redirect:/orders";
    }

}
