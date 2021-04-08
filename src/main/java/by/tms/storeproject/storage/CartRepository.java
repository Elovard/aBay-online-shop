package by.tms.storeproject.storage;

import by.tms.storeproject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Item, Long> {
}
