package com.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.domain.Product;
import com.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
    @RequestMapping("/")
    String index(){
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
    
    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(Product product){
    	if(product.getProductId()==null || "".equals(product.getProductId())){
    		product.setProductId(UUID.randomUUID().toString());
    	}
        productService.saveProduct(product);
        //return "redirect:/product/" + product.getId();
        return "redirect:products";
    }
    
    @RequestMapping("product/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }
    
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }
    
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
