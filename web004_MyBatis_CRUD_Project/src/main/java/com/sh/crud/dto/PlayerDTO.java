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
public class PlayerDTO {
	private String playerId;
	private String playerName;
	private String ePlayerName;
	private String teamId;
	private String teamName;
	private String position;
	private int backNo;
	private String nation;
	private String birthDate;
	private int height;
	private int weight;
}
