package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;
@Service
public class PhonebookService {
	@Autowired
	private PhonebookDao phonebookDao;

	public int exeWrite2(PersonVo personVo) {
		/*System.out.println(personVo);*/
		//비즈니스 로직 x
		
		// dao로 메모리올리기
//		PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	public int exeWrite1(String name, String hp, String company) {
		/*System.out.println("service>exeWrite1");
		System.out.println(name+hp+company);*/
		PersonVo personVo = new PersonVo(name,hp,company);
//		PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	
	public List<PersonVo> exeList() {
		/*System.out.println("service>exelist");*/
		
		/*PhonebookDao phonebookDao = new PhonebookDao();*/
		List<PersonVo> phonebookList = phonebookDao.personSelect();
		return phonebookList;
	}
	public int exeDelete(int no) {
		/*System.out.println("service>exeDelete");*/
//		PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personDelete(no);
		return count;
	}
	public PersonVo exeModifyForm(int no) {
		/*System.out.println("service>exeModifyForm");*/
//		PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVoOne = phonebookDao.personSelectOne(no);
		return personVoOne;		
	}
	public int exeModify(PersonVo personVo) {
		/*System.out.println("service>exeModify");*/
//		PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personUpdate(personVo);
		return count;
	}
}
