package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	// 필드
	@Autowired
	private PhonebookService phonebookService;
	// 생성자
	// 메소드g/s
	// 메소드일반

	// 등록폼
	@RequestMapping(value = "/phone/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		return "writeForm";
	}

	// 등록
	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {
		// 서비스를 메모리에 올려서 서비스의 메소드 사용
//		PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite2(personVo);
		
		// 리다이렉트
		return "redirect:/phone/list";
	}

	// 등록
	// localhost:8080/phonebook5/phone/write?name=황일영&hp=010&company=02
	@RequestMapping(value = "/phone/write1", method = { RequestMethod.GET, RequestMethod.POST })
	public String write1(@RequestParam(value = "name") String name, 
						@RequestParam(value = "hp") String hp,
						@RequestParam(value = "company") String company) {
//		PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite1(name,hp,company);
		// 리다이렉트
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		/*PhonebookService phonebookService = new PhonebookService();*/ //@Autowired 로 안해도됨
		List<PersonVo> personList = phonebookService.exeList();
		model.addAttribute("pList", personList);
		return "list";
	}

	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {
		/*System.out.println("con>delete");*/
//		PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeDelete(no);
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
//		PhonebookService phonebookService = new PhonebookService();
		PersonVo personVoOne = phonebookService.exeModifyForm(no);
		model.addAttribute("personvoOne", personVoOne);
		return "modifyForm";
	}

	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
//		PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeModify(personVo);
		return "redirect:/phone/list";
	}

}