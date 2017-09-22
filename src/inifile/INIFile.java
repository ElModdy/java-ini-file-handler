package inifile;

import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class INIFile {
    Map<String, Sezione> sections;
    
    public INIFile(String filePath) {
        Matcher wrappedSections = Pattern.compile("\\[(.*?)\\]([^\\[]+)")
                                       .matcher(new In(filePath)
                                                    .readAll());
        sections = new HashMap();
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
    }

    @Override
    public String toString() {
        return sections.entrySet().stream()
                                  .map( entry -> "Sezione: " + entry.getKey() + entry.getValue().toString())
                                  .collect(Collectors.joining("\n"));
    }
    
    public static void main(String[] args) {
        System.out.println(new INIFile("file_ini.txt").toString());
    }
    
    
}
