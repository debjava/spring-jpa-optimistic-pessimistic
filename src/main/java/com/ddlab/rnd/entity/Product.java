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

@Entity(name = "Product")
@Table(name = "Product")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
    private Long id;
	
	@Column(name = "name")
    private String name;
    
	@Column(name = "price")
    private int price;

    @Version
    private Integer version;
    
    public Product(String name, int price) {
    	this.name = name;
    	this.price = price;
    }
    
}
