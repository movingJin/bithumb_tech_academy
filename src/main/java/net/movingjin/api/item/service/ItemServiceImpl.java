package net.movingjin.api.item.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.movingjin.api.item.domain.Item;
import net.movingjin.api.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;    //연관관계(부모)
    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(long id) {
        return itemRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return itemRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int)itemRepository.count();
    }

    @Override
    public void save(Item entity) {
        itemRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
