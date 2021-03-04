package com.sbs.untact.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.untact.dto.Member;

@Mapper
public interface MemberDao {
	public void join(Map<String, Object> param);

	public Member getMemberByLoginId(String loginId);

	public void modifyMember(Map<String, Object> param);

	public Member getMember(int id);
}
