package com.codewave;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import dev.langchain4j.chain.ConversationalRetrievalChain;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.ParagraphSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;
import dev.langchain4j.model.huggingface.HuggingFaceEmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;


import static java.time.Duration.ofSeconds;

public class ai {

    public static String loadIntoHugging(Document file, String question){

        EmbeddingModel embeddingModel = HuggingFaceEmbeddingModel.builder()
                .accessToken(chaves.chave_api)
                .modelId("sentence-transformers/all-MiniLM-L6-v2")
                .waitForModel(true)
                .timeout(ofSeconds(60))
                .build();

        EmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();


        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .splitter(new ParagraphSplitter())
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();
        ingestor.ingest(file);


        ConversationalRetrievalChain chain = ConversationalRetrievalChain.builder()
                .chatLanguageModel(HuggingFaceChatModel.withAccessToken(chaves.chave_api))
                .retriever(EmbeddingStoreRetriever.from(embeddingStore, embeddingModel))
                // .chatMemory() // you can override default chat memory
                // .promptTemplate() // you can override default prompt template
                .build();

        return chain.execute(question);
    }

    static Path toPath(String fileName) {
        try {
            URL fileUrl = Main.class.getResource(fileName);
            assert fileUrl != null;
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
