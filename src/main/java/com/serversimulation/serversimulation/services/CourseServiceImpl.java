package com.serversimulation.serversimulation.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serversimulation.serversimulation.dao.CourseDao;
import com.serversimulation.serversimulation.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {	
	}
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {		
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long courseId) {
		courseDao.delete(courseDao.getOne(courseId));
	}

}
