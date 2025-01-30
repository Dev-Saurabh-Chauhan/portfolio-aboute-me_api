package com.portfolio.about_me.Imples;

import com.portfolio.about_me.Dto.ConnectionMeResponse;
import com.portfolio.about_me.Dto.DocumentPayloadDTO;
import com.portfolio.about_me.Dto.DocumentResponse;
import com.portfolio.about_me.Repository.DocumentRepository;
import com.portfolio.about_me.Service.DocumentService;
import com.portfolio.about_me.entity.Documents;
import com.portfolio.about_me.exceptions.DataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentImplements implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DocumentResponse> getAllDocument() {
        List<Documents> documentsList = this.documentRepository.findAll();
        return documentsList.stream().map(e -> this.modelMapper.map(e, DocumentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public DocumentResponse getDocumentById(int id) {
        Documents getData = this.documentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("No data found with Id: " + id));
        return this.modelMapper.map(getData, DocumentResponse.class);
    }

    @Override
    public DocumentResponse addDocument(DocumentPayloadDTO payloadDTO) {
        Documents documents = new Documents();
        documents.setDocument_file(payloadDTO.getDocument_file());
        documents.setDocument_name(payloadDTO.getDocument_name());
        documents.setDocument_type(payloadDTO.getDocument_type());
        Documents savedDate = this.documentRepository.save(documents);
        return this.modelMapper.map(savedDate, DocumentResponse.class);
    }

    @Override
    public DocumentResponse updateDocumentById(DocumentPayloadDTO payloadDTO, int id) {
        Documents documents = this.documentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("No data found with Id: " + id));
        documents.setDocument_file(payloadDTO.getDocument_file());
        documents.setDocument_name(payloadDTO.getDocument_name());
        documents.setDocument_type(payloadDTO.getDocument_type());
        Documents savedDate = this.documentRepository.save(documents);
        return this.modelMapper.map(savedDate, DocumentResponse.class);
    }

    @Override
    public boolean deleteDocumentById(int id) {
        Documents documents = this.documentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("No data found with Id: " + id));
        this.documentRepository.deleteById(documents.getId());
        return true;
    }
}
