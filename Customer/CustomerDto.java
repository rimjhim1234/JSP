package Com.LoginCt.Customer;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerDto{

    @NotNull
    @Email(message = "Invalid")
    private String email;

    @NotNull
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private String externalId;
    @NotNull
    private  String customerNumber;


}
