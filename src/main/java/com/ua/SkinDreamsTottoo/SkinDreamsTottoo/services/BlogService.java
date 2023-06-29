package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.BlogDTO;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Blog;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class BlogService {


    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BlogService(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

    public List<Blog> findAllBlogs(){
        log.info("Found all the blog text");
        return blogRepository.findAll();
    }

    public Blog findBlogByTitle(String title){
        log.info("Found blog by Title");
        return blogRepository.findByTitle(title);
    }

    @Transactional
    public void saveBlog(Blog blog){
        blog.setRegistrationTime(LocalDateTime.now());
        log.info("Save new blog");
        blogRepository.save(blog);
    }

    @Transactional
    public void deleteBlogByTitle(String title){
        log.info("deleted blog by title");
        blogRepository.deleteByTitle(title);
    }


    @Transactional
    public Blog updateBlog(Blog updatingBlog){
        log.info("Update blog");
        return blogRepository.save(updatingBlog);
    }


    public Blog convertBlogDTOToBlog(BlogDTO blogDTO ){
        return modelMapper.map(blogDTO, Blog.class);
    }

    public BlogDTO convertClientToClientDTO(Blog blog){
        return modelMapper.map(blog, BlogDTO.class);
    }

}
