package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.dto.AllSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.CurrentSemesterSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.ReadSyllabusDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectForProfessorDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectPeriodForProfessorDto;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;

public class SubjectRepositoryImpl implements SubjectRepository{

	@Override
	public Integer insert(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBySubjectDto(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Subject> selectByRoomIdAndSubDayAndSubYearAndSemester(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectIdOrderById(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemester(Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterLimit(Integer subYear, Integer semester, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectFormDto> selectDtoAll(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoAllLimit(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectPeriodForProfessorDto> selectSemester(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectForProfessorDto> selectSubjectBySemester(
			SubjectPeriodForProfessorDto subjectPeriodForProfessorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterAndDeptAndName(AllSubjectSearchFormDto allSubjectSearchFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterAndAndTypeAndDeptAndName(
			CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject selectSubjectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNumOfStudent(Integer id, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReadSyllabusDto selectSyllabusBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdByLessNumOfStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdByMoreNumOfStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
