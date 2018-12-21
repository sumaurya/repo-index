package com.lynk.project.repoindex.controller;

import com.lynk.project.repoindex.request.AddRepositoryRequest;
import com.lynk.project.repoindex.request.FetchByProjectTitlePatternRequest;
import com.lynk.project.repoindex.request.UpdateRepositoryRequest;
import com.lynk.project.repoindex.response.*;
import com.lynk.project.repoindex.service.ListingPageService;
import com.lynk.project.repoindex.service.RepositoryService;
import com.lynk.project.repoindex.service.SearchProjectService;
import com.lynk.project.repoindex.service.UpdateRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(method=RequestMethod.GET, value={"/"})
public class MainController implements Filter {

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

    @GetMapping(path = "fetchPackageForRepository")
    public @ResponseBody
    FetchPackageForRepositoryResponse fetchPackageForRepository(@RequestParam("id") String repoId) {
        return listingPageService.handleFetchPackageForRepository(repoId);
    }

    @GetMapping(path = "fetchVersionsForPackage")
    public @ResponseBody
    FetchVersionsForPackageResponse fetchVersionsForPackage(@RequestParam("id") String packageId) {
        return listingPageService.handleFetchVersionsForPackage(packageId);
    }

    @GetMapping(path = "fetchAuthorsForVersion")
    public @ResponseBody
    FetchAuthorForVersionResponse fetchAuthorsForVersion(@RequestParam("id") String versionId) {
        return listingPageService.handleFetchAuthorForVersion(versionId);
    }

    @PostMapping(path = "updateRepository")
    public @ResponseBody UpdateRepositoryResponse updateRepository(@RequestBody UpdateRepositoryRequest request) {
        return updateRepositoryService.handleRequest(request);
    }

    @PostMapping(path = "fetchByProjectTitlePattern")
    public @ResponseBody FetchByProjectTitlePatternResponse fetchByProjectTitlePattern(@RequestBody FetchByProjectTitlePatternRequest request) {
        return searchProjectService.handleRequest(request);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader(
                "Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}