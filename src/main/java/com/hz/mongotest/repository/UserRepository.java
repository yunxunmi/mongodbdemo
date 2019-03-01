package com.hz.mongotest.repository;

import com.hz.mongotest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

    /*
     * MongoRepository与HibernateTemplete相似，提供一些基本的方法，
     * 实现的方法有findone(),save(),count(),findAll(),findAll(Pageable),delete(),deleteAll()..etc
     * 要使用Repository的功能，先继承MongoRepository<T, TD>接口
     * 其中T为仓库保存的bean类，TD为该bean的唯一标识的类型。
     * 之后在spring-boot中注入该接口就可以使用，无需实现里面的方法，spring会根据定义的规则自动生成。
     * starter-data-mongodb 支持方法命名约定查询 findBy + 属性名，
     * findBy后面的属性名一定要在User类中存在，否则会报错
     */

    /**
     * 自定条件查询：根据uid和name查
     * @param uid
     * @param name
     * @return
     */
    List<User> findByUidAndName(Integer uid, String name);

    /**
     * 自定模糊查询：根据name查,且忽略大小写IgnoreCase。AllIgnoreCase忽略所有属性大小写
     * @param name
     * @return
     */
    List<User> findByNameLikeIgnoreCase(String name);

    /**
     * 自定模糊查询且进行分页：根据name查并分页,且根据salary倒序排列
     * @param name
     * @param pageRequest
     * @return
     */
    Page<User> findByNameLikeOrderBySalaryDesc(String name, PageRequest pageRequest);

    /**
     * 自定模糊查询且进行分页并指定返回字段：根据name查并分页，只返回salary
     * 其中value是查询的条件(原生)，?0 这个是占位符，对应着方法中参数中的第一个参数，如果对应的是第二个参数则为 ?1。
     * fields是指定的返回字段，其中id是自动返回的，bson中{‘salary’: 1}的1代表自己返回。0代表仅自己不返回。
     * @param name
     * @param pageRequest
     * @return
     */
    @Query(value="{'name':{'$regex':?0}}",fields="{'salary':1}")
    Page<User> findByNameLike2(String name, PageRequest pageRequest);

//    GreaterThan(大于) 
//    findByAgeGreaterThan(int age) 
//    {"age" : {"$gt" : age}}
//
//    LessThan（小于） 
//    findByAgeLessThan(int age) 
//    {"age" : {"$lt" : age}}
//
//    Between（在...之间） 
//    findByAgeBetween(int from, int to) 
//    {"age" : {"$gt" : from, "$lt" : to}}
//
//    IsNotNull, NotNull（是否非空） 
//    findByFirstnameNotNull() 
//    {"age" : {"$ne" : null}}
//
//    IsNull, Null（是否为空） 
//    findByFirstnameNull() 
//    {"age" : null}
//
//    Not（不包含） 
//    findByFirstnameNot(String name) 
//    {"age" : {"$ne" : name}}
//
//    In（包含） 
//    findByFirstnameIn(String name) 
//    {"age" : {"$ne" : name}}

}
