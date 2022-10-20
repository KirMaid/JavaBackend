package com.example.backend.repository;

import com.example.backend.model.Shawarma;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShawarmaRepository extends PagingAndSortingRepository<Shawarma,Long> {
}
