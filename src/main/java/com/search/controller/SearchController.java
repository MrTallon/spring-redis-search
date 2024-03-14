package com.search.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.search.service.RedisSearchService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final RedisSearchService redisSearchService;

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

    @PostMapping("/student/search")
    public Map<String, Object> search(@RequestBody @Validated SearchReq req) {
        return redisSearchService.search(req.getQuery(), req.getOffset(), req.getLimit(), req.getSortBy(), req.getAscending());
    }

    @GetMapping("/movies/group_by/{field}")
    public Map<String, Object> getMovieGroupBy(@PathVariable("field") String field) {
        return redisSearchService.getMovieGroupBy(field);
    }

    @GetMapping("/movies/search_with_command")
    public Map<String, Object> searchWithJedisCommand(
        @RequestParam(name = "q") String query,
        @RequestParam(name = "offset", defaultValue = "0") int offset,
        @RequestParam(name = "limit", defaultValue = "10") int limit,
        @RequestParam(name = "sortby", defaultValue = "") String sortBy,
        @RequestParam(name = "ascending", defaultValue = "true") boolean ascending) {
        return redisSearchService.searchWithJedisCommand(query, offset, limit, sortBy, ascending);
    }

    @GetMapping("/movies/{movieId}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> getMOvieById(@PathVariable("movieId") String movieId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "This movie endpoint is not implemented in Java, use the Node.js Endpoint");
        return result;
    }

    ;

    @PostMapping("/movies/{movieId}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> saveMovie(@PathVariable("movieId") String movieId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "This movie endpoint is not implemented in Java, use the Node.js Endpoint");
        return result;
    }

    ;

    @GetMapping("/movies/{movieId}/comments")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> getMovieComments(@PathVariable("movieId") String movieId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "Comment API not implemented in Java, use the Node.js Endpoint");
        return result;
    }

    ;

    @PostMapping("/movies/{movieId}/comments")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> createMovieComments(@PathVariable("movieId") String movieId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "Comment API not implemented in Java, use the Node.js Endpoint");
        return result;
    }

    @GetMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> getCommentById(@PathVariable("commentId") String commentId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "Comment API not implemented in Java, use the Node.js Endpoint");
        return result;
    }

    @DeleteMapping("/comments/{commentId}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Map<String, Object> deleteCommentById(@PathVariable("commentId") String commentId) {
        Map<String, Object> result = new HashMap<>();
        result.put("messsage", "Comment API not implemented in Java, use the Node.js Endpoint");
        return result;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchReq{
        @NotBlank
        private String query;
        @Builder.Default
        private Integer offset = 0;

        @Builder.Default
        private Integer limit = 10;

        private String sortBy;

        @Builder.Default
        private Boolean ascending = true;
    }
}
