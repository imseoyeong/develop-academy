package com.security_jwt.service;

import com.security_jwt.data.dao.PostDAO;
import com.security_jwt.data.dto.PostDTO;
import com.security_jwt.data.dto.PostSaveDTO;
import com.security_jwt.data.entity.PostEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDAO postDAO;

    public List<PostDTO> getAllPosts() {
        List<PostEntity> entityPosts = postDAO.getAllPosts();
        if(entityPosts==null){
            return null;
        }
        List<PostDTO> dtos = new ArrayList<>();
        for(PostEntity entity : entityPosts){
            PostDTO dto = PostDTO.builder()
                    .postId(entity.getId())
                    .postTitle(entity.getTitle())
                    .postContent(entity.getContent())
                    .postUserName(entity.getUser().getUsername())
                    .postUserFullName(entity.getUserFullName()).build();
            dtos.add(dto);
        }
        return dtos;
    }

    public PostDTO getPostById(Integer id) {
        PostEntity entity = postDAO.getPostById(id);
        if(entity==null){
            throw new EntityNotFoundException("없는 포스트입니다.");
        }
        PostDTO postDTO = PostDTO.builder()
                .postId(entity.getId())
                .postTitle(entity.getTitle())
                .postContent(entity.getContent())
                .postUserName(entity.getUser().getUsername())
                .postUserFullName(entity.getUserFullName()).build();
        return postDTO;
    }

    public PostDTO savePost(PostSaveDTO postSaveDTO) {
        PostEntity postEntity = this.postDAO.savePost(postSaveDTO.getPostTitle(), postSaveDTO.getPostContent(), postSaveDTO.getPostUserName());
        PostDTO postDTO = PostDTO.builder()
                .postId(postEntity.getId())
                .postTitle(postEntity.getTitle())
                .postContent(postEntity.getContent())
                .postUserName(postEntity.getUser().getUsername())
                .postUserFullName(postEntity.getUserFullName()).build();
        return postDTO;
    }

    public PostDTO updatePost(PostDTO postDTO) {
        PostEntity postEntity = this.postDAO.getPostById(postDTO.getPostId());
        if(postEntity==null){
            throw new EntityNotFoundException("없는 포스트");
        }

        PostEntity updatePostEntity= this.postDAO.updatePost(postDTO.getPostId(), postDTO.getPostTitle(), postDTO.getPostContent());

        PostDTO updatePostDTO = PostDTO.builder()
                .postId(updatePostEntity.getId())
                .postTitle(updatePostEntity.getTitle())
                .postContent(updatePostEntity.getContent())
                .postUserName(updatePostEntity.getUser().getUsername())
                .postUserFullName(updatePostEntity.getUserFullName()).build();
        return updatePostDTO;
    }

    public void deletePost(Integer id) {
        PostEntity entity = postDAO.getPostById(id);
        if(entity==null){
            throw new EntityNotFoundException("없는 포스트");
        }
        postDAO.deletePost(id);
    }
}
