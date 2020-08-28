package com.ui.service;

import java.util.List;
import java.util.Map;

import com.ui.vo.UserInfoVO;

public interface MemberService {
	int insertUserInfo(UserInfoVO ui);
	int updateUserInfo(UserInfoVO ui);
	int deleteUserInfo(UserInfoVO ui);
	UserInfoVO selectUserInfo(UserInfoVO ui);
	List<Map<String, Object>> selectMemberInfoList(Map<String, Object> mi);

}
