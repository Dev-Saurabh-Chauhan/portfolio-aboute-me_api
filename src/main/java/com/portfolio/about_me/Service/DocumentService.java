package com.portfolio.about_me.Service;

import com.portfolio.about_me.Dto.DocumentPayloadDTO;
import com.portfolio.about_me.Dto.DocumentResponse;

import java.util.List;

public interface DocumentService {
    List<DocumentResponse> getAllDocument();
    DocumentResponse getDocumentById(int id);
    DocumentResponse addDocument(DocumentPayloadDTO payloadDTO);
    DocumentResponse updateDocumentById(DocumentPayloadDTO payloadDTO,int id);
    boolean deleteDocumentById(int id);

}
