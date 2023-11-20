package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.FilmEntity;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

}
