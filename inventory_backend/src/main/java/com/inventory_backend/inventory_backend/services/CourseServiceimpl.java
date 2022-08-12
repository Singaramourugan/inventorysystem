package com.springrest.springrest.services;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.*;
@Service
public class CourseServiceimpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	public CourseServiceimpl() {
//		list=new ArrayList<>();
	//	list.add(new Course(145,"java core Course","This course contain the core of java"));
	}
	@Override
	public List<Course> getCourse()
	{
		return courseDao.findAll();
		
	}
	@Override
	public Course getCourse(long courseId) {
	//	Course c=null;
		//for(Course course:list)
		//{
			//if(course.getId()==courseId)
			//{
			//	c=course;
			//	break;
			//}
		//}
		
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
	//	list.forEach(e -> {
	//		if (e.getId()== course.getId()) {
	//			e.setTitle(course.getTitle());
	//			e.setDescription(course.getDescription());
	//		}
	//	});
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
	//	list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collector.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
