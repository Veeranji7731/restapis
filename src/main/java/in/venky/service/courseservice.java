package in.venky.service;

import java.util.List;

import in.venky.binding.course;

public interface courseservice {
public String upsert(course c);
public course getbyid(Integer id);
public List<course> getallcourses();
public String deletebyid(Integer id);

}
