package com.edutecno.AdministracionBodega.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.AdministracionBodega.dto.MaterialDTO;

@Controller
public class MaterialController {

	@GetMapping("/materiales")
	public ModelAndView materiales(HttpSession sesion) {
		ModelAndView modelAndView = new ModelAndView("thymeleaf/materiales");
		modelAndView.addObject("materiales", sesion.getAttribute("materiales"));
		modelAndView.addObject("material", new MaterialDTO());
		return modelAndView;
	}

	@PostMapping("/materiales")
	public RedirectView materialesPost(HttpSession sesion, @ModelAttribute MaterialDTO material) {
		List<MaterialDTO> valores = new ArrayList<>();
		if (sesion.getAttribute("materiales") != null)
			valores.addAll((List<MaterialDTO>) sesion.getAttribute("materiales"));
		valores.add(material);
		sesion.setAttribute("materiales", valores);
		return new RedirectView("/materiales");

	}
}
