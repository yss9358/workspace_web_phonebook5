package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
	@RequestMapping(value = "/phone/write1", method = { RequestMethod.GET, RequestMethod.POST })
	public String write1(@ModelAttribute PersonVo personVo) {
		phonebookService.exeWrite1(personVo);
		return "redirect:/phone/list";
	}

	// 등록
	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "name") String name, 
						@RequestParam(value = "hp") String hp,
						@RequestParam(value = "company") String company) {
		phonebookService.exeWrite2(name, hp, company);
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		List<PersonVo> personList = phonebookService.exeList();
		model.addAttribute("pList", personList);
		return "list";
	}

	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {
		phonebookService.exeDelete(no);
		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		PersonVo personVoOne = phonebookService.exeModifyForm(no);
		model.addAttribute("personvoOne", personVoOne);
		return "modifyForm";
	}
	
	@RequestMapping(value="/phone/modifyform2", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm2(@RequestParam(value="no") int no, Model model) {
		Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
		model.addAttribute("pMap", pMap);
		return "modifyForm2";
	}
	
	
	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		phonebookService.exeModify(personVo);
		return "redirect:/phone/list";
	}

}