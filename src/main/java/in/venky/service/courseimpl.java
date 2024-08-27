package in.venky.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.venky.binding.course;
import in.venky.repo.courserepo;
@Service
public class courseimpl implements courseservice{
	
	@Autowired
    private courserepo cr;
	
	@Override
	public String upsert(course c) {
		cr.save(c);
		
		return "sucess";
	}

	@Override
	public course getbyid(Integer id) {
		Optional<course> byId = cr.findById(id);
		if(byId.isPresent()) {
			return byId.get();
	}
     return null;
 }
    @Override
	public List<course> getallcourses() {
		List<course> findAll = cr.findAll();
		return findAll;
	}

	@Override
	public String deletebyid(Integer id) {
		if(cr.existsById(id)) {
			cr.deleteById(id);
			return "sucess";
		}else {
			return "no record";
			
		}
	}
}
