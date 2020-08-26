package demo.springboot.properties.controller;

import demo.springboot.properties.property.ApplicationProperty;
import demo.springboot.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public HashMap<String, Object> index() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("app", applicationProperty);
        hashMap.put("dev", developerProperty);
        return hashMap;
    }
}
