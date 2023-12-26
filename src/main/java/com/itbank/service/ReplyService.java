package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReplyDAO;
import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.ReplyVO;
import com.itbank.model.vo.Reply_ListVO;

@Service
public class ReplyService {
	@Autowired
	private ReplyDAO dao;
	
	public List<Reply_ListVO> getReplys(int board_idx){
		return dao.selectReplyAll(board_idx);
	}
	
	public int addReply(ReplyVO input) {
		return dao.insertReply(input);
	}
	
	public int countReply(int idx) {
		return dao.countOne(idx);
	}

	public Object getMyReplys(AccountVO user) {
		return dao.selectMyReplyAll(user);
	}

	public String replyUpdate(ReplyVO input) {
		int row = dao.updateReply(input);
		
		if(row == 1) {
			return input.getContents();
		}
		
		return null;
	}
}
