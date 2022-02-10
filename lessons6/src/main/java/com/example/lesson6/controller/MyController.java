package com.example.lesson6.controller;

//import com.example.lesson4_boot.config.ProductProps;
import com.example.lesson6.model.Product;
import com.example.lesson6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class MyController {

    //private final ProductProps productProps;

    private final ProductService productService;

    // форма создания продукта /product/edit/{id}
    @GetMapping(path = "/create")
    public String showForm(Model model){
        System.out.println("create");
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    // обработка формы создания и редактирования
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        System.out.println("create Post");
        if (product.getId() == null) {
            productService.save(product);
        } else {
            productService.edit(product);
        }
        return "redirect:/product/all";
    }

    // показать один элемент
    @GetMapping(path = "/{id}") //http://localhost:8080/product/{id}
    public String getProductById(Model model,
                                 @PathVariable Integer id) {
        System.out.println("getProductById");
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "product";
    }

    // показать все элементы
    @GetMapping(path = "/all")
    public String getAllProduct(Model model){
        System.out.println("all");
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    // удалить элемент /product/delete/{id}
    @GetMapping(path = "/delete")
    public String deleteById(@RequestParam Integer id) {
        System.out.println("delete");
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping(path = "/edit")
    public String editById(Model model, @RequestParam Integer id) {
        System.out.println("edit");
        Product pr = productService.findById(id);
        model.addAttribute("product",pr);
        return "create-product";
    }

/*    @ResponseBody
    @GetMapping
    public String helloMess() {
        return  "Hello";
    }
*/
   @GetMapping("/hello")
    public String helloMess1(Model model) {
        throw new RuntimeException("rqfff " );
       // model.addAttribute("msg", "Hello M " + productProps.getProducts().size());
        //return "product";
    }

    @GetMapping("/hello_new")
    public String helloMess(Model model) {
        model.addAttribute("msg", "Hello M ");
        return "product";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRuntimeExc(RuntimeException e) {
        return  "Error!!!: " + e.getMessage();
    }

}
