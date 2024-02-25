package com.doku.wallet.repository;

import com.doku.wallet.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, String> {}
