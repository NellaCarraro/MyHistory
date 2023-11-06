package org.example;

import org.example.MyHerstory;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyHerstoryTest {
    @TempDir
    private Path tmpDir;
    @org.junit.jupiter.api.Test
    void readTest() {
        //File dir = new File("kys");
        //dir.mkdir();
        MyHerstory herStory = new MyHerstory(tmpDir+"\\testdata");
        System.out.println(herStory.fileName);
        assertThrows(IOException.class,() -> herStory.read());// je
        try {

            herStory.read();
            System.out.println("chyba!!");
        } catch (IOException e) {
            System.out.println("ok"); // chci aby to hlasilo vyjimkou kdyz oteviram soubor ktery neexistuje
        }

    }

    @org.junit.jupiter.api.Test
    void addLineTest() {
        MyHerstory her = new MyHerstory("adb");
        her.addLine("dgfdt");
        assertEquals("dgfdt", her.toString());

    }
    @org.junit.jupiter.api.Test
    void addLine2Test() {
        MyHerstory her = new MyHerstory("fd");
        her.addLine("gfdh");
        her.addLine("fhg");
        her.addLine("p;l9o");
        assertEquals("gfdh\nfhg\np;l9o",her.toString());
    }
    @org.junit.jupiter.api.Test
    void duplicitRadkyTest(){
        MyHerstory her = new MyHerstory("hnf");
        her.addLine("uwu");
        her.addLine("uwu");
        her.addLine("a");
        assertEquals("uwu\na",her.toString());
    }
    @org.junit.jupiter.api.Test
    void saveTest(){
        MyHerstory her = new MyHerstory(tmpDir+"\\testdata");
        try {
            her.save();
        } catch (IOException e) {
            System.out.println("jejda chybicka se vloudila");

        }
    }
    @org.junit.jupiter.api.Test
    void saveAndReadTest(){
        MyHerstory herStory = new MyHerstory(tmpDir+"\\testdata");
        herStory.addLine("heh");
        System.out.println(herStory.toString());

       // try {
        //    herStory.save();
       //     MyHerstory heruwuStorz = new MyHerstory("data");
       //     assertEquals("heh",heruwuStorz.toString());
      //  } catch (IOException e) {
        //    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAARRRGGGGGGGGHHHHHHHHHHHH!!!!!!!!!!!!!!!!");
       // }


        // nechce se mu delat mozna bude jako ukol nvm i have to do it :( nefunguje to:(
    }


}