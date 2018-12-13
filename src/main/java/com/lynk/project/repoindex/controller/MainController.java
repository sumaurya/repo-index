package com.lynk.project.repoindex.controller;

import com.lynk.project.repoindex.request.AddRepositoryRequest;
import com.lynk.project.repoindex.request.FetchByProjectTitlePatternRequest;
import com.lynk.project.repoindex.request.FetchPackageDetailsRequest;
import com.lynk.project.repoindex.request.UpdateRepositoryRequest;
import com.lynk.project.repoindex.response.*;
import com.lynk.project.repoindex.service.ListingPageService;
import com.lynk.project.repoindex.service.RepositoryService;
import com.lynk.project.repoindex.service.SearchProjectService;
import com.lynk.project.repoindex.service.UpdateRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method=RequestMethod.GET, value={"/"})
public class MainController {

    @Autowired
    private ListingPageService listingPageService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private UpdateRepositoryService updateRepositoryService;

    @Autowired
    private SearchProjectService searchProjectService;

    @GetMapping(path="availableRepositories")
    public @ResponseBody AvailableRepositoriesResponse getAvailableRepositories() {
        return repositoryService.handeleAvailableRepositories();
    }

    @PostMapping(path = "addRepository")
    public @ResponseBody AddRepositoryResponse addRepository(@RequestBody AddRepositoryRequest request) {
        return repositoryService.handleAddRepository(request);
    }

    @PostMapping(path = "fetchPackageDetails")
    public @ResponseBody FetchPackageDetailsResponse fetchPackageDetails(@RequestBody FetchPackageDetailsRequest request) {
        return listingPageService.handleFetchPackageDetails(request);
    }

    @PostMapping(path = "updateRepository")
    public @ResponseBody UpdateRepositoryResponse updateRepository(@RequestBody UpdateRepositoryRequest request) {
        return updateRepositoryService.handleRequest(request);
    }

    @PostMapping(path = "fetchByProjectTitlePattern")
    public @ResponseBody FetchByProjectTitlePatternResponse fetchByProjectTitlePattern(@RequestBody FetchByProjectTitlePatternRequest request) {
        return searchProjectService.handleRequest(request);
    }
}