package com.give2hand.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SchemeStatisticResponseDto extends ResponseDto{

	private List<SchemeChartDto> schemes;
}
