package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //게시글 작성
    public void write(Board board){

        boardRepository.save(board);
    }

    //게시글 리스트
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);

    }

    //게시글 보기
    public Board boardView(Long boardId) {

        return boardRepository.findById(boardId).get();
//                .orElseThrow(() -> new RuntimeException("업는 id 입니다."));

    }

    //글 삭제
    public void boardDelete(Long boardId) {

        boardRepository.deleteById(boardId);
    }

    


}
