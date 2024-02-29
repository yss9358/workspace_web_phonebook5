package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;
@Repository
public class PhonebookDao {

//	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 생성자
	// 메소드-gs
	// 메소드-일반
	public List<PersonVo> personSelect() {
		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		return personList;
	}
	
	public int personInsert(PersonVo personVo) {
		int count = sqlSession.insert("phonebook.insert", personVo);
		return count;
	}
	public int personInsert2(Map<String, String> pMap) {
		int count = sqlSession.insert("phonebook.insert2",pMap);
		return count;
	}

	public int personDelete(int no) {
		int count = sqlSession.delete("phonebook.delete",no);
		return count;
	}

	public PersonVo personSelectOne(int no) {
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne",no);
		return personVo;
	}
	
	public Map<String,Object> personSelectOne2(int no) {
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);
//		System.out.println(pMap.get("person_id"));
//		System.out.println(pMap.get("name"));
//		System.out.println(pMap.get("hp"));
//		System.out.println(pMap.get("company"));
		return pMap;
	}
	
	public int personUpdate(PersonVo personVo) {
		int count = sqlSession.update("phonebook.update", personVo);
		return count;
	}

}