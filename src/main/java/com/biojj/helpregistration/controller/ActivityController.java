package com.biojj.helpregistration.controller;

import com.biojj.helpregistration.domain.Activity;
import com.biojj.helpregistration.domain.dtos.ActivityDTO;
import com.biojj.helpregistration.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    private final ActivityService activityService;


    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityDTO> findById(@PathVariable Integer id) {
        Activity obj = activityService.findById(id);
        return ResponseEntity.ok().body(new ActivityDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> findAll() {
        List<Activity> chamadoList = activityService.findAll();
        List<ActivityDTO> chamadoDTOList = chamadoList.stream().map(ActivityDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(chamadoDTOList);
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> create(@Valid @RequestBody ActivityDTO objDTO) {
        Activity obj = activityService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ActivityDTO> update(@PathVariable Integer id, @Valid @RequestBody ActivityDTO objDTO) {
        Activity obj = activityService.update(id, objDTO);
        return ResponseEntity.ok().body(new ActivityDTO(obj));
    }

}
