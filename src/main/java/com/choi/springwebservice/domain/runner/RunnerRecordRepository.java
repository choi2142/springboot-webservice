package com.choi.springwebservice.domain.runner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRecordRepository extends JpaRepository<RunnerRecord, Long> {
}