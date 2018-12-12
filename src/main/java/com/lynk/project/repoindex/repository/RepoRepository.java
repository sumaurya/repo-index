package com.lynk.project.repoindex.repository;

import com.lynk.project.repoindex.pojo.Repository;
import org.springframework.data.repository.CrudRepository;

public interface RepoRepository extends CrudRepository<Repository, Integer> {

}