package com.example.demo.service;

import com.example.demo.entity.Tmp;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.Result;
import com.example.demo.repository.TmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TmpService {
    @Autowired
    private TmpRepository tmpRepository;

    public Tmp find(int id) throws NotFoundException {
        Optional<Tmp> findedEntity = tmpRepository.findById(id);
        if (!findedEntity.isPresent())
            throw new NotFoundException(Result.ErrorCode.USER_NOT_FOUND.getCode(), "user " + id + "is not exist!");
        return findedEntity.get();
    }

    public List<Tmp> find() {
        return tmpRepository.findAll();
    }

    public Tmp add(Tmp entity) {
        return tmpRepository.save(entity);
    }

    public Tmp update(int id, Tmp entity) throws NotFoundException {
        Tmp findedEntity = tmpRepository.getOne(id);
        if (findedEntity == null)
            throw new NotFoundException(Result.ErrorCode.USER_NOT_FOUND.getCode(), "user " + id + "is not exist!");
        // TODO:
        return findedEntity;
    }
}
