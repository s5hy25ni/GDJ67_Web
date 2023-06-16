package com.sh.crud.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ResultDTO {
	private int rank;
	private String teamId;
	private int teamName;
	private int score;
	private int victory;
	private int tie;
	private int lose;
	private int gain;
	private int loss;
	private int diff;
}
