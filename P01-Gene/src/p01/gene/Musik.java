/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p01.gene;

/**
 *
 * @author avrians
 */
public class Musik {
    String path, fileName, fileSize, extention;
    
    public Musik(String p, String fn, String fs, String ek) {
        this.path = p;
        this.fileName = fn;
        this.fileSize = fs;
        this.extention = ek;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getExtention() {
        return extention;
    }
    
}