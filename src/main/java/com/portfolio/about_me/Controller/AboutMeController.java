package com.portfolio.about_me.Controller;

import com.portfolio.about_me.Dto.AboutMeResponse;
import com.portfolio.about_me.Dto.AboutMeSaveDto;
import com.portfolio.about_me.Dto.ApiResponse;
import com.portfolio.about_me.Service.AboutMeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/about_me")
public class AboutMeController {
    @Autowired
    private  AboutMeService aboutMeService;


    @GetMapping("/get")
    public ResponseEntity<ApiResponse<AboutMeResponse>> getAboutMe() {
        try {
            AboutMeResponse data = this.aboutMeService.getAboutMe();
            if (data == null) {
                ApiResponse<AboutMeResponse> response = new ApiResponse<>(400, null, "Get Data successfully.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            ApiResponse<AboutMeResponse> response = new ApiResponse<>(200, data, "Get Data successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiResponse<AboutMeResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateAboutMe(@Valid @RequestBody AboutMeSaveDto saveDto) {
        try {
            boolean isUpdated = aboutMeService.update(saveDto);
            if (isUpdated) {
                ApiResponse<String> response = new ApiResponse<>(200, "About Me details updated successfully.", "Get Data successfully.");
                return ResponseEntity.ok(response);
            }
            ApiResponse<String> response = new ApiResponse<>(400, null, "No About Me data found to update.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception ex) {
            ApiResponse<String> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

