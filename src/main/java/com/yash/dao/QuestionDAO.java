package com.yash.dao;

import java.util.List;
import java.util.Optional;

import com.yash.model.Questions;

public interface QuestionDAO {

	public List<Questions> getAllQuestions();
	
	public List<Questions> getQuestionsById(int subID);
	
	public void deleteQues(int no);

	public Questions updateQuestion(int id, Questions ques);

	public Questions addQuestion(int id, Questions ques);
}
