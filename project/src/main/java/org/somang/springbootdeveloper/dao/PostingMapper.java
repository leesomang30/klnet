package org.somang.springbootdeveloper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.somang.springbootdeveloper.DTO.Posting;
import org.somang.springbootdeveloper.DTO.Reply;

import java.util.List;

@Mapper
public interface PostingMapper {

    List<Posting> selectListPostingA();

    Posting selectPostingA(String seq);

    void increaseHits(String seq);

    int insertContentA(Posting posting);

    int insertReplyA(Reply reply);

    List<Reply> selectReplyA(String seq);

    int increaseUpVote(String seq);

    Reply selectReplyAjax(Reply reply);

    int deleteReplyAjax(Reply reply);

}
