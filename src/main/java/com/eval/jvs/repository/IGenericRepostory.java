package com.eval.jvs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepostory<T,ID> extends JpaRepository<T,ID> {
    
}
