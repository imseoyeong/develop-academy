package com.security_jwt.data.dao;

import com.security_jwt.data.entity.AuthEntity;
import com.security_jwt.data.entity.PostEntity;
import com.security_jwt.data.repository.AuthRepository;
import com.security_jwt.data.repository.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDAO {
    private final PostEntityRepository postEntityRepository;
    private final AuthRepository authRepository;

    public List<PostEntity> getAllPosts() {
        return postEntityRepository.findAll();
    }

    public PostEntity getPostById(Integer id) {
       return this.postEntityRepository.findById(id).orElse(null);
    }

    public PostEntity savePost(String title, String content, String writerid ) {
        AuthEntity authEntity = authRepository.findByUsername(writerid);
        PostEntity postEntity = PostEntity.builder()
                .title(title)
                .content(content)
                .userFullName(authEntity.getUserfullname())
                .user(authEntity).build();
        return this.postEntityRepository.save(postEntity);
    }

    public PostEntity updatePost(Integer id, String title, String content) {
        PostEntity postEntity = this.postEntityRepository.findById(id).orElse(null);
        if(postEntity != null) {
            postEntity.setTitle(title);
            postEntity.setContent(content);
            return this.postEntityRepository.save(postEntity);
        }
        return null;
    }

    public boolean deletePost(Integer id) {
        if(this.postEntityRepository.existsById(id)) {
            this.postEntityRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
