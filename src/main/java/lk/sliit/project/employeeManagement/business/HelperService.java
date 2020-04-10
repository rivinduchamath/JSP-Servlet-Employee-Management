package lk.sliit.project.employeeManagement.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HelperService<C> {
	List<C> findAllEmployees();
	
	Page<C> findAll(Pageable pageable);
	
	Page<C> findAll(Long id, Pageable pageable);
	
	C findOne(Long id);
	
	String save(C type);
	
	String deleteUser(int id);
}
