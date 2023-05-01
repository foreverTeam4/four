package com.hlkw.cafe.service;

import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;


}
