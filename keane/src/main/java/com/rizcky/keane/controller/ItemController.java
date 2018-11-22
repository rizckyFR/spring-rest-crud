package com.rizcky.keane.controller;

import com.rizcky.keane.model.Item;
import com.rizcky.keane.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @RequestMapping("item/getAllItems")
    @ResponseBody
    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }

    @RequestMapping("item/getItem")
    @ResponseBody
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemRepo.getItem(itemId);
    }

    @RequestMapping("item/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
                              @RequestParam("category") String category){
        if(itemRepo.addItem(id,name,category) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("item/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepo.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
