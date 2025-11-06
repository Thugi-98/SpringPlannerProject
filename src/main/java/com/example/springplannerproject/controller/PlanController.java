package com.example.springplannerproject.controller;

import com.example.springplannerproject.dto.*;
import com.example.springplannerproject.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/plans")
    public ResponseEntity<List<GetPlanResponse>> getAllPlan() {
        return ResponseEntity.status(HttpStatus.OK).body(planService.findAll());
    }

//    @RequestMapping("/plans")
//    public ResponseEntity<List<GetPlanResponse>> getPlanByWriter(@RequestParam String writer) {
//        return ResponseEntity.status(HttpStatus.OK).body(planService.findByWriter(writer));
//    }

    @GetMapping("/plans/{id}")
    public ResponseEntity<GetPlanResponse> getOnePlan(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(planService.findOne(id));
    }

    @PatchMapping("/plans/{id}")
    public ResponseEntity<UpdatePlanResponse> updatePlan(
            @PathVariable Long id,
            @RequestBody UpdatePlanRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(planService.updatePlan(id, request));
    }

    @DeleteMapping("/plans/{id}")
    public ResponseEntity<Void> deleteMemo(
            @PathVariable Long id,
            @RequestBody DeletePlanRequest request
    ) {
        planService.delete(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}