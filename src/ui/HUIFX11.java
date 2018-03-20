/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.*;
import static java.lang.Math.*;
import javax.swing.*;
import javax.swing.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import org.jfree.chart.title.*;
import static ui.НовыйClassFrame.t;
import static ui.НовыйClassFrame.ticks;

public class HUIFX11{

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

    private static double i[], k[], u[][];
    
    
    public static void create(int kk){
        for(int j = 0; j < k.length; j++){
            for(int m = 0; m < i.length; m++){
                u(m, j);
            }
        }
        if(!series.isEmpty())
            series.clear();
        for(int l = 0; l < i.length; l++){
            series.add(l, u[l][kk]);
        }
    }
    
    public static void update(int k)
    {       
        series.clear();
        for(int i = 0; i<=l; i++){
            series.add(i, u[k][i]);
        }
        t = k;
    }
    
    
    private static void u(int ii, int kk){

        if( ii == 0  ||  ii ==  99) u[kk][ii] = 0;                                      // граничные условия
        else
            if( kk == 0 )  u[0][ii] = 0;                                                  // начальные условия
            else
                if( kk == 1 )  u[1][ii] =  u[0][ii] + ht * p(ii);
                else
                {
                    double ny = pow(a * ht / hx, 2);
                    double x = i[ii], t = k[kk-1];
                    u[kk][ii] = 2 * u[kk-1][ii] - u[kk-2][ii] + ny * u[kk-1][ii+11] - 2 * ny * u[kk][ii-1] + u[kk-1][ii-1] + pow(ht, 2) * phi(x, t);
                }
    
        
    }
    
    private static double p(int ii){
        double x = i[ii];

        return ht * phi(x, 0) / 2;
    }

    private static double phi(double x, double t){
        return alpha(x) * sin(w * t);
    }
    
    private static double alpha(double x){
        if(x < l/3)  return 3 * x / l;
        else  return (3 / 2 - 3 / (2 * l * x)); 
    }
    
    static double a, w, l, p, t, nu, ticks, K, hx, ht;
    private static ChartPanel cp;
    static XYSeriesCollection dataset;
    static XYSeries series;
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
        
        a = 1; w = 2*PI/3; l = 1;
        p = 1;
        nu = 1;
        ticks = 0.5;
        K = 10;
        
        hx = 1/100;
        ht = ticks;
        int t = 0;
        
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
        slider.setMaximum((int)Math.round(K/ticks));
        slider.setMinimum(0);
        slider.setValue(0);
        listener = (ChangeEvent event) -> {
                if(!fieldp.getText().isEmpty()){
                    p = Double.parseDouble(fieldp.getText());
                }
                if(ticks != Double.parseDouble(fieldticks.getText())){
                    ticks = Double.parseDouble(fieldticks.getText());                            
                }                        
                if(!fieldnu.getText().isEmpty())
                    nu = Double.parseDouble(fieldnu.getText());
                if(!fieldw.getText().isEmpty())
                    w = Double.parseDouble(fieldw.getText());
                if(!fieldl.getText().isEmpty())
                    l = Double.parseDouble(fieldl.getText());



                hx = 1/100;
                ht = ticks;
                textField.setText(""+k);

                a = p/nu;

                JSlider source = (JSlider) event.getSource();
                int tnew = (int)source.getValue();
                hx = 1/100;
                ht = ticks;
                textField.setText(""+tnew);

                a = p/nu;

                if(t != tnew){
                    update(tnew);
                }else{
                    i = new double[100];
                    for(int j = 0; j < 100; j++){
                        i[j] = j/100;
                    }

                    k = new double[(int)Math.round(K/ticks)];
                    for(int l = 0; l < k.length; l++){
                        k[l] += ticks;
                    }
                    u = new double[(int)Math.round(K/ticks)][100];
                    create(tnew);
                }
        };
        ////////////////////////////////////////////////////////////////////////
        
        
        ////////////////////////////////////////    
       
        dataset = new XYSeriesCollection();        
        chart = ChartFactory.createXYLineChart("", "x", "y", dataset, PlotOrientation.VERTICAL, true, true,false);
        chart.setBackgroundPaint(Color.white);
        
        XYPlot plot = chart.getXYPlot();
        chart.getXYPlot().setFixedRangeAxisSpace(chart.getXYPlot().getFixedDomainAxisSpace());        
        cp = new ChartPanel(chart);
        
        
        series = new XYSeries("Sum");
        
        i = new double[100];
        for(int j = 0; j < 100; j++){
            i[j] = (double)j/100;
        }

        k = new double[20];
        for(int l = 0; l < k.length; l++){
            k[l] = l*ticks;
        }
        u = new double[20][100];
        create(0);
        dataset.addSeries(series);
        showCollection.setSelected(true);
        //cp.getChart().removeLegend();
        
        ////////////////////////////////////////////////////////////////////////
        textField = new JTextField();
        JLabel wLabel, lLabel, pLabel, nuLabel, nLabel, ticksLabel;
        lLabel = new JLabel("l = ");
        pLabel = new JLabel("p = ");
        nuLabel = new JLabel("nu = ");
        wLabel = new JLabel("w = ");
        ticksLabel = new JLabel("ticks = ");
        fieldl.setText(""+l);
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
