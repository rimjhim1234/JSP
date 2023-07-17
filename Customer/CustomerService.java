package Com.LoginCt.Customer;

import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.commercetools.api.models.customer.CustomerSignin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer createCustomer(CustomerDto customerDto) {
        CustomerDraft customerDraft =  CustomerDraft
                .builder()
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .lastName(customerDto.getLastName())
                .firstName(customerDto.getFirstName())
                .customerNumber(customerDto.getCustomerNumber())
                .externalId(customerDto.getExternalId())
                .build();
        return customerRepository.createCustomer(customerDraft);
    }
    public CustomerSignInResult login(CustomerDto customerDto) {
        CustomerSignin customerSignin = CustomerSignin
                .builder()
                .build();
        return customerRepository.login(customerSignin);
    }
}
