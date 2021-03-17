package com.learning.proxy;

public class EbookProxy implements Ebook{

    private String file_name;
    private RealEbook ebook;

    public EbookProxy(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public void show() {
        if (ebook==null)
            ebook = new RealEbook(file_name);
        ebook.show();
    }

    @Override
    public String get_file_name() {
        return file_name;
    }
}
