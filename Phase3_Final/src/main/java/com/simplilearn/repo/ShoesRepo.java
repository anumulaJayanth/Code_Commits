package com.simplilearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.SportShoes;
import com.simplilearn.model.User;

@Repository
public interface ShoesRepo extends CrudRepository<SportShoes, Integer> {

	@Query("SELECT s FROM SportShoes s WHERE CONCAT(s.shoetype, ' ', s.gender, ' ', s.size, ' ', s.color, ' ', s.price, ' ') LIKE %?1%")
	public List<SportShoes> search(String keyword);
}