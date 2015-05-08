package com.github.funnygopher.ptu.abilityscraper;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;

public class AbilityScraper {

    private File pdfFile;
    private PDDocument pdf;
    private int startPage;
    private int endPage;

    public AbilityScraper(File pdfFile, int startPage, int endPage) {
        this.pdfFile = pdfFile;
        this.startPage = startPage;
        this.endPage = endPage;
    }
}
