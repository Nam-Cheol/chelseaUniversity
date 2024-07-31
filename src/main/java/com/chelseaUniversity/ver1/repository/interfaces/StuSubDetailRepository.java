package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.SendSub;
import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;

public interface StuSubDetailRepository {

	// 학생 성적 업데이트
	int updateGrade(StuSubDetail stuSubDetail);

	int insert(String studentId, String subjectId);

	List<StuSubDetail> selectListById(Integer id);
	
	StuSubDetail selectById(Integer id);
	
	List<SendSub> selectFixSubject();

}
