package com.example.lesson7.controller;

import com.example.lesson7.entity.Product;
import com.example.lesson7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class MyController {

    private final ProductService productService;

    // форма создания продукта /product/edit/{id}
    @GetMapping(path = "/create")
    public String showForm(Model model){
        System.out.println("create");
        Product product = new Product();
        product.setManuf_Id(1L);
        model.addAttribute("product", product);
        return "create-product";
    }

    // обработка формы создания и редактирования
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        System.out.println("create Post");
        if (product.getId() == null) {
            productService.edit(product);
        } else {
            productService.save(product);
        }
        return "redirect:/product/all";
    }

    // показать один элемент
    @GetMapping(path = "/{id}") //http://localhost:8080/product/{id}
    public String getProductById(Model model,
                                 @PathVariable Long id) {
        System.out.println("getProductById");
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "product";
    }

    // показать все элементы @RequestParam(name = "direction", defaultValue = "desc", required = false)
    @GetMapping(path = "/all")
    public String getAllProduct(Model model,
                                @RequestParam(name = "direction", required = false) String direction){
        System.out.println("all "+ direction.toUpperCase());
        Sort sort = (direction.toUpperCase().equals("DESC") ?Sort.by(Sort.Direction.DESC,"id")
                        :(direction.toUpperCase().equals("ASC") ?Sort.by(Sort.Direction.ASC,"id")
                                :null));
        List<Product> all = productService.findAll(sort);
        model.addAttribute("products", all);

        return "product-list";
    }

    // удалить элемент /product/delete/{id}
    @GetMapping(path = "/delete")
    public String deleteById(@RequestParam Long id) {
        System.out.println("delete");
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping(path = "/edit")
    public String editById(Model model, @RequestParam Long id) {
        System.out.println("edit");
        Product pr = productService.findById(id);
        model.addAttribute("product",pr);
        return "create-product";
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRuntimeExc(RuntimeException e) {
        return  "Error!!! message: " + e.getMessage() + "\\r\\n" + e.getStackTrace();
    }

    // @PathVariable Integer id)
}
