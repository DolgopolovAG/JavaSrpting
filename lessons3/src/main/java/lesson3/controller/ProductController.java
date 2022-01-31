package lesson3.controller;

import lesson3.entity.Product;
import lesson3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // форма создания продукта /product/edit/{id}
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String showForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    // обработка формы создания и редактирования
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        if (product.getId() == null) {
            productService.save(product);
        } else {
            productService.edit(product);
        }
        return "redirect:/product/all";
    }

    // показать один элемент
    @RequestMapping(path = "/{id}", method = RequestMethod.GET) //http://localhost:8080/spring/product/{id}
    public String getProductById(Model model,
                                 @PathVariable Integer id) {
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "product";
    }

    // показать все элементы
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    // удалить элемент /product/delete/{id}
    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id) {
        Product pr = productService.findById(id);
        model.addAttribute("product",pr);
        return "create-product";
    }


  /*  @RequestMapping
    private String printAll(Model model) {
        model.addAttribute("allInfo","текст");
        return "product";
    }



    @ModelAttribute("info")
    public String printInfo() {
        return "info";
    }

     @RequestMapping(path = "/{id}", method = RequestMethod.GET) //http://localhost:8080/spring/product/{id}?all=true
    public String getProductById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "all", defaultValue = "false", required = false) Boolean isAll) {
        Product product;
        if(isAll) {

        } else {

        }
        model.addAttribute("product", product);
    }
*/

}
