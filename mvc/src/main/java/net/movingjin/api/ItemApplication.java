package net.movingjin.api;

import net.movingjin.api.item.controller.ItemController;
import net.movingjin.api.item.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemApplication implements CommandLineRunner {
	@Autowired
	private ItemController itemController;


	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}

	@Override
	public void run(String... args)throws  Exception{
		itemController.deleteAll();
		itemController.save(new Item("삼성", "갤럭시", "흰색"));
		itemController.save(new Item("삼성", "노트", "흰색"));
		itemController.save(new Item("애플", "아이폰", "민트초코"));

		for(Item item: itemController.findAll()){
			System.out.println(item.toString());
		}
	}

}
