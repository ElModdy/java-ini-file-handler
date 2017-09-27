package inifile;

import java.io.File;

// É la struttura base di ogni lettore e scrittore di un qualsiasi file di 
//  configurazione indipendente dal formato con cui esso viene scritto.

public interface ConfHandler {
    public Conf read(File file);
    
    public void write(Conf conf, File file);
}
