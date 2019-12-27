package com.yash.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Questions;
import com.yash.model.Subject;
import com.yash.repository.QuestionRepo;
import com.yash.repository.SubjectRepo;

@Service//(value = "questionDAOImpl")
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private QuestionRepo repo;
	
	@Autowired
	private SubjectRepo srepo;

	public List<Questions>  getAllQuestions() {
		
		List<Questions> queslst = repo.findAll();
		
		return queslst;
		
	}

	@Override
	public List<Questions> getQuestionsById(int subID) {
		
		return repo.getQuesBySubID(subID);
	}
	
	@Override
	public void deleteQues(int no)
	{
		repo.deleteById(no);
	}

	@Override
	public Questions addQuestion(int id,Questions ques) {
	/*	return srepo.findById(id).map(sub-> { ques.setSub(sub);
							return repo.save(ques);
							}).orElseThrow(()->new ResourceNotFoundException("Subject not found"));
		*/
		Optional<Subject> subOpt= srepo.findById(id);
		Subject sub=subOpt.get();
		
		///tie Subject to Questions
		ques.setSub(sub);
		Questions question=repo.save(ques);
		
		///tie Questions to Subject
		Subject subObj=new Subject();
		Set<Questions> setQues=new HashSet<Questions>();
		setQues.add(question);
		subObj.setQue(setQues);
		
		return question;
		
	}
	
	/*public Questions addQues(Questions ques)
	{
		return repo.save(ques);
	}

	*/
	
	@Override
	public Questions updateQuestion(int id, Questions ques)
	{
		Optional<Subject> subOpt=srepo.findById(id);
		Subject sub=subOpt.get();
		
		///tie Subject to Questions
		ques.setSub(sub);
		Questions question=repo.save(ques);
		
		///tie Questions to Subject
		Subject subObj=new Subject();
		Set<Questions> setQues=new HashSet<Questions>();
		setQues.add(question);
		subObj.setQue(setQues);
		
		return question;
	}
}
