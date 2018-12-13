package com.lynk.project.repoindex.repository;

import com.lynk.project.repoindex.pojo.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    @Query(value = "select * from project where repository_id=:repositoryID", nativeQuery = true)
    public List<Project> findByRepositoryId(@Param("repositoryID") int repositoryID);

    public List<Project> findByTitleContaining(@Param("title") String title);
}