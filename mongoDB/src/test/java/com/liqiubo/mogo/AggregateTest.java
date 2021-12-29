package com.liqiubo.mogo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-servlet.xml"})
public class AggregateTest {
	@Autowired
	private MongoTemplate mongo;

	/***
	 * db.users.aggregate({$group:{_id:"$address", username:{$push:"$username"}}})
	 * db.users.aggregate({"$project":{username:1, length:1}})
	 * db.users.aggregate({$match:{length:{$ne:null}}}, {$project:{username:1, length:1}})
	 * 
	 * db.users.aggregate({$match:{length:{$ne:null}}}, {$project:{username:1, length:1}},{$sort:{"length":-1}},{$skip:1},{$limit:2})
	 * db.users.aggregate({$match:{length:{$ne:null}}}, {$project:{username:1, length:1}},{$sort:{"length":-1}},{$skip:1},{$limit:2})
	 * 
	 * db.users.aggregate({$unwind:"$comments"},{$group:{_id:"$comments.movies",num:{$sum : 1}}})
	 */
@Test
public void aggregate1(){
//	Aggregation aggregation = newAggregation(group("address", "username"));
//	Aggregation aggregation = newAggregation(project("username","length"));
//	
//	Aggregation aggregation = newAggregation(
//			match(where("length").ne(null)), 
//			project("username","length"), 
//			sort(Direction.DESC, "length"),
//			limit(3), skip(1)
//			);
	
	Aggregation aggregation = newAggregation(
			unwind("comments"));
	AggregationResults<Object> aggregate = mongo.aggregate(aggregation, "users", Object.class);
	List<Object> mappedResults = aggregate.getMappedResults();
	for (Object object : mappedResults) {
		System.out.println(object);
	}
}
	
}
