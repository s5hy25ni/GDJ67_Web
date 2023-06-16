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
public class ScheduleDTO {
	private String stadiumId;
	private String stadiumName;
	private String scheDate;
	private String gubun;
	private String hometeamId;
	private String hometeamName;
	private String awayteamId;
	private String awayteamName;
	private int homeScore;
	private int awayScore;
}
