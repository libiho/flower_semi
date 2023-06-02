package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.FAQ;
import com.kh.board.model.vo.Notice;
import com.kh.member.model.dao.MemberDao;

import static com.kh.common.JDBCTemplate.*;

public class BoardDao {
	
	Properties prop = new Properties();

	public BoardDao() {
		try {
			
			String filePath = MemberDao.class.getResource("/db/sql/board-mapper.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectNotice(Connection conn) {
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(rs.getInt("NOTICE_ID")
						          , rs.getString("NOTICE_TITLE")
						          , rs.getString("NOTICE_COMMENT")
						          , rs.getDate("NOTICE_REGDATE")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<FAQ> selectFAQ(Connection conn) {
		ArrayList<FAQ> list = new ArrayList<FAQ>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectFAQ");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new FAQ(rs.getInt("FAQ_ID")
						          , rs.getString("FAQ_CATEGORY")
						          , rs.getString("FAQ_TITLE")
						          , rs.getString("FAQ_COMMENT")
						          , rs.getDate("FAQ_REGDATE")
						          , rs.getDate("FAQ_UPDATE")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}














