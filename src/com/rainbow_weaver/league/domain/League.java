package com.rainbow_weaver.league.domain;

import java.io.Serializable;

public class League implements Serializable {
	private static final long serialVersionUID = -2272445153446075594L;
	private int year;
	private String season;
	private String title;
	public League() {
		super();
		// TODO Auto-generated constructor stub
	}
	public League(int year, String season, String title) {
		super();
		this.year = year;
		this.season = season;
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "League [year=" + year + ", season=" + season + ", title=" + title + "]";
	}
	
}
