package com.lynk.project.repoindex.service;

import com.lynk.project.repoindex.repository.ProjectRepository;
import com.lynk.project.repoindex.request.FetchByProjectTitlePatternRequest;
import com.lynk.project.repoindex.response.FetchByProjectTitlePatternResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public FetchByProjectTitlePatternResponse handleRequest(FetchByProjectTitlePatternRequest request) {
        FetchByProjectTitlePatternResponse fetchByProjectTitlePatternResponse = new FetchByProjectTitlePatternResponse();
        try {
            fetchByProjectTitlePatternResponse.setProjects(projectRepository.findByTitleContaining(request.getPatternString()));
            fetchByProjectTitlePatternResponse.setStatus("Success");
        } catch (Exception e) {
            fetchByProjectTitlePatternResponse.setStatus("Failure");
        }
        return fetchByProjectTitlePatternResponse;
    }
}
