package com.sysmap.socialNetwork.services.post;

import com.sysmap.socialNetwork.entities.Post;
import com.sysmap.socialNetwork.entities.User;
import com.sysmap.socialNetwork.services.comment.CreateCommentRequest;
import com.sysmap.socialNetwork.services.comment.DeleteCommentRequest;
import com.sysmap.socialNetwork.services.comment.UpdateCommentRequest;
import com.sysmap.socialNetwork.services.like.LikeAndUnlikeCommentRequest;
import com.sysmap.socialNetwork.services.like.LikeAndUnlikePostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    //String createPost(CreatePostRequest request, List<MultipartFile> photo);
    String createPost(CreatePostRequest request);
    String updatePost(String postId, UpdatePostRequest request);
    String deletePost(String postId);
    FindPostResponse findPostById(String id);
    FindAllPostsResponse getAllPosts();
    FeedResponse feed(String userId);
    String createComment(String postId, CreateCommentRequest request);
    String updateComment(UpdateCommentRequest request);
    String deleteComment(DeleteCommentRequest request);
    List<UUID> LikeAndUnlikePost(String postId, LikeAndUnlikePostRequest request);
    List<UUID> LikeAndUnlikeComment(LikeAndUnlikeCommentRequest request);

}
