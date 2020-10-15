package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileHandler implements MessageHandler {
    protected FileWriter fileWriter;

    public FileHandler(FileWriter fileWriter){
        this.fileWriter = Objects.requireNonNull(fileWriter);
    }

    @Override
    public void handle(String msg){
        try{
            fileWriter.write(msg);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        fileWriter.close();
    }
}
