package edu.icet.service;

import edu.icet.model.dto.Item;
import edu.icet.model.entity.ItemEntity;
import edu.icet.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllDetails() {
        List<ItemEntity> allEntities = itemRepository.findAll();
        List<Item> itemList = new ArrayList<>();

        for (ItemEntity entity : allEntities) {
            itemList.add(new Item(
                    entity.getCode(),
                    entity.getDescription(),
                    entity.getUnitPrice(),
                    entity.getQty()
            ));
        }
        return itemList;
    }

    public void add(Item item) {
        ItemEntity entity = new ItemEntity(
                item.getCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQty()
        );
        itemRepository.save(entity);
    }
}
