package com.back_swing.back_swing.core.Grade;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_swing.back_swing.exceptions.ObjectNotFoundException;
import com.back_swing.back_swing.utils.ResponseController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/grade")
public class GradeController {
    
    private final GradeService gradeService;

    @GetMapping
    public Flux<Map<String, Object>> listAllGrades(){
        return gradeService.findAll()
            .switchIfEmpty(Flux.error(new ObjectNotFoundException("No grades found")))
            .map(grade -> ResponseController.createApiResponse(true, "Grade found", grade));
    }

    @PostMapping
    public Mono<Map<String,Object>> saveGrade(@RequestBody Grade grade){
        return gradeService.save(grade)
            .map(g -> ResponseController.createApiResponse(true, "save correct", g))
            .onErrorResume(e -> Mono.just(ResponseController.createApiResponse(false, "Error saving grade: " + e.getMessage(), null)));
    }
}
