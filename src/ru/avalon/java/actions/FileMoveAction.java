package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 * Действие, которое перемещает файлы в пределах дискового пространства.
 */
public class FileMoveAction implements Action {

    /**
     * {@inheritDoc}
     */
    private Path what, where;

    public FileMoveAction(String whatCopy, String whereCopy) {
        what = Paths.get(whatCopy);
        where = Paths.get(whereCopy);
    }

     @Override
    public void run() {
            try {            
                move();  
            } catch (IOException e) {
                System.out.println("Файл не был перемещен!");
                e.printStackTrace(System.err);
            }
    }

    private void move() throws IOException {

        if (!Files.exists(what)) {
            System.out.println("Файл не найден");
        } else {
            Files.move(what, where.resolve(what.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл перемещен");
        }
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
