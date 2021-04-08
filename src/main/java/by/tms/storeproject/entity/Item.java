package by.tms.storeproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Component
@AllArgsConstructor @NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private String itemName;
    private String itemDesc;
    private float itemPrice;

    private String picLink;

//    @ElementCollection
//    @LazyCollection(value = LazyCollectionOption.FALSE)
//    private List<ItemCategory> itemCategoryList;

}
