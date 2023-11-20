package com.cinema.api;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.api.output.FilmOutput;
import com.cinema.services.impl.FilmService;



@CrossOrigin
@RestController
public class FilmAPI {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping(value = "/cinema")
	public FilmOutput showEmployees(@RequestParam("page") int page, 
										@RequestParam("limit") int limit) throws SQLException 
	{
		FilmOutput result = new FilmOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page-1, limit);
		result.setListResult(filmService.findAll(pageable));
		result.setTotalPage((int)Math.ceil((double) (filmService.totalItem())/limit));
		return result;
	}
	
}
