package fr.efrei.springrag.service;

import org.springframework.stereotype.Service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.DocumentRepository;

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
