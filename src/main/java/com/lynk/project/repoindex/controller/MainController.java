package com.lynk.project.repoindex.controller;

import com.lynk.project.repoindex.request.AddRepositoryRequest;
import com.lynk.project.repoindex.request.FetchPackageDetailsRequest;
import com.lynk.project.repoindex.response.AddRepositoryResponse;
import com.lynk.project.repoindex.response.AvailableRepositoriesResponse;
import com.lynk.project.repoindex.response.FetchPackageDetailsResponse;
import com.lynk.project.repoindex.service.ListingPageService;
import com.lynk.project.repoindex.service.RepositoryService;
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
}