package com.airbusinventory.products.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(generator="pid_generator")
	@GenericGenerator(name="pid_generator", strategy="com.airbusinventory.products.idgenerator.PidGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "product_sequence"),
	        @Parameter(name = "initial_value", value = "4"),
	        @Parameter(name = "increment_size", value = "1")
	})
	private String id;
	
	private String name;
	
	private String category;
	
	private String description;
	
	private int units;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	
	
}
