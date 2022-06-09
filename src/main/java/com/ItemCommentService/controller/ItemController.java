package com.ItemCommentService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ItemCommentService.entity.Item;
import com.ItemCommentService.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	ItemService itemService;

	@PostMapping("add/{id}")
	public Item add(@PathVariable(value = "id") Long userid, @RequestBody Item it){
		return itemService.addItem(userid,it).get();
	}

	@GetMapping("{id}")
	public Optional<Item> getItemById(@PathVariable(value = "id") long id){
		return itemService.getByItemId(id);
	}

	@PutMapping("/{itemId}")
	public Optional<Item> updateItem(@PathVariable(value = "itemId") Long itemId,@RequestBody Item item){
		itemService.updateItem(itemId,item);
		return itemService.getByItemId(itemId);
	}


	@GetMapping("allItems/{id}")
	public List<Item> getAllItems(@PathVariable(value = "id")Long id){
		return itemService.getAll(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable(value = "id")Long id){
		itemService.deleteItem(id);
	}

}
