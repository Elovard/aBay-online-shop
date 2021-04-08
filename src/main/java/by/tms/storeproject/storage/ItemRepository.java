package by.tms.storeproject.storage;

import by.tms.storeproject.entity.Item;
import by.tms.storeproject.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
//    public Item findItemByItemCategoryList(ItemCategory itemCategory);
    public Item findItemByItemName(String itemName);
    public Item findItemByItemId(long itemId);

}
