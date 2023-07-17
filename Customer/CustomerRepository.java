package Com.LoginCt.Customer;

import com.commercetools.api.client.ProjectApiRoot;

import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerDraft;
import com.commercetools.api.models.customer.CustomerSignInResult;
import com.commercetools.api.models.customer.CustomerSignin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository {
    @Autowired
    ProjectApiRoot projectApiRoot;

    public Customer createCustomer(CustomerDraft customerDraft) {
        return projectApiRoot.customers().post(customerDraft).executeBlocking().getBody().getCustomer();
    }
    public CustomerSignInResult login(CustomerSignin customerSignin) {
        return projectApiRoot.login().post(customerSignin).executeBlocking().getBody();
    }
}
