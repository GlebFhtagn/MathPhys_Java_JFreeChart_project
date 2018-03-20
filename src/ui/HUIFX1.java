/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;

public class HUIFX1{

        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				НовыйClassFrame frame = new НовыйClassFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}


class НовыйClassFrame extends JFrame{
    public static double getUxt(int n, double x, double t){
        double result = 0;
        double pi = Math.PI;
        for(int i = 1; i <= n; i++){
            result += 4*(l*pi*i*sin(i))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l)*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
           // result += 4*(3*sin(pi*i) + pi*i*sin(pi*i/3) - 3*pi*i*cos(pi*i))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l)*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
        }
        return result;
    }
    public static double U(int i, double x, double t){
        double result = 0;
        double pi = Math.PI;
        result = 4*(3*sin(pi*i) + pi*i*sin(pi*i/3) - 3*pi*i*cos(pi*i))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l)*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
        //result = 4*(3*sin(pi*i) + pi*i*sin(pi*i/3) - 3*pi*i*cos(pi*i))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l)*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
        
        return result;
    }
    
//    public static double w(double x, double t, double n){
//        double result = 0;
//        
//        for(int k = 1; k < n; k ++){
//            result += y(k, t)*sin(k*Math.PI*x/l);
//        }
//        return result;
//    }
//    public static double y(double k, double t){
//        double result = 0;
//        for(int tt = ; tt < l; tt++){
//            result += g(k, t)
//        }
//        result +=
//        return result;
//    }
    public static void createCollectionOfU(int n1, double t){
        
        dataset.removeAllSeries();
        series = new XYSeries[n1+1]; 
            for(int nn = 0; nn < n1; nn++){
                series[nn] = new XYSeries(""+(nn));
            }
        
        for(int nn = 1; nn <= n1; nn++){
            for(int i = 0; i<=l; i++){
                series[nn-1].add(i, U(nn, i, t));
            }
        }
        
        series[n1] = new XYSeries("Sum");
        for(int i = 0; i<=l; i++){
            series[n1].add(i, getUxt(10, i, t));
        }
        
        if(dataset.getSeriesCount() != 0){
            dataset.removeAllSeries();
        }
        for(int i = 0; i <= n; i++)
           dataset.addSeries(series[i]);
           legend = cp.getChart().getLegend();
    }
    public static void updateCollectionOfU(int n1, double t){
        for(int nn = 1; nn <= n1; nn++){
            series[nn-1].clear();
            for(int i = 0; i<=l; i++){
                series[nn-1].add(i, U(nn, i, t));
            }
        }
        series[n1].clear();
        for(int i = 0; i<=l; i++){
            series[n1].add(i, getUxt(10, i, t));
        }
    }
    public static void createSummU(int n, double t){
        dataset.removeAllSeries();
        series = new XYSeries[1];
        series[0] = new XYSeries("Sum");
        for(int i = 0; i<=l; i++){
            series[0].add(i, getUxt(10, i, t));
        }
        if(dataset.getSeriesCount() != 0){
            dataset.removeAllSeries();
        }
        dataset.addSeries(series[0]);
        legend = cp.getChart().getLegend();
        
    }
    public static void updateSummU(int n, double t){
        series[0].clear();
        for(int i = 0; i<=l; i++){
            series[0].add(i, getUxt(10, i, t));
        }
    }
    
    public static void create(double t)
    {
        
    }
    
    public static void update(double t){
        
    }
    
    private static double u(double x, double t){
        if( t == 0 ) return 0;
        if( x == 0  ||  x == l ) return 0;
        if( t == 1 ) {
            return 
        }
        return 0;
    }
    
    static double a, w, l, p, t, nu, ticks;
    static int n;
    private static ChartPanel cp;
    static XYSeriesCollection dataset;
    static XYSeries series[];
    private JPanel mainPanel;
    private static ChangeListener listener;
    static JSlider slider;
    static JCheckBox showCollection = new JCheckBox("show all of series");
    static JCheckBox showLegend = new JCheckBox("show legend of series");
    private static JTextField textField;
    private static JFreeChart chart;
    private static JTextField fieldw = new JTextField(10);
    private static JTextField fieldt = new JTextField(10);
    private static JTextField fieldticks = new JTextField(10);
    private static JTextField fieldl = new JTextField(10);
    private static JTextField fieldp = new JTextField(10);
    private static JTextField fieldnu = new JTextField(10);
    private static JTextField fieldn = new JTextField(10);
    
    private static LegendTitle legend;
    public static final int DEFAULT_WIDTH = 900;
    public static final int DEFAULT_HEIGHT = 600;
	
    
    
    НовыйClassFrame() {
        
	setTitle("jFreeChart");
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        
        
        ////////////////////////////////////////////////////////////////////////
        mainPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel checkBoxes = new JPanel();
        JPanel fields = new JPanel();
        ////////////////////////////////////////////////////////////////////////
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(0);
        slider.setMinorTickSpacing(10);   
        slider.setMaximum(20);
        slider.setMinimum(0);
        slider.setValue(0);
        listener = (ChangeEvent event) -> {
                        // Обновление поля редактирования при
                        // изменении значения регулятора.
                        
                        //System.out.println("" +((double)source.getValue())/10);
                        
                        if(!fieldp.getText().isEmpty()){
                            p = Double.parseDouble(fieldp.getText());
                        }
                        if(ticks != Double.parseDouble(fieldticks.getText())){
                            ticks = Double.parseDouble(fieldticks.getText());
                            slider.setMaximum((int)Math.floor(10/ticks));
                        }                        
                        if(!fieldnu.getText().isEmpty())
                            nu = Double.parseDouble(fieldnu.getText());
                        if(!fieldw.getText().isEmpty())
                            w = Double.parseDouble(fieldw.getText());
                        if(!fieldl.getText().isEmpty())
                            l = Double.parseDouble(fieldl.getText());
                        
                        JSlider source = (JSlider) event.getSource();
                        
                        if(showCollection.isSelected())
                        {
                            if(n != (int)Double.parseDouble(fieldn.getText())){
                                n = (int)Double.parseDouble(fieldn.getText());
                                createCollectionOfU(n, ((double)source.getValue()*ticks));
                            }
                            else
                                updateCollectionOfU(n, ((double)source.getValue()*ticks));
                        }else
                        {
                            
                            if(n != (int)Double.parseDouble(fieldn.getText())){
                                n = (int)Double.parseDouble(fieldn.getText());
                                createSummU(n, ((double)source.getValue()*ticks));
                            }
                            else
                                updateSummU(n, ((double)source.getValue()*ticks));
                        }
                        textField.setText(""+((double)source.getValue())*ticks);
                        
                        if(showLegend.isSelected()){
                            cp.getChart().addLegend(legend);
                        }
                        else cp.getChart().removeLegend();
                        a = p/nu;
                    };
        ////////////////////////////////////////////////////////////////////////
        
        a = 1; w = 2*PI/3; l = 100;
        n = 10;
        int oldN = n;
        p = 1;
        nu = 1;
        ticks = 0.5;
        t = 10;
        
        ////////////////////////////////////////    
       
        dataset = new XYSeriesCollection();
        
        
        chart = ChartFactory.createXYLineChart("", "x", "y", dataset, PlotOrientation.VERTICAL, true, true,false);
        chart.setBackgroundPaint(Color.white);
        
        XYPlot plot = chart.getXYPlot();
        chart.getXYPlot().setFixedRangeAxisSpace(chart.getXYPlot().getFixedDomainAxisSpace());        
        cp = new ChartPanel(chart);

        createCollectionOfU(n, 0);        
        showCollection.setSelected(true);
        //cp.getChart().removeLegend();
        
        ////////////////////////////////////////////////////////////////////////
        textField = new JTextField();
        JLabel wLabel, lLabel, pLabel, nuLabel, nLabel, ticksLabel;
        lLabel = new JLabel("l = ");
        nLabel = new JLabel("n = ");
        pLabel = new JLabel("p = ");
        nuLabel = new JLabel("nu = ");
        wLabel = new JLabel("w = ");
        ticksLabel = new JLabel("ticks = ");
        fieldl.setText(""+l);
        fieldn.setText(""+n);
        fieldp.setText(""+p);
        fieldnu.setText(""+nu);
        fieldw.setText(""+w);
        fieldticks.setText(""+ticks);
        fields.add(wLabel);
        fields.add(fieldw);
        fields.add(lLabel);
        fields.add(fieldl);
        fields.add(pLabel);
        fields.add(fieldp);
        fields.add(nuLabel);
        fields.add(fieldnu);
        fields.add(nLabel);
        fields.add(fieldn);
        fields.add(ticksLabel);
        fields.add(fieldticks);
        ////////////////////////////////////////////////////////////////////////
        

        
        checkBoxes.add(showCollection);
        //checkBoxes.add(showLegend);


        jPanel2.setLayout(new java.awt.BorderLayout());
        mainPanel.setLayout(new java.awt.BorderLayout());
        
        
        
        jPanel2.add(checkBoxes, BorderLayout.NORTH);
        jPanel2.add(slider, BorderLayout.CENTER);
        jPanel2.add(textField, BorderLayout.SOUTH);
        
        mainPanel.add(fields, BorderLayout.EAST);
        mainPanel.add(cp,BorderLayout.NORTH);
        mainPanel.add(jPanel2, BorderLayout.SOUTH);                       
        slider.addChangeListener(listener);
        
        
        add(mainPanel);
        //this.pack();                
}    
}
