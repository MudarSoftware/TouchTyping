/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touchtyping;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Che
 */
public class Settings implements Serializable{
    Color Background;
    String TriningFile="";
    public Settings(){this.Background=Color.white;this.TriningFile="words200";}

    public Color getBackground() {
        return Background;
    }

    public void setBackground(Color Background) {
        this.Background = Background;
    }

    public String getTriningFile() {
        return TriningFile;
    }

    public void setTriningFile(String TriningFile) {
        this.TriningFile = TriningFile;
    }
    
    public void saveSetting(String filename)throws Exception
    {
       FileOutputStream f = new FileOutputStream(new File(filename+".dat"));
       ObjectOutputStream out = new ObjectOutputStream(f);
       out.writeObject(this);
       out.close();
       f.close();
        
    }
}
