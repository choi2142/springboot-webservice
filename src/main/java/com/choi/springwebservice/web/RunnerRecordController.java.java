package com.choi.springwebservice.web;

import com.choi.springwebservice.domain.runner.RunnerRecord;
import com.choi.springwebservice.service.RunnerRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/runner-records")
public class RunnerRecordController {

    private final RunnerRecordService runnerRecordService;

    @PostMapping
    public ResponseEntity<RunnerRecord> saveRunnerRecord(@Valid @RequestBody RunnerRecord runnerRecord) {
        RunnerRecord savedRecord = runnerRecordService.saveRunnerRecord(runnerRecord);
        return ResponseEntity.ok(savedRecord);
    }

    @GetMapping
    public ResponseEntity<Page<RunnerRecord>> getAllRunnerRecords(Pageable pageable) {
        Page<RunnerRecord> records = runnerRecordService.getAllRunnerRecords(pageable);
        return ResponseEntity.ok(records);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}