package net.codewave.classes_de_conexao;


import dev.langchain4j.data.document.Document;
import net.codewave.telas.TelaRegistro;
import net.codewave.telas.Tela_login;

import java.awt.*;

import static dev.langchain4j.data.document.FileSystemDocumentLoader.loadDocument;
import static net.codewave.classes_de_conexao.Ai.loadIntoHugging;
import static net.codewave.classes_de_conexao.Ai.toPath;

public class Main {
    public static void main(String[] args) {
//        Document document = loadDocument(toPath("/text.txt"));
//        System.out.println(loadIntoHugging(document,"Who is Charlie?"));

        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Tela_login frame = new Tela_login();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
}