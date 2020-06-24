package snippets.demo.ModelMapperDemo;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserEntity {
    public UserEntity() {

    }

    public UserEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserEntity(UUID id, String name, String mobileNo) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    private UUID id;
    private String name;
    private LocalDate DOB;
    private String mobileNo;
}
