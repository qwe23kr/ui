package com.ui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ui.dao.MemberInfoDAO;
import com.ui.servlet.InitServlet;
import com.ui.servlet.MybatisServlet;

public class MemberInfoDAOImpl implements MemberInfoDAO {

   @Override
   public int insertMemberInfo(Map<String, Object> mi) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int updateMemberInfo(Map<String, Object> mi) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int deleteMemberInfo(Map<String, Object> mi) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public Map<String, Object> selectMemberInfo(Map<String, Object> mi) {
      try(SqlSession ss = MybatisServlet.getSession()){
         return mi ;
      }
   }

   @Override
   public List<Map<String, Object>> selectMemberInfoList(Map<String, Object> mi) {
      try(SqlSession ss = MybatisServlet.getSession()){
         return ss.selectList("Member.selectMemberList",mi);
      }
   }

   @Override
   public List<Map<String, Object>> selectTest(Map<String, Object> mi) {
      List<Map<String,Object>> mList = new ArrayList<>();
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "select * from Member_info";
      if(mi!=null) {
         sql +=" where 1=1 ";
         if(mi.get("mi_num")!=null) {
            sql += " and mi_num=?";
         }
         if(mi.get("mi_id")!=null) {
            sql +=" and mi_id=?";
         }
         if(mi.get("mi_name")!=null) {
            sql +=" and mi_name=?";
         }
      }
      try {
         con = InitServlet.getConnection();
         ps = con.prepareStatement(sql);
         if(mi!=null) {
            if(mi.get("mi_num")!=null) {
               ps.setObject(1,mi.get("mi_num"));
            }
         }
         rs = ps.executeQuery();
         while(rs.next()) {
            Map<String,Object> m = new HashMap<>();
            m.put("mi_id", rs.getString("mi_id"));
            mList.add(m);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return mList;

   }
   public static void main(String[] args) {
      InitServlet is = new InitServlet();
      is.init();
      MemberInfoDAOImpl midao = new MemberInfoDAOImpl();
      Map<String,Object> param = new HashMap<>();
      param.put("startNum",51);
      param.put("endNum",60);
      
      List<Map<String, Object>> mList=midao.selectMemberInfoList(param);
      for(Map<String, Object> m:mList) {
         System.out.println(m);
      }
//      System.out.println(midao.selectMemberList(null));
   }

}