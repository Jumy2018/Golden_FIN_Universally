package com.finuniversally.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.finuniversally.model.Variety;

@Component
public interface VarietyDao {
	@Select("select id,variety_name as varietyName from GFU_VARIETY")
	public List<Variety> getVarietys();
}
