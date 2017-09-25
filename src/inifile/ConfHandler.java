/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inifile;

import java.io.File;

/**
 *
 * @author usr
 */
public interface ConfHandler {
    public Conf read(File file);
    
    public void write(Conf conf, File file);
}
