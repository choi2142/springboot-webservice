package com.choi.springwebservice.web;

import com.choi.springwebservice.domain.runner.RunnerRecord;
import com.choi.springwebservice.service.RunnerRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<RunnerRecord>> getAllRunnerRecords() {
        List<RunnerRecord> records = runnerRecordService.getAllRunnerRecords();
        return ResponseEntity.ok(records);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}