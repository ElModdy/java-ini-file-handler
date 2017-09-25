/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inifile;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author usr
 */
public class IniHandler implements ConfHandler{

    @Override
    public Conf read(File file) {
        HashMap<String, Sezione> sections = new HashMap();
        Matcher wrappedSections = Pattern.compile("\\[(.*?)\\]([^\\[]+)")
                                         .matcher(new In(file)
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
    public void write(Conf conf, File file) {
       new Out(file.getAbsolutePath()).print(conf.getSections()
                                                 .entrySet()
                                                 .stream()
                                                 .map( entry -> "[" + entry.getKey() + "]\n" + entry.getValue())
                                                 .collect(Collectors.joining("\n")));
    }
    
}
