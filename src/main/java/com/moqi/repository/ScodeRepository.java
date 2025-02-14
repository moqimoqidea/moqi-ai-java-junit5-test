package com.moqi.repository;

import com.moqi.model.Scode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScodeRepository extends JpaRepository<Scode, Long> {
} 