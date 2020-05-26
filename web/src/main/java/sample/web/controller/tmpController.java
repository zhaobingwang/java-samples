package sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.web.dao.tmpRepository;
import sample.web.entity.tmp;

import java.util.Optional;

@RestController
public class tmpController {

    @Autowired
    private tmpRepository _tmpRepository;

    @RequestMapping("/hi")
    public String hi() {
        Optional<tmp> result = _tmpRepository.findById(1);
        if (!result.isPresent())
            return "";
        return result.get().getName();
    }
}
