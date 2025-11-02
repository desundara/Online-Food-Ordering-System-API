package edu.icet.controller;

import edu.icet.model.dto.Item;
import edu.icet.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllDetails();
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.add(item);
    }

    @PutMapping
    public void updateItem(@RequestBody Item item) {
        itemService.update(item);
    }

    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable("code") String code) {
        itemService.delete(code);
    }
}
