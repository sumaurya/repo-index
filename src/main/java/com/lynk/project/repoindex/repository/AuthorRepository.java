package com.lynk.project.repoindex.repository;

import com.lynk.project.repoindex.pojo.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    @Query(value = "select * from author where version_id=:versionID", nativeQuery = true)
    public List<Author> findByVersionId(@Param("versionID") int versionID);

}