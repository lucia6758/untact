package com.sbs.untact.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.untact.dto.Member;

@Mapper
public interface MemberDao {
	void join(Map<String, Object> param);

	Member getMemberByLoginId(String loginId);

	void modifyMember(Map<String, Object> param);

	Member getMember(int id);
}
