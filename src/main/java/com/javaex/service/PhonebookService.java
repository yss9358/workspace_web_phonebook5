package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;
@Service
public class PhonebookService {
	@Autowired
	private PhonebookDao phonebookDao;

	public int exeWrite1(PersonVo personVo) {
		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	public int exeWrite2(String name, String hp, String company) {
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		int count = phonebookDao.personInsert2(personMap);
		return count;
	}
	public List<PersonVo> exeList() {
		List<PersonVo> phonebookList = phonebookDao.personSelect();
		return phonebookList;
	}
	public int exeDelete(int no) {
		int count = phonebookDao.personDelete(no);
		return count;
	}
	public PersonVo exeModifyForm(int no) {
		PersonVo personVoOne = phonebookDao.personSelectOne(no);
		return personVoOne;		
	}
	public Map<String, Object> exeModifyForm2(int no) {
		Map<String, Object> pMap = phonebookDao.personSelectOne2(no);
		return pMap;
	}
	public int exeModify(PersonVo personVo) {
		int count = phonebookDao.personUpdate(personVo);
		return count;
	}
}
