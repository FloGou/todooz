package fr.todooz.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.joda.time.DateMidnight;
import org.joda.time.Interval;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.todooz.domain.Task;
import fr.todooz.service.TagCloudService;
import fr.todooz.service.TaskService;
import fr.todooz.util.TagCloud;

@Controller
public class IndexController {
	@Inject
	private TaskService taskService;
	@Inject
	private TagCloudService tagCloudService;

	@PostConstruct
	public void bootstrap() {
		if (taskService.count() == 0) {
			Task task1 = new Task();
			Task task2 = new Task();
			Task task3 = new Task();
			task1.setDate(new Date());
			task1.setTitle("Read Effective Java");
			task1.setText("Read Effective Java before it's too late");
			task1.setTags("Effective,Java");
			taskService.save(task1);

			task2.setDate(new Date());
			task2.setTitle("Task de test");
			task2.setText("Finir le TP de J2EE");
			task2.setTags("TP");
			taskService.save(task2);

			DateMidnight dm = new DateMidnight();
			task3.setDate(dm.plusDays(2).toDate());
			task3.setTitle("Seconde Task de test");
			task3.setText("Acheter du cafe");
			task3.setTags("cafe");
			taskService.save(task3);
		}

	}

	
	
	
	@ModelAttribute
	public TagCloud tagCloud() {
		return tagCloudService.buildTagCloud();

	}

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		return "index";
	}

	@RequestMapping("/search")
	public String search(String query, Model model) {
		model.addAttribute("tasks", taskService.findByQuery(query));
		return "index";
	}

	@RequestMapping("/tag/{tag}")
	public String tag(@PathVariable String tag, Model model) {
		model.addAttribute("tasks", taskService.findByTag(tag));
		return "index";
	}

	@RequestMapping("/today")
	public String today(Model model) {
		DateMidnight today = new DateMidnight();
		model.addAttribute("tasks",
				taskService.findByDay(new Interval(today, today.plusDays(1))));
		return "index";
	}

	@RequestMapping("/tomorrow")
	public String tomorrow(Model model) {
		DateMidnight today = new DateMidnight();
		model.addAttribute("tasks", taskService.findByDay(new Interval(today
				.plusDays(1), today.plusDays(2))));
		return "index";
	}
}