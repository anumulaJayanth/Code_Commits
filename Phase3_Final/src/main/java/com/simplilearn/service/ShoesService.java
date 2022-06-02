package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.SportShoes;
import com.simplilearn.repo.ShoesRepo;

@Service
public class ShoesService {

    @Autowired
    private ShoesRepo sportShoesRepo;

    @PostConstruct
    public void preAddSportShoes()
    {
    	sportShoesRepo.save(new SportShoes("Leather","Male",6,"Grey",99.99));
    	sportShoesRepo.save(new SportShoes("Formal","Female",6.5,"Yellow",89.99));
    	sportShoesRepo.save(new SportShoes("Tennis","Female",9.5,"Orange",29.99));
    	sportShoesRepo.save(new SportShoes("Soccer","Boy",6,"Grey",39.99));
    	sportShoesRepo.save(new SportShoes("Leather","Male",9,"Pink",99.99));
    }
    
    public List<SportShoes> searchShoes(String keyword) {
    	System.out.println("Keyword: "+ keyword);
        if (keyword != null) {
            return sportShoesRepo.search(keyword);
        }
        System.out.println("Retutning allllllllllll"+sportShoesRepo.findAll());
        return (List<SportShoes>) sportShoesRepo.findAll();
    }

    public List<SportShoes> retrieveSportShoes() {

    	List<SportShoes> filteredSportShoes = (List<SportShoes>) sportShoesRepo.findAll();
        return filteredSportShoes;
    }
    
    public SportShoes retrieveSportShoes(int id) {
    	
    	Optional<SportShoes> sportShoes = sportShoesRepo.findById(id);

		if (sportShoes.isPresent()) {
			return sportShoes.get();
		}

        return null;
    }

    public void updateSportShoes(SportShoes sportShoes){

    	Optional<SportShoes> currentSportShoes = sportShoesRepo.findById(sportShoes.getId());

		if (currentSportShoes.isPresent()) {
			System.out.println("Updating "+ currentSportShoes.get());
			sportShoesRepo.save(sportShoes);
		}
    }

    public void addSportShoes(String shoetype, String gender, double size, String color, double price) {

    	sportShoesRepo.save(new SportShoes(shoetype, gender, size, color, price));
    }

}