package ru.gb.current.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.prev.Product;
import ru.gb.prev.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        // #TODO TO BE DEFINED LATER
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String getAddProductForm() {
        return "products-add";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct (@RequestParam("id") int id,
                                        @RequestParam("name") String name,
                                       @RequestParam("price") float price) {
        Product product = new Product(id, name, price);
        repository.add(product);
        return "redirect:/products";
    }

}
