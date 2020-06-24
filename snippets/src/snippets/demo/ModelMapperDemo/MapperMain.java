package snippets.demo.ModelMapperDemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MapperMain {
    public static UserEntity entity;
    public static List<UserEntity> entities;
    private static ModelMapper mapper;

    static {
        entity = new UserEntity();
        entities = new ArrayList<>();
        // entity
        entity.setId(UUID.randomUUID());
        entity.setName("用户1");
        entity.setMobileNo("18800000000");

        // entities
        entities.add(new UserEntity(UUID.randomUUID(), "用户2", "18800000000"));
        entities.add(new UserEntity(UUID.randomUUID(), "用户3"));
        entities.add(new UserEntity(UUID.randomUUID(), "用户4"));
        entities.add(new UserEntity(UUID.randomUUID(), "用户5"));
    }

    public static void main(String[] args) {
        mapper = new ModelMapper();

        UserDto dto = dto = new UserDto();
        System.out.println("entity: " + entity);
        mapper.map(entity, dto);
        System.out.println("dto: " + dto);

        mapper.addMappings(customUserMapRule());
        UserDto dto2 = mapper.map(entity, UserDto.class);
        System.out.println("dto2: " + dto2);

        List<UserDto> dtos = mapper.map(entities, new TypeToken<List<UserDto>>() {
        }.getType());
//        List<UserDto> dtos = entities.stream().map(entity -> mapper.map(entity, UserDto.class))
//                .collect(Collectors.toList());
        System.out.println("dtos: " + dtos);
    }

    private static PropertyMap customUserMapRule() {
        return new PropertyMap<UserEntity, UserDto>() {
            @Override
            protected void configure() {
                map(source.getMobileNo(), destination.getMobile_no());
            }
        };
    }
}
