package com.ddlab.rnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Item")
@Table(name = "Item")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue
    private Long id;
	
	@Column(name = "name")
    private String name;
    
	@Column(name = "rating")
    private int rating;
	
	@Column(name = "price")
	private int price;

    @Version
    private Integer version;

	public Item(String name, int rating, int price) {
		super();
		this.name = name;
		this.rating = rating;
		this.price = price;
	}
}
