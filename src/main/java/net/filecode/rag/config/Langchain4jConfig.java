package net.filecode.rag.config;

import net.filecode.rag.rag.DocumentQueryRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Langchain4jConfig {

    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return memoryId -> MessageWindowChatMemory.withMaxMessages(10);
    }

    @Bean
    InMemoryEmbeddingStore<TextSegment> embeddingStore() {
        return new InMemoryEmbeddingStore<>();
    }

    @Bean
    EmbeddingModel embeddingModel() {
        return new AllMiniLmL6V2EmbeddingModel();
    }

    @Bean
    EmbeddingStoreContentRetriever contentRetriever(InMemoryEmbeddingStore<TextSegment> embeddingStore,
                                                    EmbeddingModel embeddingModel) {
        return new EmbeddingStoreContentRetriever(embeddingStore, embeddingModel);
    }

    @Bean
    RetrievalAugmentor retrievalAugmentor(ChatLanguageModel chatLanguageModel, ContentRetriever docuementContentRetriever) {
        return DefaultRetrievalAugmentor.builder()
                .queryRouter(new DocumentQueryRouter(chatLanguageModel, docuementContentRetriever))
                .build();
    }
}