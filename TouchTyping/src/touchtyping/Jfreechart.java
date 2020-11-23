/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touchtyping;
import java.awt.Color;
import java.io.File;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
/**
 *
 * @author Che
 */
public class Jfreechart extends JFrame {
    JFreeChart chart;
    BarRenderer renderer;
    User user;
    public Jfreechart(String title,User usr) throws IOException
    {
        
        user=usr;
        setContentPane(createDemoPanel( ));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        CategoryPlot plot = chart.getCategoryPlot();
        renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setDrawBarOutline(true);
       
    }
    private CategoryDataset createDataset( ) throws IOException
    {
       
        List<String> userspeed=this.user.getUserSpeeds();
        if(userspeed!=null)
        {
            if(userspeed.size()>10){
            DefaultCategoryDataset  dataset=new DefaultCategoryDataset ();
            for(int i=userspeed.size()-10;i<userspeed.size();i++)
            {
               dataset.addValue( Double.parseDouble(userspeed.get(i)) , "Your Speed" , i+"" );
            }
            return dataset;
            }else{
                JOptionPane.showMessageDialog(rootPane, "You must take more than 10 test to view char speed");
                return null;
            }
        }
        return null;
    }
    private  JFreeChart createChart( DefaultCategoryDataset  dataset )
    {
        chart=ChartFactory.createBarChart("Speed chart for last 10 test", "Tests Speed Avg "+this.user.getUserSpeedAvg()+" WPM", "Speed WPM", dataset,PlotOrientation.VERTICAL,true,true,false);
        return chart;
    }
    public  JPanel createDemoPanel( ) throws IOException
    {
        JFreeChart chart = createChart((DefaultCategoryDataset) createDataset( ));
        return new ChartPanel( chart );
    }
    public void setUser(User user){this.user=user;}
    
    
}
