package fr.efrei.springrag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.efrei.springrag.domain.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
}
