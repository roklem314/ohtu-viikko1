package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        Varasto vesiVarasto = new Varasto(100000);
        vesiVarasto.otaVarastosta(100);
    }
}
