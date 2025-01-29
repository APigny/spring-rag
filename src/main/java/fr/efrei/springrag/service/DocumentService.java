package fr.efrei.rag.service;

import org.springframework.stereotype.Service;

import fr.efrei.rag.domain.Document;
import fr.efrei.rag.repository.DocumentRepository;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSave(Document document) {
        return documentRepository.save(document);
    }

}
