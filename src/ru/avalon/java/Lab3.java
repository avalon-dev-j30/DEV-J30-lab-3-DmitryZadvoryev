package ru.avalon.java;

import java.io.*;
import ru.avalon.java.console.ConsoleUI;
import ru.avalon.java.actions.*;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка многоуровневых
 * приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String firstValue;
    private String secondValue;

    /**
     * Точка входа в приложение.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Lab3().run();
    }

    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void onCommand(Commands command) throws IOException {
            switch (command) {
                case copy:
                    System.out.print("Путь к файлу: >");
                    firstValue = reader.readLine();
                    System.out.print("Путь для копирования: >");
                    secondValue = reader.readLine();

                    FileCopyAction copy = new FileCopyAction(firstValue, secondValue);
                    copy.start();
                    break;
                    
                case move:
                    System.out.print("Путь к файлу: >");
                    firstValue = reader.readLine();
                    System.out.print("Путь для перемещения: >");
                    secondValue = reader.readLine();

                    FileMoveAction move = new FileMoveAction(firstValue, secondValue);
                    move.start();
                    break;
                    
                case rename:
                    System.out.print("Путь к файлу: >");
                    firstValue = reader.readLine();
                    System.out.print("Новое имя файла: >");
                    secondValue = reader.readLine();
                    
                    FileRenameAction rename = new FileRenameAction(firstValue, secondValue);
                    rename.start();
                    break;
                    
                case delete:
                    System.out.print("Путь к файлу: >");
                    firstValue = reader.readLine();
                    
                    FileDeleteAction delete = new FileDeleteAction(firstValue);
                    delete.start();
                    break;
                    
                case exit:
                    close();
                    break;
            }
        }
    }

