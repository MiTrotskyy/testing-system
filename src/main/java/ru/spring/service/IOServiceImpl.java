package ru.spring.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private Scanner scanner;
    private PrintStream printStream;

    public IOServiceImpl() {
        this.scanner = new Scanner(System.in);
        this.printStream = new PrintStream(System.out);
    }

    @Override
    public String getLine() {
        return scanner.nextLine();
    }

    @Override
    public void printMessage(String message) {
        printStream.print(message);
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }
}
