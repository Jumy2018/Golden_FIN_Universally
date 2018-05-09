package com.finuniversally.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 品种
 * @author riseSun
 *
 * 2017年12月14日下午10:10:41
 */
@AllArgsConstructor@NoArgsConstructor
public class Variety {
	private Long id;
	private String varietyName;
	private String varietyCode;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVarietyName() {
		return varietyName;
	}
	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}
	public String getVarietyCode() {
		return varietyCode;
	}
	public void setVarietyCode(String varietyCode) {
		this.varietyCode = varietyCode;
	}
}
