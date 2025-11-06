package com.example.springplannerproject.service;

import com.example.springplannerproject.dto.*;
import com.example.springplannerproject.entity.Plan;
import com.example.springplannerproject.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<GetPlanResponse> findAll() {
        List<Plan> plans = planRepository.findAll();

        List<GetPlanResponse> dtos = new ArrayList<>();
        for (Plan plan : plans) {
            dtos.add(new GetPlanResponse(plan.getId(), plan.getTitle(), plan.getWriter(), plan.getContents(), plan.getCreatedAt(), plan.getModifiedAt()));
        }
        return dtos;
    }

//    @Transactional(readOnly = true)
//    public List<GetPlanResponse> findByWriter(String writer) {
//        List<Plan> plans = planRepository.findAll();
//
//        List<GetPlanResponse> dtos = new ArrayList<>();
//        for (Plan plan : plans) {
//            if (plan.getWriter() == writer) {
//                dtos.add(new GetPlanResponse(plan.getId(), plan.getTitle(), plan.getWriter(), plan.getContents(), plan.getCreatedAt(), plan.getModifiedAt()));
//            }
//        }
//        return dtos;
//    }

    @Transactional
    public UpdatePlanResponse updatePlan(Long id, UpdatePlanRequest request) {
        Plan plan = planRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 플랜입니다.")
        );

        if (request.getPassword().equals(plan.getPassword())) {
            if (request.getTitle() != null) plan.updateTitle(request.getTitle());
            if (request.getWriter() != null) plan.updateWriter(request.getWriter());
        }

        return new UpdatePlanResponse(
                plan.getId(),
                plan.getTitle(),
                plan.getContents(),
                plan.getWriter(),
                plan.getCreatedAt(),
                plan.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long id) {
        boolean existence = planRepository.existsById(id);

        if (!existence) {
            throw new IllegalStateException("없는 플랜입니다.");
        }

        planRepository.deleteById(id);
    }
}