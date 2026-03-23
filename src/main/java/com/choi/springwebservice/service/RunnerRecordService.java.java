package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.runner.RunnerRecord;
import com.choi.springwebservice.domain.runner.RunnerRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RunnerRecordService {

    private final RunnerRecordRepository runnerRecordRepository;

    @Transactional
    public RunnerRecord saveRunnerRecord(RunnerRecord runnerRecord) {
        validateRunnerRecord(runnerRecord);
        return runnerRecordRepository.save(runnerRecord);
    }

    @Transactional(readOnly = true)
    public List<RunnerRecord> getAllRunnerRecords() {
        return runnerRecordRepository.findAll();
    }

    private void validateRunnerRecord(RunnerRecord runnerRecord) {
        if (runnerRecord.getCompletionTime() <= 0) {
            throw new IllegalArgumentException("Completion time must be greater than zero.");
        }
        if (runnerRecord.getName() == null || runnerRecord.getName().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
    }
}