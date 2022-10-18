package com.bnp.pocarchhexagonle.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
}
