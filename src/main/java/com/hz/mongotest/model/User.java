package com.hz.mongotest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Data
@Document(collection = "user")
public class User implements Serializable {

    @Id
    private Long id;

    /**
     * 员工编号
     */
    private Integer uid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 薪资
     */
    private Double salary;

    public User(Long id, Integer uid, String name, Double salary) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.salary = salary;
    }

}
