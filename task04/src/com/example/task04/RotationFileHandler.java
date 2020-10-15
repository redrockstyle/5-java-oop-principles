package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class RotationFileHandler extends FileHandler {
    private final Duration between;
    private LocalDateTime lastHandleTime = LocalDateTime.now();
    private long index = 1;

    public RotationFileHandler(Duration between)throws IOException {
        super(new FileWriter("log1.txt"));
        this.between = Objects.requireNonNull(between);
    }

    @Override
    public void handle(String msg){
        LocalDateTime nowTime = LocalDateTime.now();
        if (Duration.between(lastHandleTime, nowTime).compareTo(between) >= 0) {
            try {
                fileWriter.close();
                fileWriter = new FileWriter("log" + ++index + ".txt");
            }
            catch(IOException exc) {
                exc.printStackTrace();
            }
        }

        lastHandleTime = nowTime;
        super.handle(msg);
    }


}
