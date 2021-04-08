package by.tms.storeproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String mobilePhone;
    private String name;

    @ElementCollection
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<UserRole> userRoles;

}
