package com.example.online_store.dao.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
    
    @Column(name = "code", length = 30, nullable = false)
	private String code;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private Double price;

    @Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;




    




    
}