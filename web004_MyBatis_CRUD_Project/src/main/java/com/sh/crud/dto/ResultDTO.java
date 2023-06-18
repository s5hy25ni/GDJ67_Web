package com.sh.crud.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultDTO {
	private int rank;
	private String teamName;
	private int score;
	private int victory;
	private int tie;
	private int lose;
	private int gain;
	private int loss;
	private int diff;
}
