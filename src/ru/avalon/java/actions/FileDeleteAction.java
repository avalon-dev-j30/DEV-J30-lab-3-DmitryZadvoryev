package ru.avalon.java.actions;

import java.io.*;
import java.nio.file.*;

/**
 * Действие, которое перемещает файлы в пределах дискового пространства.
 */
public class FileDeleteAction implements Action {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * {@inheritDoc}
     */
    private Path path;

    public FileDeleteAction(String path) throws IOException {
        this.path = Paths.get(path);
    }

    @Override
    public void run() {
            try {
                delete();
            } catch (IOException e) {
                System.out.println("Файл не был удален!");
                e.printStackTrace(System.err);    
        }
    }

    private void delete() throws IOException {

        if (!Files.exists(path)) {
            System.out.println("Файл не найден");
        } else {
            Files.delete(path);
            System.out.println("Файл удален");
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
