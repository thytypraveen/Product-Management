package com.ItemCommentService.service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ItemCommentService.entity.Item;
import com.ItemCommentService.entity.User;
import com.ItemCommentService.repository.ItemRepository;
import com.ItemCommentService.repository.UserRepository;

import ItemcommentService.exception.ResourceNotFoundException;
@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;


	public Optional<Item> addItem(Long id, Item item) {
		return Optional.ofNullable(userRepository.findById(id).map(user -> {
			item.setUser(user);
			return itemRepository.save(item);
		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + id + " Not Found")));
	}

	public Item updateItem(Long id, Item item1){
		Item item = findItem(id);
		item.setTitle(item1.getTitle());
		item.setDescription(item1.getDescription());
		itemRepository.save(item);
		return  findItem(id);
	}
	public Item findItem(Long id){
		return itemRepository.findById(id).get();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemById(Long id) {
		List<Item> l1 = getAll(id);
		Set<Item> sortedList = l1.stream().sorted().collect(Collectors.toSet());
		List<Item> sortedList1 = (List<Item>) l1.stream()
		        .sorted(Comparator.comparing(Item::getTitle))
		        .collect(Collectors.toSet());
		return (List<Item>) sortedList1;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAll(Long id){
		User u =  userRepository.findById(id).get();
		return (List<Item>) itemRepository.findAll().stream().filter(item -> item.getUser().equals(u)).collect(Collectors.toSet());
	}

	public Optional<Item> getByItemId(long id) {
		return Optional.ofNullable(itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserId" + id + "Not Found")));
	}

	public void deleteItem(Long id){

		itemRepository.deleteById(id);
	}

}
