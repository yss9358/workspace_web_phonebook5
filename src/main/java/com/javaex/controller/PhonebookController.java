package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;


@Controller
public class PhonebookController {

	//필드
	//생성자
	//메소드g/s
	//메소드일반
	
	//등록폼
	//localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value="/phone/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	//등록
		//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
		@RequestMapping(value="/phone/write2", method= {RequestMethod.GET, RequestMethod.POST})
		public String write2(@ModelAttribute PersonVo personVo) {
			System.out.println("PhonebookController.write2()");
			
			System.out.println(personVo.toString());
			
			//dao로 메모리올리기
			PhonebookDao phonebookDao = new PhonebookDao();
			phonebookDao.personInsert(personVo);
			
			//리다이렉트
			return "redirect:/phone/list";
		}
	
	//등록
	//localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	@RequestMapping(value="/phone/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam(value="name") String name,
					  @RequestParam(value="hp") String hp, 
					  @RequestParam(value="company") String company) {
		
		System.out.println("PhonebookController.write()");
		System.out.println(name + " " + hp + " " + company);
		
		//vo묶기
		PersonVo personVo = new PersonVo(name,hp,company);
		//dao로 메모리올리기
		PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personInsert(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value="/phone/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();
		System.out.println(personList);
		model.addAttribute("pList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	@RequestMapping(value="/phone/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("PhonebookController.delete()");
		
		PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personDelete(no);
		
		return "redirect:/phone/list";
	}
	@RequestMapping(value="/phone/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyform()");
		PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVoOne = phonebookDao.personSelectOne(no);
		model.addAttribute("personvoOne",personVoOne);
		return "/WEB-INF/views/modifyForm.jsp";
	}
	@RequestMapping(value="/phone/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.update()");
		System.out.println(personVo);
		PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}
	
	
}