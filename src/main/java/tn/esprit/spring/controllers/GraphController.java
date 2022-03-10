package tn.esprit.spring.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {
	
	
	

		@GetMapping("/displayBarGraph")
		public String barGraph(Model model) {
			Map<String, Integer> surveyMap = new LinkedHashMap<>();
			surveyMap.put("Gain", 30);
			surveyMap.put("Dépenses", 17);
			model.addAttribute("surveyMap", surveyMap);
			return "barGraph";
		}

		@GetMapping("/displayPieChart")
		public String pieChart(Model model) {
			model.addAttribute("Gain", 70);
			model.addAttribute("dépenses", 30);
			return "pieChart";
		}

	}


