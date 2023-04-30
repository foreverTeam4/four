package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.addCommentDto;
import com.hlkw.cafe.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    public boolean save(Comment comment);

    public boolean modify(addCommentDto dto);
    public boolean remove(Comment comment);

}
