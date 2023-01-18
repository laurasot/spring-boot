package com.laurasoto.WaterBnB.servicios;

import org.springframework.stereotype.Service;

import com.laurasoto.WaterBnB.modelos.Review;
import com.laurasoto.WaterBnB.repositorios.ReviewRepositorio;

@Service
public class ReviewServicio {
	private final ReviewRepositorio reviewRepositorio;
	public ReviewServicio(ReviewRepositorio reviewRepositorio){
		this.reviewRepositorio = reviewRepositorio;
	}
	public Review guardaReview(Review nuevaReview){
		return reviewRepositorio.save(nuevaReview);
	}
}
