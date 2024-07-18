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
	public int insert(NoticeFormDto noticeFormDto);
	public List<Notice> selectByNoticeDto(NoticePageFormDto noticePageFormDto);
	public Notice selectById(Integer id);
	public int updateByNoticeDto(NoticeFormDto noticeFormDto);
	public int deleteById(Integer id);
	
	// 파일
	public int insertFile(NoticeFormDto noticeFormDto);
	public int selectLimit(NoticeFormDto noticeFormDto);
	
	// 페이징
	public List<Notice> selectByNoticeDtoOrderBy();
	public Integer selectNoticeCount(NoticePageFormDto noticePageFormDto);
	
	// 검색
	public List<Notice> selectNoticeByKeyword(NoticePageFormDto noticePageFormDto);
	public List<Notice> selectNoticeByTitle(NoticePageFormDto noticePageFormDto);
	public Integer selectNoticeCountByTitle(NoticePageFormDto noticePageFormDto);
	public Integer selectNoticeCountByKeyword(NoticePageFormDto noticePageFormDto);
	
	// 조회수
	public Integer updateViews(Integer id);
	
	// 메인 페이지에 사용할 최신글 5개
	public List<NoticeFormDto> selectLimit5();
}
