package fr.efrei.rag.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.rag.domain.Document;
import fr.efrei.rag.service.DocumentService;

@RestController
public class DocumentResource {
    private final Logger log = LoggerFactory.getLogger(DocumentResource.class);
    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to create document : {}", document);
        Document result = documentService.buildAndSave(document);
        
        return ResponseEntity
            .created(new URI("documents/" + result.getId()))
            .body(result);
    }

}
