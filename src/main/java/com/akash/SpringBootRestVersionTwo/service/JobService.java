package com.akash.SpringBootRestVersionTwo.service;

import com.akash.SpringBootRestVersionTwo.model.JobPost;
import com.akash.SpringBootRestVersionTwo.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobPost> returnAllJob() {
        return jobRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public JobPost getJob(int PostId) {
        return jobRepository.findById(PostId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepository.save(jobPost);
    }

    public void deleteJobPost(int postId) {
        jobRepository.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping")),
                        new JobPost(5, "Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));
        jobRepository.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return jobRepository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
