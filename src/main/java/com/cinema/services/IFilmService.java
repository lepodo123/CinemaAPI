package com.cinema.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cinema.dto.FilmDTO;

public interface IFilmService {
	List<FilmDTO> findAll(Pageable pageable) throws SQLException ;
	int totalItem();
}
