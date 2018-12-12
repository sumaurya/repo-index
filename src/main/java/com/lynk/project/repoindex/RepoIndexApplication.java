package com.lynk.project.repoindex;

import com.lynk.project.repoindex.repository.AuthorRepository;
import com.lynk.project.repoindex.repository.ProjectRepository;
import com.lynk.project.repoindex.repository.RepoRepository;
import com.lynk.project.repoindex.repository.VersionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.lynk.project.repoindex"})
@EnableJpaRepositories(basePackageClasses = {RepoRepository.class, ProjectRepository.class, VersionRepository.class, AuthorRepository.class})
public class RepoIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoIndexApplication.class, args);
	}
}
