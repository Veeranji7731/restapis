package in.venky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.venky.binding.course;
import in.venky.service.courseservice;

@RestController
public class coursecontroller {
	
	@Autowired
	private courseservice cs;
	
    @PostMapping("/course")
	public ResponseEntity<String> createcourse(@RequestBody course c){
	String upsert = cs.upsert(c);
		return new ResponseEntity<String>(upsert, HttpStatus.CREATED);
		
	}
    @GetMapping("/course/{id}")
    public ResponseEntity<course> getcourse(@PathVariable Integer id){
    	course course = cs.getbyid(id);
    	return new ResponseEntity<course> (course, HttpStatus.OK);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<course>> getallcourses(){
    	List<course> list = cs.getallcourses();
    	return new ResponseEntity<> (list, HttpStatus.OK);
    }
    @PutMapping("/course")
   	public ResponseEntity<String> updatecourse(@RequestBody course c){
   	String upsert = cs.upsert(c);
   		return new ResponseEntity<String>(upsert, HttpStatus.OK);
    }
    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deletecourse(@PathVariable Integer id){
    	String s = cs.deletebyid(id);
    	return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
