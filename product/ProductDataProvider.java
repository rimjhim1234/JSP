package Com.LoginCt.product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class ProductDataProvider {
    @Autowired
    ProjectApiRoot projectApiRoot;

    public ProductType createproducttype(ProductTypeDraft productTypeDraft) {
        return projectApiRoot.productTypes().post(productTypeDraft).executeBlocking().getBody();
    }
    public ProductPagedQueryResponse getallproduct() {
        return projectApiRoot.products().get().executeBlocking().getBody();
    }
}
