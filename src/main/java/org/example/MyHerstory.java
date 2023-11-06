package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyHerstory {
    String fileName;
    Set<String> data;
    ArrayList<String> data2;
    public MyHerstory(String fileName) {
      this.fileName= fileName;
      data = new HashSet<>();
      data2 = new ArrayList<>();
        // vytvori instanci pro soubor _fileName_
    }

    public void read() throws IOException {
         data = new HashSet<>(Files.readAllLines(Paths.get(fileName)));
         data2 = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
        // načte soubor fileName do paměti, skončí výjimkou pokud soubor nejde načíst
    }

    public void save() throws IOException {
        Files.writeString(Paths.get(fileName),toString());
        // zapíše obsah paměti do souboru, skončí výjimkou pokud soubor nejde uložit
        // pokud soubor již existuje, přepíše jej
    }

    public void addLine(String str) {
        if(!data.contains(str)) {
            data.add(str);
            data2.add(str);
        }

        // přidá řádek str do paměti pokud tam ještě není,
        // duplicitní řádky ignoruje.
    }

    public String toString() {
        return String.join("\n",data2);
        // vrátí řetězec obsahující všechny řádky
    }
}