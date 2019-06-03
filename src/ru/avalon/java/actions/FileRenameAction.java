package ru.avalon.java.actions;

import java.io.*;
import java.nio.file.*;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileRenameAction implements Action {

    private File file;
    private String name;

    public FileRenameAction(String file, String name) throws IOException {
        File oldFile = new File(file);
        this.file = oldFile;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        synchronized (file) {
            try {
                rename();
            } catch (IOException e) {
                System.out.println("Файл не был переименован!");
                e.printStackTrace(System.err);
            }
        }
    }

    private void rename() throws IOException {

        if (file.exists()) {
            Path path = Paths.get(file.getAbsolutePath());
            file.renameTo(new File(path.getParent().toString() + File.separator + name));
            System.out.println("Файл переименован");
        } else {
            System.out.println("Файл не найден");
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
