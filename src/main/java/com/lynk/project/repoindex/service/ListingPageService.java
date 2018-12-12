package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.pojo.Author;
import com.lynk.project.repoindex.pojo.Project;
import com.lynk.project.repoindex.pojo.Repository;
import com.lynk.project.repoindex.pojo.Version;
import com.lynk.project.repoindex.repository.AuthorRepository;
import com.lynk.project.repoindex.repository.ProjectRepository;
import com.lynk.project.repoindex.repository.RepoRepository;
import com.lynk.project.repoindex.repository.VersionRepository;
import com.lynk.project.repoindex.request.FetchPackageDetailsRequest;
import com.lynk.project.repoindex.response.FetchPackageDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListingPageService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RepoRepository repoRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public FetchPackageDetailsResponse handleFetchPackageDetails(FetchPackageDetailsRequest request) {
        FetchPackageDetailsResponse fetchPackageDetailsResponse = new FetchPackageDetailsResponse();
        try {
            Repository repository = repoRepository.findById(request.getRepositoryId()).orElse(null);
            if(repository == null)
                throw new Exception("invalid repo id...");

            fetchPackageDetailsResponse.setRepository(repository);

            Map<Project, Map<Version, List<Author>>> responseMap = new HashMap<>();
            List<Project> projects = projectRepository.findByRepositoryId(repository.getId());

            for(Project project : projects) {
                Map<Version, List<Author>> versionAuthorMap = new HashMap<>();

                List<Version> versions = versionRepository.findByProjectId(project.getId());
                for(Version version : versions) {
                    List<Author> authors = authorRepository.findByVersionId(version.getId());
                    versionAuthorMap.put(version, authors);
                }

                responseMap.put(project, versionAuthorMap);
            }
            fetchPackageDetailsResponse.setResponse(responseMap);
            fetchPackageDetailsResponse.setStatus("Success");
        } catch (Exception e) {
            fetchPackageDetailsResponse.setStatus("Failure");
        }
        return fetchPackageDetailsResponse;
    }
}
