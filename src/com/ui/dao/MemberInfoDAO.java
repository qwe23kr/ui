package com.ui.dao;

import java.util.List;
import java.util.Map;

import com.ui.vo.UserInfoVO;

public interface MemberInfoDAO {
   int insertMemberInfo(Map<String,Object> mi);
   int updateMemberInfo(Map<String,Object> mi);
   int deleteMemberInfo(Map<String,Object> mi);
   Map<String, Object> selectMemberInfo(Map<String,Object> mi);
   List<Map<String,Object>> selectTest(Map<String,Object> mi);
   List<Map<String,Object>> selectMemberInfoList(Map<String,Object> mi);
}