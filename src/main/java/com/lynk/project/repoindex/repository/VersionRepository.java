package com.lynk.project.repoindex.repository;

import com.lynk.project.repoindex.pojo.Project;
import com.lynk.project.repoindex.pojo.Version;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VersionRepository extends CrudRepository<Version, Integer> {

    @Query(value = "select * from version where project_id=:projectID", nativeQuery = true)
    public List<Version> findByProjectId(@Param("projectID") int repositoryID);

    @Query(value = "select url from version", nativeQuery = true)
    public List<String> findAllUrl();

}