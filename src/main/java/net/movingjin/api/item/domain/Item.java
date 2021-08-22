package net.movingjin.api.item.domain;

import lombok.Builder;
import lombok.Data;
import net.movingjin.api.order.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "model_no")
    private String modelNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_color")
    private String itemColor;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "sold_out")
    private Boolean soldOut;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();

    @Builder    //필요한것만 골라서 생성자 생성
    public Item(String itemBrand, String itemName, String itemColor){
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemColor = itemColor;
    }

    public Item() {

    }

    @Override
    public String toString(){
        return String.format("아이템 스펙: %s, %s, %s", itemBrand, itemName, itemColor);
    }
}
