package sample.web.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table()
public class tmp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
