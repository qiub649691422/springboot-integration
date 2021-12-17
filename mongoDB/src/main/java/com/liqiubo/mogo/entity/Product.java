package com.liqiubo.mogo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author 小五老师-云析学院
 * @createTime 2019年1月7日 下午8:10:11
 * 
 */
@Document(collection="product")
public class Product {

	@Id
	private ObjectId id;
	private String name;
	private double price;
	private String category;
	private String[] tags;
	private Author author;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	class Author{
		private String name;
		private String from;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("id:"+id+",name="+name+",price="+price+",category="+category);
		sb.append(",tags[");
		for (int i = 0; i < tags.length; i++) {
			sb.append(tags[i]+" ");
		}
		sb.append("]");
		sb.append(",author[name="+(author==null?"null":author.name)+", from="+(author==null?"null":author.from)+"]");
		return sb.toString();
	}
}
