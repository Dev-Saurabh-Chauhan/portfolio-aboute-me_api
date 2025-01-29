package com.portfolio.about_me.Controller;
import com.portfolio.about_me.Dto.ApiResponse;
import com.portfolio.about_me.Dto.ConnectMeSaveDto;
import com.portfolio.about_me.Dto.ConnectionMeResponse;
import com.portfolio.about_me.Service.ConnectMeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/connect_me")
public class ConnectMeController {

    @Autowired
    private ConnectMeService connectMeService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<ConnectionMeResponse>>> getConnections() {
        try {
            List<ConnectionMeResponse> data = this.connectMeService.getAllConnection();
            ApiResponse<List<ConnectionMeResponse>> response = new ApiResponse<>(200, data, "Get Data successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiResponse<List<ConnectionMeResponse>> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<ConnectionMeResponse>> addConnection(@Valid @RequestBody ConnectMeSaveDto saveDto) {
        try {
            ConnectionMeResponse addedData = this.connectMeService.addConnection(saveDto);
            if (addedData == null) {
                ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(400, null, "Bad Request.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            }
            ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(200, addedData, "Data Added Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception ex) {
            ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ConnectionMeResponse>> updateConnection(@Valid @RequestBody ConnectMeSaveDto saveDto, @PathVariable int id) {
        try {
            ConnectionMeResponse updatedData = this.connectMeService.updateConnectionById(saveDto, id);
            if (updatedData == null) {
                ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(400, null, "Bad Request.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(200, updatedData, "Data Updated Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception ex) {
            ApiResponse<ConnectionMeResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable int id) {
        try {
            boolean deletedData = this.connectMeService.deleteConnectionById(id);
            if (deletedData) {
                ApiResponse<Boolean> response = new ApiResponse<>(200, true, "Connection Deleted Successfully");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            ApiResponse<Boolean> response = new ApiResponse<>(400, false, "Connection not Found on this ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }catch (Exception ex) {
            ApiResponse<Boolean> response = new ApiResponse<>(500, false, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
