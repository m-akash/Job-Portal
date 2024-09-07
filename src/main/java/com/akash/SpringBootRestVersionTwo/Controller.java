package com.akash.SpringBootRestVersionTwo;

import com.akash.SpringBootRestVersionTwo.model.JobPost;
import com.akash.SpringBootRestVersionTwo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> allJobs() {
        return jobService.returnAllJob();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJobPost(@RequestBody JobPost jobPost){
        jobService.addJobPost(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobPost(@PathVariable("postId") int postId) {
        jobService.deleteJobPost(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);
    }

    @GetMapping("load")
    public String load(){
        jobService.load();
        return "Success";
    }
}
