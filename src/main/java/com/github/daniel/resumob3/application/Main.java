package com.github.daniel.resumob3.application;

public class Main {
    public static void main(String[] args) {
        System.exit(start());
    }

    static int start() {
        EfetivaOperacao efetiva = new EfetivaOperacao();

        efetiva.efetivaOperacao();
        return 0;
    }
}
