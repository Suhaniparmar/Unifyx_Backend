package org.example.unifyx.controller;

import org.example.unifyx.Model.Post;
import org.example.unifyx.service.WorkerHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/worker/home")
public class WorkerHomeController {

    @Autowired
    private WorkerHomeService workerHomeService;


    @GetMapping("/{workerId}/posts")
    public ResponseEntity<List<Post>> getWorkerHomePosts(@PathVariable int workerId) {
        List<Post> matchingPosts = workerHomeService.getMatchingPostsForWorker(workerId);

        if (matchingPosts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(matchingPosts);
    }

}
