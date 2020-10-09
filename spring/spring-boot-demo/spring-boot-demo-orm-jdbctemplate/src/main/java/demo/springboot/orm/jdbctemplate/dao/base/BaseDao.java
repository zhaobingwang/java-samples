package demo.springboot.orm.jdbctemplate.dao.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.*;
import demo.springboot.orm.jdbctemplate.annotation.Pk;
import demo.springboot.orm.jdbctemplate.annotation.Table;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BaseDao<T, P> {
    private JdbcTemplate jdbcTemplate;
    private Class<T> clazz;

    public BaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

//    protected Integer insert(T t, boolean ignoreNull) {
//        String table = getTableName(t);
//        List<Field> filterField =getField(t,ignoreNull);
//    }

    /**
     * 获取表名
     *
     * @param t 对象
     * @return 表名
     */
    private String getTableName(T t) {
        Table tableAnnotation = t.getClass().getAnnotation(Table.class);
        if (ObjectUtil.isNotNull(tableAnnotation)) {
            return StrUtil.format("`{}`", tableAnnotation.name());
        } else {
            return StrUtil.format("`{}`", clazz.getName().toLowerCase());
        }
    }

    /**
     * 获取表名
     *
     * @return 表名
     */
    private String getTableName() {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (ObjectUtil.isNotNull(tableAnnotation)) {
            return StrUtil.format("`{}`", tableAnnotation.name());
        } else {
            return StrUtil.format("`{}`", clazz.getName().toLowerCase());
        }
    }

    private List<Field> getField(T t, Boolean ignoreNull) {
        // 获取所有字段，包含父类中的字段
        Field[] fields = ReflectUtil.getFields((t.getClass()));

        List<Field> filterField;
        Stream<Field> fieldStream = CollUtil.toList(fields).stream().filter(field ->
                ObjectUtil.isNull(field.getAnnotation(Ignore.class))
                        || ObjectUtil.isNull(field.getAnnotation(Pk.class)));

        if (ignoreNull) {
            filterField = fieldStream.filter(field -> ObjectUtil.isNotNull(ReflectUtil.getFieldValue(t, field))).collect(Collectors.toList());
        } else {
            filterField = fieldStream.collect(Collectors.toList());
        }
        return filterField;
    }
}
