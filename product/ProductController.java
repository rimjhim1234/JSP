package Com.LoginCt.product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProjectApiRoot apiRoot;

    @PostMapping("/product")
    public String createproducttype(@RequestBody ProductData productData) {
        ProductService.createproducttype(productData);
        return "Success";
    }
    @GetMapping("/getallProduct")
    public String getallproduct(Model model) {
        List<Product> response = apiRoot.products().get().withLimit(50).executeBlocking().getBody().getResults();
        model.addAttribute("product", response);
//       return   productService.getallproduct();
        return "Product";
    }


}

