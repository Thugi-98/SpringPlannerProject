package com.example.springplannerproject.repository;

import com.example.springplannerproject.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}