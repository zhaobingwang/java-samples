package com.example.demo.controller;

import com.example.demo.entity.Tmp;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.Result;
import com.example.demo.repository.TmpRepository;
import com.example.demo.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tmp")
public class TmpController {
    @Autowired
    TmpService tmpService;
    @Autowired
    private TmpRepository tmpRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Tmp> get() {
        return tmpRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable("id") int id) throws NotFoundException {
        Tmp entity = tmpService.find(id);
        return entity.getName();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tmp post(@RequestBody Tmp tmp) {
        Tmp addedEntity = tmpRepository.save(tmp);
        return addedEntity;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tmp put(@PathVariable int id, @RequestBody Tmp tmp) {
        Tmp entity = tmpRepository.getOne(id);
        entity.setName(tmp.getName());
        Tmp updatedEntity = tmpRepository.save(entity);
        return updatedEntity;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        tmpRepository.deleteById(id);
    }
}