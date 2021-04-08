package by.tms.storeproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserRegModel {
    private String username;
    private String password;
    private String mobilePhone;
    private String name;
}
