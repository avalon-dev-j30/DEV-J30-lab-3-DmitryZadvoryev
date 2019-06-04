package ru.avalon.java.actions;

import java.io.*;
import java.nio.file.*;


/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    private  Path what;
    private Path where;

    public FileCopyAction(String whatCopy, String whereCopy) {
        what = Paths.get(whatCopy);
        where = Paths.get(whereCopy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
            try {            
                copy();  
            } catch (IOException e) {
                System.out.println("Файл не скопирован!");
                e.printStackTrace(System.err);     
        }
    }

    private void copy() throws IOException {

        if (!Files.exists(what)) {
            System.out.println("Файл не найден");
        } else {
            Files.copy(what, where.resolve(what.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован");
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
