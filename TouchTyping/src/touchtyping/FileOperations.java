
package touchtyping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Che
 */
public class FileOperations {
    List<String> wordslist;
    Random rand=new Random();
    String fileName="";
    int wordsnumber=0;
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setWordsnumber() {
        if(!fileName.equals(""))
        {
            if(fileName.equals("words200"))
                wordsnumber=200;
            if(fileName.equals("words1000"))
                wordsnumber=1000;
            if(fileName.equals("words3000"))
                wordsnumber=300;
        }else{this.fileName="words200";this.wordsnumber=200;}
    }
    public FileOperations() throws IOException{
        
    }
    public String getWords() throws IOException
    {
        File wordsFile=new File(fileName+".dat");
        if(wordsFile.exists())
        {
            wordslist=Files.readAllLines(Paths.get(fileName+".dat"));
            this.setWordsnumber();
        }else
        {
            this.fileName="words200";
            wordslist=Files.readAllLines(Paths.get(fileName+".dat"));
            this.setWordsnumber();
        }
        int randomNumber=0;
        String words="";
        try
        {
            for(int i=0;i<20;i++){
               randomNumber=rand.nextInt(wordsnumber-1);
               words+=wordslist.get(randomNumber).trim()+" ";
            }
            words=words.trim();
        }catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            System.err.println(ex);
        }
        return words;
    }  
    
}
