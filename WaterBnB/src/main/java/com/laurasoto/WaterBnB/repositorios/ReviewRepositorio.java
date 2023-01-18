package com.laurasoto.WaterBnB.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laurasoto.WaterBnB.modelos.Review;


@Repository
public interface ReviewRepositorio extends CrudRepository<Review, Long>{

}
