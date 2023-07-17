package Com.LoginCt.Customer;

import Com.LoginCt.product.ProductData;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.CustomerSignInResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@org.springframework.stereotype.Controller
@Validated

public class MainController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProjectApiRoot projectApiRoot;
    @GetMapping("/Form")
    public  String signUp(Model model)
    {
        CustomerDto user = new CustomerDto();
        model.addAttribute("user", user);
        return "SignUp";
    }

@GetMapping("/product")
    public  String Product(Model model)
    {
        ProductData user = new ProductData();
        model.addAttribute("user", user);
        return "Product";
    }

    @PostMapping("/Sign-Up")
     public   String createCustomer(CustomerDto customerDto ){
        customerService.createCustomer(customerDto);
            return "Success";
    }

    @PostMapping("/Login-SignIn")
    public CustomerSignInResult login(CustomerDto customerDto)
    {
        return customerService.login(customerDto);
    }

}



