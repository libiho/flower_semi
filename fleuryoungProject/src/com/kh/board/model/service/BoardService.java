package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.FAQ;
import com.kh.board.model.vo.Notice;

import static com.kh.common.JDBCTemplate.*;

public class BoardService {

	public ArrayList<Notice> selectNotice() {

		Connection conn = getConnection();
		
		ArrayList<Notice> list = new BoardDao().selectNotice(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<FAQ> selectFAQ() {
		
		Connection conn = getConnection();
		
		ArrayList<FAQ> list = new BoardDao().selectFAQ(conn);
		
		close(conn);
		
		return list;
	}

}
