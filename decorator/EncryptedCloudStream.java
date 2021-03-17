package com.learning.decorator;

public class EncryptedCloudStream implements Stream{

    private Stream stream;

    public EncryptedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {

        var encrypted = Encrypted(data);
        stream.write(encrypted);

    }

    private String Encrypted(String data){
        return "#$@^@#$%^&*%^&;";
    }
}
