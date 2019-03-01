package com.hz.mongotest.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.regex.Pattern;

/**
 * 原生操作
 */
public class Mongo3Demo {

    public static void main(String[] args) {

        MongoClientURI uri = new MongoClientURI("mongodb://test01:test692@www.mawbo.cn:27017/test");
        MongoClient client = new MongoClient(uri);
//      获得数据库
        MongoDatabase db = client.getDatabase("test");
//      获得集合
        MongoCollection<Document> t1 = db.getCollection("user");

//      插入数据
//        for (int i = 0; i < 10; i++){
//            Document doc = new Document();
//            doc.append("sid", i);
//            doc.append("name", "mwb - " + i);
//            t1.insertOne(doc);
//        }
//      打印集合中文档数量
        System.out.println(t1.countDocuments());

//      查询文档,打印name字段
//      设置条件
        BasicDBObject where = new BasicDBObject();
        where.put("sid", new BasicDBObject("$gt", 5).append("$lt", 10));
//      模糊查询,且设置不区分大小写
//        Pattern pattern = Pattern.compile("6");
//        where.put("name", new BasicDBObject("$regex", pattern).append("$options", "i"));
        MongoCursor<Document> cursor = t1.find(where).iterator();
//      分页查询
//        MongoCursor<Document> cursor = t1.find().skip(3).limit(3).iterator();
        while (cursor.hasNext()){
            Document doc = cursor.next();
            String name = doc.getString("name");
            System.out.println(name);
        }

//      修改文档
//        BasicDBObject where1 = new BasicDBObject("sid", 1);
//        BasicDBObject where2 = new BasicDBObject("$set", new BasicDBObject("name", "SuperMan"));
//        t1.updateMany(where1, where2);

//      删除文档
//        BasicDBObject where3 = new BasicDBObject("sid", 0);
//        t1.deleteOne(where3);

        client.close();


    }
}