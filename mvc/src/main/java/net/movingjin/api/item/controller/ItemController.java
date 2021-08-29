package net.movingjin.api.item.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import net.movingjin.api.item.domain.Item;
import net.movingjin.api.item.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowCredentials = "false")
//요즘엔 백과 프론트서버를 물리적으로 나누므로 CORS 설정이 필요함
@Api(tags = "items")
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/connect")
    public String connect(){
        return "success";
    }

    @GetMapping
    public Item findItem(@RequestParam("itemBrand") String itemBrand,
                         @RequestParam("itemName") String itemName,
                         @RequestParam("itemColor") String itemColor){
        return new Item(itemBrand, itemName, itemColor);
    }

    //@GetMapping
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
