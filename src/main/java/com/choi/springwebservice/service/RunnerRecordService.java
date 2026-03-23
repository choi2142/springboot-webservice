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
        return runnerRecordRepository.save(runnerRecord);
    }

    @Transactional(readOnly = true)
    public List<RunnerRecord> getAllRunnerRecords() {
        return runnerRecordRepository.findAll();
    }
}