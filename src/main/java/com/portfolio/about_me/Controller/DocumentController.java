package com.portfolio.about_me.Controller;

import com.portfolio.about_me.Dto.*;
import com.portfolio.about_me.Service.DocumentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;


    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<DocumentResponse>>> getAll() {
        try {
            List<DocumentResponse> data = this.documentService.getAllDocument();
            ApiResponse<List<DocumentResponse>> response = new ApiResponse<>(200, data, "Get Data successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiResponse<List<DocumentResponse>> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<DocumentResponse>> getById(@PathVariable int id) {
        try {
            DocumentResponse data = this.documentService.getDocumentById(id);
            ApiResponse<DocumentResponse> response = new ApiResponse<>(200, data, "Get Data successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiResponse<DocumentResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<ApiResponse<DocumentResponse>> addDocs(@Valid @RequestBody DocumentPayloadDTO saveDto) {
        try {
            DocumentResponse addedData = this.documentService.addDocument(saveDto);
            if (addedData == null) {
                ApiResponse<DocumentResponse> response = new ApiResponse<>(400, null, "Bad Request.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            }
            ApiResponse<DocumentResponse> response = new ApiResponse<>(200, addedData, "Data Added Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception ex) {
            ApiResponse<DocumentResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<DocumentResponse>> updateConnection(@Valid @RequestBody DocumentPayloadDTO saveDto, @PathVariable int id) {
        try {
            DocumentResponse updatedData = this.documentService.updateDocumentById(saveDto, id);
            if (updatedData == null) {
                ApiResponse<DocumentResponse> response = new ApiResponse<>(400, null, "Bad Request.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            ApiResponse<DocumentResponse> response = new ApiResponse<>(200, updatedData, "Data Updated Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception ex) {
            ApiResponse<DocumentResponse> response = new ApiResponse<>(500, null, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable int id) {
        try {
            boolean deletedData = this.documentService.deleteDocumentById(id);
            if (deletedData) {
                ApiResponse<Boolean> response = new ApiResponse<>(200, true, "Document Deleted Successfully");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
            ApiResponse<Boolean> response = new ApiResponse<>(400, false, "Document not Found on this ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception ex) {
            ApiResponse<Boolean> response = new ApiResponse<>(500, false, ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
