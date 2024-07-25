package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class ClassesRepositoryImpl implements ClassesRepository {

	public static final String COUNT_ALL_BOARDS = " SELECT count(*) as count FROM subject_tb ";
	public static final String SELECT_ALL_CLASSES = " SELECT s.*, p.name, d.name FROM subject_tb as s LEFT JOIN professor_tb as p on s.professor_id = p.id LEFT JOIN department_tb as d on s.dept_id = d.id ORDER BY id limit ? offset ? ";
	public static final String GET_CLASSES_BY_PROFESSOR_ID = " SELECT * FROM subject_tb WHERE professor_id = ? ";
	public static final String GET_CLASSES_BY_SEARCH_ID_NAME = "SELECT s.*, p.name, d.name FROM subject_tb as s LEFT JOIN professor_tb as p on s.professor_id = p.id LEFT JOIN department_tb as d on s.dept_id = d.id WHERE sub_year = ? and semester = ? and s.dept_id = ? and s.name LIKE ? ";
	public static final String GET_CLASSES_BY_SEARCH_ID = "SELECT s.*, p.name, d.name FROM subject_tb as s LEFT JOIN professor_tb as p on s.professor_id = p.id LEFT JOIN department_tb as d on s.dept_id = d.id WHERE sub_year = ? and semester = ? and s.dept_id = ? ";
	public static final String GET_CLASSES_BY_SEARCH_NAME = "SELECT s.*, p.name, d.name FROM subject_tb as s LEFT JOIN professor_tb as p on s.professor_id = p.id LEFT JOIN department_tb as d on s.dept_id = d.id WHERE sub_year = ? and semester = ? and s.name LIKE ? ";
	public static final String GET_CLASSES_BY_SEARCH = "SELECT s.*, p.name, d.name FROM subject_tb as s LEFT JOIN professor_tb as p on s.professor_id = p.id LEFT JOIN department_tb as d on s.dept_id = d.id WHERE sub_year = ? and semester = ? ";
	public static final String GET_INFO_BY_ID = " SELECT * FROM subject_tb WHERE id = ? ";

	@Override
	public List<ClassesDto> getAllClasses(int limit, int offset) {
		List<ClassesDto> allClassesList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_CLASSES)) {
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesList.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student"))
						.professorName(rs.getString("p.name")).deptName(rs.getString("d.name")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allClassesList;
	}

	@Override
	public List<ClassesDto> getClassesById(int professorId) {
		List<ClassesDto> allClassesListBySearch = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_CLASSES_BY_PROFESSOR_ID)) {
			pstmt.setInt(1, professorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesListBySearch.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allClassesListBySearch;
	}

	@Override
	public List<ClassesDto> getClassesBySearchIdName(int year, int semester, int deptId, String name) {
		List<ClassesDto> allClassesListBySearch = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_CLASSES_BY_SEARCH_ID_NAME)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, deptId);
			pstmt.setString(4, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesListBySearch.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student"))
						.professorName(rs.getString("p.name")).deptName(rs.getString("d.name")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allClassesListBySearch;
	}

	@Override
	public List<ClassesDto> getClassesBySearchId(int year, int semester, int deptId) {
		List<ClassesDto> allClassesListBySearch = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_CLASSES_BY_SEARCH_ID)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, deptId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesListBySearch.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student"))
						.professorName(rs.getString("p.name")).deptName(rs.getString("d.name")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allClassesListBySearch;
	}

	@Override
	public List<ClassesDto> getClassesBySearch(int year, int semester) {
		List<ClassesDto> allClassesListBySearch = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_CLASSES_BY_SEARCH)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesListBySearch.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student"))
						.professorName(rs.getString("p.name")).deptName(rs.getString("d.name")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allClassesListBySearch;
	}

	@Override
	public List<ClassesDto> getClassesBySearchName(int year, int semester, String name) {
		List<ClassesDto> allClassesListBySearch = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_CLASSES_BY_SEARCH_NAME)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setString(3, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allClassesListBySearch.add(ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("s.name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student"))
						.professorName(rs.getString("p.name")).deptName(rs.getString("d.name")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allClassesListBySearch;
	}

	@Override
	public int getBoardCount() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_BOARDS)) {
			ResultSet rs = pstmt.executeQuery(COUNT_ALL_BOARDS);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public ClassesDto getInfoById(int subjectId) {
		ClassesDto classDto = new ClassesDto();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_INFO_BY_ID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				classDto = ClassesDto.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return classDto;
	}

}
