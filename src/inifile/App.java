package inifile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        
        // Implementazione del gestore dei file di configurazione RELATIVO al formato XML        
        ConfHandler confHandler = new XmlHandler();
        
        // Creazione dell' oggetto "conf" da lettura del file "conf.xml"
        Conf conf = confHandler.read(new FileInputStream("conf.xml"));
        
        // Aggiunta del parametro "parametro_aggiunto" all'oggetto conf
        conf.getSection("Gianni").addParameter("parametro_aggiunto", "good");
        
        // Sovrascrittura del gestore dei file di configurazione ORA RELATIVO al formato INI
        confHandler = new IniHandler();
        
        // Scrittura dell'oggetto conf sul file "conf.ini"
        confHandler.write(conf, new FileOutputStream("conf.ini"));
        
    }
}
