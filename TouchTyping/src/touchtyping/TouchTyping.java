/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touchtyping;

import java.io.FileNotFoundException;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Che
 */
public class TouchTyping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        LogIn loginwindow=new LogIn();
        RefineryUtilities.centerFrameOnScreen( loginwindow);
        loginwindow.setVisible(true);
          
        
    }
    
}
