package net.movingjin.api.item.controller;

import lombok.RequiredArgsConstructor;
import net.movingjin.api.item.domain.Item;
import net.movingjin.api.item.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/{id}")
    public Optional<Item> findItem(@PathVariable long id){
        return itemService.findById(id);
    }

    @GetMapping
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping("/exists")
    public boolean verify(long id){
        return itemService.existsById(id);
    }

    @GetMapping("/count")
    public int size(){
        return itemService.count();
    }

    @PostMapping
    public void save(@RequestBody Item item){
        itemService.save(item);
    }

    @PutMapping
    public void update(@RequestBody Item item){
        itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        itemService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        itemService.deleteAll();
    }
}
