package com.serversimulation.serversimulation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serversimulation.serversimulation.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
