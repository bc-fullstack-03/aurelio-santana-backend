package com.sysmap.socialNetwork.api;

import com.sysmap.socialNetwork.services.follow.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/user/follow")
public class FollowController {

    @Autowired
    private IFollowService _followService;

    @PostMapping("/following")
    public ResponseEntity<String> followAndUnfollowUser(@RequestBody FollowUserRequest request) {
        var response = _followService.followAndUnfollowUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/all")
    public ResponseEntity<GetAllFollowsResponse> getAllFollows() {
        var response = ResponseEntity.ok().body(_followService.getAllFollows());
        return response;
    }

    @GetMapping("/get/id")
    public ResponseEntity<GetFollowsListByUserId> getFollowListByUserId(String userId) {
        var response = _followService.getFollowsListByUserId(UUID.fromString(userId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/get/userjoin")
    public ResponseEntity<List<FindAllUsersFollowResponse>> getAllUsersWithFollow() {
        return ResponseEntity.ok().body(_followService.getAllUsersWithFollow());
    }

}
