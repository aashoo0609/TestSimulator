package com.yash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yash.dao.QuestionDAOImpl;
import com.yash.exception.ListEmptyException;
import com.yash.model.Questions;

@RestController
@CrossOrigin(origins = "*")
public class QuestionsController
{
	@Autowired
	private QuestionDAOImpl quesService;
	
	@GetMapping("/hello")
	public String get()
	{
		return "Hello";
	}
	@GetMapping("/getQuestions")
	public List<Questions>  getQuestions() throws ListEmptyException
	{
		List<Questions> questionList = quesService.getAllQuestions();
		if(questionList.isEmpty())
		{
			throw new ListEmptyException("List is Empty..");
		}
		return questionList;
		
	}
	
	@GetMapping("/getBySubId/{no}")
	public List<Questions> getById(@PathVariable("no") int no)
	{
		return quesService.getQuestionsById(no);
	}
	
	@DeleteMapping("/deleteQues/{no}")
	public void deleteQues(@PathVariable("no") int no)
	{
		quesService.deleteQues(no);
	}

	@PostMapping("/subject/{id}/addQuestion")
	public Questions addQues(@PathVariable(value="id") int id,@Valid @RequestBody Questions ques)
	{
		return quesService.addQuestion(id,ques);
	}
	
/*	@PostMapping("/addQues")
	public Questions addQ(@RequestBody Questions ques)
	{
		System.out.println(ques);
		return daoService.addQues(ques);
	}*/
	
	@PutMapping("/subject/{id}/updateQuestion")
	public Questions updateQues(@PathVariable("id") int id, @RequestBody Questions ques)
	{
		return quesService.updateQuestion(id, ques);
	}
}
