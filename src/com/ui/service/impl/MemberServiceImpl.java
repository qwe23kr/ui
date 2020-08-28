package com.ui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ui.dao.MemberInfoDAO;
import com.ui.dao.impl.MemberInfoDAOImpl;
import com.ui.service.MemberService;
import com.ui.vo.UserInfoVO;

public class MemberServiceImpl implements MemberService {
private MemberInfoDAO midao= new MemberInfoDAOImpl();
@Override
public List<Map<String,Object>> selectMemberInfoList(Map<String,Object>mi){
	int page=Integer.parseInt(mi.get("page").toString());
	int pageSize=Integer.parseInt(mi.get("pageSize").toString());
	int startNum=(page-1)*pageSize+1;
	int endNum=(startNum-1)+pageSize;
	mi.put("startNum",startNum);
	mi.put("endNum",endNum);
	return midao.selectMemberInfoList(mi);
	
}
@Override
public int insertUserInfo(UserInfoVO ui) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int updateUserInfo(UserInfoVO ui) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int deleteUserInfo(UserInfoVO ui) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public UserInfoVO selectUserInfo(UserInfoVO ui) {
	// TODO Auto-generated method stub
	return null;
}
public static void main(String[] args) {
	Map<String,Object> param=new HashMap<>();
	param.put("page",3);
	param.put("pageSize",30);

}
}
