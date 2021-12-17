package com.senoJmartMH.controller;

import com.senoJmartMH.Algorithm;
import com.senoJmartMH.dbjson.JsonTable;
import com.senoJmartMH.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {


    @GetMapping("/page")
    default @ResponseBody
    List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }

//    @GetMapping("/{id}")
//    default T getById(@PathVariable int id){
//        return Algorithm.<T>find(getJsonTable(),(e) -> e.id == id);
//    }

    public abstract JsonTable<T> getJsonTable();
}
