package inifile;

import java.io.InputStream;
import java.io.OutputStream;

// É la struttura base di ogni lettore e scrittore di un qualsiasi file di 
//  configurazione indipendente dal formato con cui esso viene scritto.

public interface ConfHandler {
    public Conf read(InputStream source);
    
    public void write(Conf conf, OutputStream source);
}
