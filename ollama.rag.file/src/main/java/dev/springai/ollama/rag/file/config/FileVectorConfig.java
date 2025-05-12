package dev.springai.ollama.rag.file.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.io.File;
import java.util.List;

@Configuration
@Slf4j
public class FileVectorConfig {

    @Value("classpath:/rag-data/CrystalComABC_Company_Profile.pdf")
    private Resource companyProfile;

    private final String VECTOR_STORE_FILENAME = "vector-store.json";

    @Bean
    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) throws InterruptedException {
        SimpleVectorStore simpleVectorStore;
        File vectorStoreFile = new File(VECTOR_STORE_FILENAME);
        if (vectorStoreFile.exists()) {
            log.info("Vector store file already exits. Loaded existing file");
            simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();
            simpleVectorStore.load(vectorStoreFile);
        } else {
            simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();
            log.info("Creating new vector file" + vectorStoreFile.getAbsoluteFile());
            simpleVectorStore.add(new TokenTextSplitter().apply(getDocsFromPdf()));
            simpleVectorStore.save(vectorStoreFile);
        }
        return simpleVectorStore;
    }

    private List<Document> getDocsFromPdf() {
        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(companyProfile,
                PdfDocumentReaderConfig.builder()
                        .withPageTopMargin(0)
                        .withPageExtractedTextFormatter(ExtractedTextFormatter.builder()
                                .withNumberOfTopTextLinesToDelete(0)
                                .build())
                        .withPagesPerDocument(1)
                        .build());

        return pdfReader.read();
    }
}