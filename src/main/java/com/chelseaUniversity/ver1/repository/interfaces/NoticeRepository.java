package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.model.dto.NoticeFormDto;
import com.chelseaUniversity.ver1.model.dto.NoticePageFormDto;

/*
 *  박성희
 *  공지 repository
 */

public interface NoticeRepository {
	
	// 공지사항 등록
	public void insertCreateNotice(String category, String title, String content);
	
	// 공지사항 수정
	public void updateNotice(String category, String title, String content, String id);
	
	// 공지사항 삭제
	public void deleteNotice(String id);
	
	public Notice selectById(Integer id);
	
	// 페이징
	public List<Notice> selectByNoticeDtoOrderBy(int limit,int offset);
	public Integer selectNoticeCount();
	
	// 검색
	public List<Notice> selectNoticeByKeyword(NoticePageFormDto noticePageFormDto,int limit,int offset);
	public List<Notice> selectNoticeByTitle(NoticePageFormDto noticePageFormDto,int limit,int offset);
	public Integer selectNoticeCountByTitle(NoticePageFormDto noticePageFormDto);
	public Integer selectNoticeCountByKeyword(NoticePageFormDto noticePageFormDto);
	
	// 조회수
	public Integer updateViews(Integer id);
	
}
