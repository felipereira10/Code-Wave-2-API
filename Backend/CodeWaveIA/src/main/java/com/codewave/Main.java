package com.codewave;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import dev.langchain4j.data.document.Document;

import static com.codewave.ai.loadIntoHugging;
import static com.codewave.ai.toPath;
import static dev.langchain4j.data.document.FileSystemDocumentLoader.loadDocument;

public class Main {
    public static void main(String[] args) {
        Document document = loadDocument(toPath("/text.txt"));
        System.out.println(loadIntoHugging(document,"Who is Charlie?"));


        }
}