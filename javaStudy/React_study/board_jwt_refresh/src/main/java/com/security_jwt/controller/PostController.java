package com.security_jwt.controller;

import com.security_jwt.data.dto.PostDTO;
import com.security_jwt.data.dto.PostSaveDTO;
import com.security_jwt.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping(value = "/postlist")
    public ResponseEntity<List<PostDTO>> postlist() {
        List<PostDTO> postDTOS = this.postService.getAllPosts();
        if(postDTOS == null || postDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(postDTOS);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<PostDTO> savepost(@RequestBody PostSaveDTO postSaveDTO) {
        PostDTO postDTO = this.postService.savePost(postSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postDTO);
    }

    @PutMapping(value = "/post")
    public ResponseEntity<PostDTO> updatepost(@RequestBody PostDTO postDTO) {
        PostDTO updatedPostDTO = this.postService.updatePost(postDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPostDTO);
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<String> deletepost(@PathVariable Integer id) {
        this.postService.deletePost(id);
        return ResponseEntity.ok("삭제성공");
    }
}
