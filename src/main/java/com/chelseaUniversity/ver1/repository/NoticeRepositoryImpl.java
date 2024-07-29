package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.model.dto.NoticeFormDto;
import com.chelseaUniversity.ver1.model.dto.NoticePageFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.NoticeRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class NoticeRepositoryImpl implements NoticeRepository {
	
	private static final String SELECT_COUNT_NOTICE = " SELECT count(id) as count FROM notice_tb ";
	private static final String SELECT_SELECT_COUNT_BYTITLE = " SELECT count(id) as count FROM notice_tb WHERE title LIKE ?";
	private static final String SELECT_SELECT_COUNT_BYKEYWORD = " SELECT count(id) as count FROM notice_tb WHERE title LIKE ? or content LIKE ?";
	private static final String SELECT_NOTICE_ALL_ORDER_BY = " SELECT * FROM notice_tb ORDER BY id DESC limit ? OFFSET ?";
	private static final String SELECT_NOTICE_BYID = " SELECT * FROM notice_tb WHERE id = ? ";
	private static final String UPDATE_NOTICE_VIEW_BYID = " update notice_tb SET views = views + 1 WHERE id = ? ";
	private static final String SELECT_NOTICE_BYTITLE = " SELECT * FROM notice_tb WHERE title LIKE ? ORDER BY id DESC limit ? OFFSET ? ";
	private static final String SELECT_NOTICE_BYKEYWORD = " SELECT * FROM notice_tb WHERE title LIKE ?"
			+ "UNION SELECT * FROM notice_tb WHERE content LIKE ? ORDER BY id DESC limit ? OFFSET ? ";
	
	@Override
	public int insert(NoticeFormDto noticeFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notice> selectByNoticeDto(NoticePageFormDto noticePageFormDto) {
		
		return null;
	}

	@Override
	public Notice selectById(Integer id) {
		Notice notice = null;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = Notice.builder().id(rs.getInt("id")).category(rs.getString("category"))
				.title(rs.getString("title")).content(rs.getString("content"))
				.createdTime(rs.getTimestamp("created_time")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public int updateByNoticeDto(NoticeFormDto noticeFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertFile(NoticeFormDto noticeFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectLimit(NoticeFormDto noticeFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notice> selectByNoticeDtoOrderBy(int limit,int offset) {
		List<Notice> noticeList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_ALL_ORDER_BY)){
				pstmt.setInt(1, limit);
				pstmt.setInt(2, offset);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Notice notice = Notice.builder()
									.id(rs.getInt("id"))
									.category(rs.getString("category"))
									.title(rs.getString("title"))
									.content(rs.getString("content"))
									.views(rs.getInt("views"))
									.createdTime(rs.getTimestamp("created_time"))
									.build();
					
					noticeList.add(notice);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public Integer selectNoticeCount() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_COUNT_NOTICE)){
			ResultSet rs = pstmt.executeQuery();
			count = rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Notice> selectNoticeByKeyword(NoticePageFormDto noticePageFormDto,int limit,int offset) {
		List<Notice>noticeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BYKEYWORD)){
			pstmt.setString(1, "%"+noticePageFormDto.getKeyword()+"%");
			pstmt.setString(2, "%"+noticePageFormDto.getKeyword()+"%");
			pstmt.setInt(3, limit);
			pstmt.setInt(4, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice notice = Notice.builder().id(rs.getInt("id")).category(rs.getString("category"))
						.title(rs.getString("title")).content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time")).views(rs.getInt("views"))
						.build();
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public List<Notice> selectNoticeByTitle(NoticePageFormDto noticePageFormDto,int limit,int offset) {
		List<Notice>noticeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_BYTITLE)){
			pstmt.setString(1, "%"+noticePageFormDto.getKeyword()+"%");
			pstmt.setInt(2, limit);
			pstmt.setInt(3, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Notice notice = Notice.builder().id(rs.getInt("id")).category(rs.getString("category"))
						.title(rs.getString("title")).content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time")).views(rs.getInt("views"))
						.build();
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public Integer selectNoticeCountByTitle(NoticePageFormDto noticePageFormDto) {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SELECT_COUNT_BYTITLE)){
			pstmt.setString(1, "%"+noticePageFormDto.getKeyword()+"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Integer selectNoticeCountByKeyword(NoticePageFormDto noticePageFormDto) {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SELECT_COUNT_BYKEYWORD)){
			pstmt.setString(1, "%"+noticePageFormDto.getKeyword()+"%");
			pstmt.setString(2, "%"+noticePageFormDto.getKeyword()+"%");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Integer updateViews(Integer id) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_NOTICE_VIEW_BYID)){
			pstmt.setInt(1, id);
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public List<NoticeFormDto> selectLimit5() {
		// TODO Auto-generated method stub
		return null;
	}

}
