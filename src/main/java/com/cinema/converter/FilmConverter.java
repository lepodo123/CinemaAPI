package com.cinema.converter;




import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.cinema.dto.FilmDTO;
import com.cinema.entity.FilmEntity;


@Component
public class FilmConverter {
	
	public String byteToString(byte[] bdata){
		String str = new String(bdata);
		return str;
	}
	

	
	public FilmEntity toEntity(FilmDTO filmDTO) throws SQLException {
		FilmEntity entity = new FilmEntity();
		entity.setTitle(filmDTO.getTitle());
		entity.setLength(filmDTO.getLength());
		entity.setReleaseDate(filmDTO.getReleaseDate());
		entity.setActor(filmDTO.getActor());
		entity.setDirector(filmDTO.getDirector());
		entity.setDescribe(filmDTO.getDescribe().getBytes());
		entity.setPosters(filmDTO.getPosters().getBytes());
		return entity;
	}
	public FilmDTO toDTO(FilmEntity filmEntity) throws SQLException {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO.setTitle(filmEntity.getTitle());
		filmDTO.setLength(filmEntity.getLength());
		filmDTO.setReleaseDate(filmEntity.getReleaseDate());
		filmDTO.setActor(filmEntity.getActor());
		filmDTO.setDirector(filmEntity.getDirector());
		filmDTO.setDescribe(byteToString(filmEntity.getDescribe()));
		filmDTO.setPosters(byteToString(filmEntity.getPosters()));
		return filmDTO;
	}
}
