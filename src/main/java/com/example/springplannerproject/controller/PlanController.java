package com.example.springplannerproject.controller;

import com.example.springplannerproject.dto.CreatePlanRequest;
import com.example.springplannerproject.dto.CreatePlanResponse;
import com.example.springplannerproject.dto.GetPlanResponse;
import com.example.springplannerproject.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping("/plans")
    public ResponseEntity<CreatePlanResponse> createPlan(
            @RequestBody CreatePlanRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.createPlan(request));
    }

    @GetMapping("/plans/{id}")
    public ResponseEntity<GetPlanResponse> getPlan(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(planService.findOne(id));
    }

}
