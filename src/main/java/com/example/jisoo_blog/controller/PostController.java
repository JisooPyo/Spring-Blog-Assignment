package com.example.jisoo_blog.controller;

import com.example.jisoo_blog.dto.PostRequestDto;
import com.example.jisoo_blog.dto.PostResponseDto;
import com.example.jisoo_blog.entity.Post;
import org.springframework.web.bind.annotation.*;

import javax.management.RuntimeErrorException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping( "/JisooBlog" )
public class PostController {

    private final Map< Long, Post > postList = new HashMap<>();

    @PostMapping( "/posts" )
    public PostResponseDto createPost( @RequestBody PostRequestDto requestDto ) {
        // RequestDto -> Entity
        Post post = new Post( requestDto );

        // Post Max ID Check -> Set ID
        Long maxId = postList.size() > 0 ? Collections.max( postList.keySet() ) + 1 : 1;
        post.setId( maxId );

        // Set Date
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd 'at' HH:mm:ss z" );
        Date now = new Date( System.currentTimeMillis() );
        String date = sdf.format( now );
        post.setDate( date );

        // DB 저장
        postList.put( post.getId(), post );

        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto( post );
        return postResponseDto;
    }

    @GetMapping( "/posts" )
    public List< PostResponseDto > getPosts() {
        // Map To List(id 역순으로 넣기)
        List< PostResponseDto > responseList = new ArrayList<>();
        // id값 중 가장 큰 값 구하기
        Long maxId = Collections.max( postList.keySet() );
        // 큰 값부터 작은 값까지 역순으로 list에 add
        for ( long i = maxId; i >= 1; i-- ) {
            if ( postList.get( i ) != null ) {
                responseList.add( new PostResponseDto( postList.get( i ) ) );
            }
        }

        return responseList;
    }

    // http://localhost:8080/JisooBlog/memos?id=1&password=1234
    @PutMapping( "/posts" )
    public void updatePost( @RequestParam Long id, @RequestParam String password, @RequestBody PostRequestDto requestDto ) {
        // 해당 글 DB에 존재하는 지 확인
        if ( !postList.containsKey( id ) ) {
            throw new IllegalArgumentException( "해당 글이 존재하지 않습니다." );
        }

        // password 확인하기
        if ( !( postList.get( id ).getPassword().equals( password ) ) ) {
            // 일단 무슨 예외를 던져야 할지 몰라 같은 예외로 던짐.. 추후 수정 필요
            throw new IllegalArgumentException( "password가 일치하지 않습니다." );
        }

        // 해당 글 가져오기
        Post post = postList.get( id );

        // 글 수정
        post.update( requestDto );

    }
}
