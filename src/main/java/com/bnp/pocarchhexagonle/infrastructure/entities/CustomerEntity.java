package com.bnp.pocarchhexagonle.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {
    @Id
    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    @OneToMany(mappedBy = "customerEntity")
    private List<OrderEntity> orderEntityList;
}
