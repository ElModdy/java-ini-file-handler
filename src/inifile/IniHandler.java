package inifile;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// É un'implementazione del ConfHandler relativo ai file di configurazione
//  formattati in ini.

public class IniHandler implements ConfHandler{

    @Override
    public Conf read(InputStream source) {
        HashMap<String, Sezione> sections = new HashMap();
        Matcher wrappedSections = Pattern.compile("\\[(.*?)\\]([^\\[]+)")
                                         .matcher(new In(new Scanner(source))
                                                                .readAll());
        Pattern parametersRegex = Pattern.compile("\\s([^(\\s|#))]+?)=([^\\s]+)");
        Matcher wrappedParameters;
        Map<String, String> parameters;
        while (wrappedSections.find()) {
            wrappedParameters = parametersRegex.matcher(wrappedSections.group(2));
            parameters = new HashMap();
            while(wrappedParameters.find()){
                parameters.put(wrappedParameters.group(1), wrappedParameters.group(2));
            }
            sections.put(wrappedSections.group(1), new Sezione(parameters));
        }
        return new Conf(sections);
    }

    @Override
    public void write(Conf conf, OutputStream source) {
       new Out(source).print(conf.getSections()
                                                 .entrySet()
                                                 .stream()
                                                 .map( entry -> "[" + entry.getKey() + "]\n" + entry.getValue()
                                                                                                    .getParameters()
                                                                                                    .entrySet()
                                                                                                    .stream()
                                                                                                    .map( e -> "\t" + e.getKey() + "=" + e.getValue())
                                                                                                    .collect(Collectors.joining("\n")))
                                                 .collect(Collectors.joining("\n")));
    }
    
}
