package com.cinema.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cinema.converter.FilmConverter;
import com.cinema.dto.FilmDTO;
import com.cinema.entity.FilmEntity;
import com.cinema.repository.FilmRepository;
import com.cinema.services.IFilmService;

@Service
public class FilmService implements IFilmService{
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmConverter filmConverter;

	@Override
	public List<FilmDTO> findAll(Pageable pageable) throws SQLException {
		List<FilmDTO> resuls = new ArrayList<>();
		List<FilmEntity> entities = filmRepository.findAll(pageable).getContent();
		for(FilmEntity entity : entities) {
			FilmDTO filmDto = filmConverter.toDTO(entity);
			resuls.add(filmDto);
		}
		return resuls;
	}

	@Override
	public int totalItem() {
		return (int)filmRepository.count();
	}
	
}
