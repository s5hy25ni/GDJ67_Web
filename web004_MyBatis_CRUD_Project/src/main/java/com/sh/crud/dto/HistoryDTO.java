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
public class HistoryDTO {
	private String seq;
	private String tradeDate;
	private String playerId;
	private String oldTeam;
	private String newTeam;
	private String active;
}
