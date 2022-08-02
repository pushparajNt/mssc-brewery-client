package com.sfg.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class BeerDto {

	private UUID beerId;
	private String name;
	private String style;
	private Long upc;
}
