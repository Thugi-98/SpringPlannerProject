package com.example.springplannerproject.service;

import com.example.springplannerproject.dto.CreatePlanRequest;
import com.example.springplannerproject.dto.CreatePlanResponse;
import com.example.springplannerproject.dto.GetPlanResponse;
import com.example.springplannerproject.entity.Plan;
import com.example.springplannerproject.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    @Transactional
    public CreatePlanResponse createPlan(CreatePlanRequest request) {
        Plan plan = new Plan(request.getTitle(), request.getContents(), request.getWriter(), request.getPassword());
        Plan savedPlan = planRepository.save(plan);

        return new CreatePlanResponse(
                savedPlan.getId(),
                savedPlan.getTitle(),
                savedPlan.getContents(),
                savedPlan.getWriter(),
                savedPlan.getCreatedAt(),
                savedPlan.getModifiedAt()
        );

    }

    @Transactional(readOnly = true)
    public GetPlanResponse findOne(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetPlanResponse(
                plan.getId(),
                plan.getTitle(),
                plan.getContents(),
                plan.getWriter(),
                plan.getCreatedAt(),
                plan.getModifiedAt()
        );
    }
}
