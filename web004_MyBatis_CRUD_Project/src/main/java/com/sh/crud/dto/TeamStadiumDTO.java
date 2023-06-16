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
public class TeamStadiumDTO {
	private String teamId;
	private String regionName;
	private String teamName;
	private String origYyyy;
	private String homepage;
	private String stadiumId;
	private String stadiumName;
	private int seatCount;
	private String zipCode1;
	private String zipCode2;
	private String address;
	private String ddd;
	private String tel;
	private String fax;
}
