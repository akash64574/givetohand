package com.give2hand.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SchemeStatisticResponseDto {

	private Integer statusCode;
	private String message;
	private List<SchemeChartDto> schemes;
}
