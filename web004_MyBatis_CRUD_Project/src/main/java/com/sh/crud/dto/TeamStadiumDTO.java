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
	
	public TeamStadiumDTO(String stadiumId, String stadiumName, int seatCount, String address) {
		this.stadiumId = stadiumId;
		this.stadiumName = stadiumName;
		this.seatCount = seatCount;
		this.address = address;
	}
	
	public TeamStadiumDTO(String teamId, String regionName, String teamName, String origYYYY, String stadiumId) {
		this.teamId = teamId;
		this.regionName = regionName;
		this.teamName = teamName;
		this.origYyyy = origYYYY;
		this.stadiumId = stadiumId;
	}
	
	public TeamStadiumDTO(String teamId, String regionName, String teamName, String stadiumId) {
		this.teamId = teamId;
		this.regionName = regionName;
		this.teamName = teamName;
		this.stadiumId = stadiumId;
	}
}
