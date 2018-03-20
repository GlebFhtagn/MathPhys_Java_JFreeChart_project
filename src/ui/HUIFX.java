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
import javax.swing.JSplitPane;
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

/**
 *
 * @author Глеб
 */
public class HUIFX{

        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				НовыйClassFrame1 frame = new НовыйClassFrame1(800, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}


class НовыйClassFrame1 extends JFrame{
//    
//    public static double U(int i, double x, double t){
//        double result = 0;
//        double pi = Math.PI;
//        x /= 100;
////        result = (9*l*sin(PI*n/3)/(pow(PI*n, 3)*a)-3*l*sin(PI*n)/(pow(PI*n, 3)*a))
////                    *(2*l/(pow(w*l, 2)-pow(PI*n*a, 2)))
//                    /*(2/l)*(2*l*cos(PI*n/3)/(PI*n) - 3*l*sin(PI*n/3)/(2*pow(PI*n,2))-l*cos(PI*n/3)/(PI*n)-3*l*sin(PI*n)/(2*pow(PI*n,2)))
//                    *(l/(PI*n*a))*(1/(pow(l*w,2) - pow(PI*n*a, 2)))*/
//                    /*(2*l*l/(pow(w*l*PI*n, 2)*a - pow(PI*n*a, 3)*PI*n))
//                    *(3*(3*sin(PI*n/3)-sin(PI*n))/(PI*n) + 6*cos(PI*n) - 4*cos(PI*n/3))*/
//                   /*(6*(l/(PI*n*a*pow(PI*n, 2))*sin(PI*n/3) - 3/(PI*n*a*pow(PI*n, 2))*sin(PI*n)))*
//                    l/(PI*n*a)*6/(PI*n)*(sin(2*PI*n/3)*cos(PI*n/3)/PI/n-cos(PI*n))*/
////                    *(PI*n*a*sin(w*t)-w*l*sin(PI*n*a*t/l))
////                    * sin(PI*n*x/l);
//        result = 4*(3*pi*i*cos(i))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l))*sin(pi*i*x/l)/(Math.pow(pi*i, 3)*a);
//        
//        return result;
//    }
// 
//    public static void createCollectionOfU(int n1, double t){
//        
//        dataset.removeAllSeries();
//        series = new XYSeries[n1+1]; 
//            for(int currentN = 0; currentN < n1; currentN++){
//                series[currentN] = new XYSeries(""+(currentN));
//            }
//        
//        for(int currentN = 1; currentN <= n1; currentN++){
//            for(int i = 0; i<=l; i++){
//                series[currentN-1].add(i, U(currentN, i, t));
//            }
//        }
//        
//        series[n1] = new XYSeries("Sum");
//        for(int i = 0; i<=l; i++){
//            series[n1].add(i, getUxt(10, i, t));
//        }
//        
//        if(dataset.getSeriesCount() != 0){
//            dataset.removeAllSeries();
//        }
//        for(int i = 0; i <= n; i++)
//           dataset.addSeries(series[i]);
//           legend = cp.getChart().getLegend();
//    }
//    public static void updateCollectionOfU(int n1, double t){
//        for(int currentN = 1; currentN <= n1; currentN++){
//            series[currentN-1].clear();
//            for(int i = 0; i<=l; i++){
//                series[currentN-1].add(i, U(currentN, i, t));
//            }
//        }
//        series[n1].clear();
//        for(int i = 0; i<=l; i++){
//            series[n1].add(i, getUxt(10, i, t));
//        }
//    }
    //                        if(showCollection.isSelected())
//                        {
//                            if(n != (int)Double.parseDouble(fieldn.getText())){
//                                n = (int)Double.parseDouble(fieldn.getText());
//                                createCollectionOfU(n, ((double)source.getValue()*ticks));
//                            }
//                            else
//                                updateCollectionOfU(n, ((double)source.getValue()*ticks));
//                        }else
//                        {
    public static double getUxt(int n, double x, double t){
        double result = 0;
        for(int i = 1; i <= n; i++){
            result += (2*(l*(7*sin(pi*i/3)- 3*sin(pi*i)+ 0.1*pi*i*cos(pi*i/3)))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l))*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
        }
        return result;
    }
    public static double getUxt1( double x, double t, double e){
        double result = 0;
        double previous;                                                        // переменная для хранения предыдщего значения элемента суммы
        double res = 1;                                                         // переменная для проверки выполенения условия точности
        int i = 1;                                                              // для того чтобы не терять значения точности,
                                                                                //  выполняем первый круг цикла заранее, тем самым выделяем первый "прошлый" элемент
        result += (2*(l*(7*sin(pi*i/3)- 3*sin(pi*i)+ 0.1*pi*i*cos(pi*i/3)))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l))*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
        i = 2;
        previous = result;
        if(Math.abs(previous - 0) > e)
        while(res > e){                                                         // условие точности
                result += (2*(l*(7*sin(pi*i/3)- 3*sin(pi*i)+ 0.1*pi*i*cos(pi*i/3)))*(pi*i*a*sin(w*t) + w*l*sin(pi*i*a*t/l))*sin(pi*i*x/l))/(Math.pow(pi*i, 3)*a);
                res = Math.abs(previous - result);
                //res = previous - result;                                        // возможно взятие положительной части разности дает эффект на точность
                i++;
                previous = result;
        }
        currentN = i;
        return result;
    }
    public static void createSummU(int n, double t){
        dataset.removeAllSeries();
        series = new XYSeries[1];
        series[0] = new XYSeries("Sum");
        double dx = l/x;
        for(int i = 0; i<=x; i++){
            series[0].add(dx*i*100, getUxt(n, dx*i, t));
        }
        if(dataset.getSeriesCount() != 0){
            dataset.removeAllSeries();
        }
        dataset.addSeries(series[0]);
        legend = cp.getChart().getLegend();
        
    }
    public static void updateSummU(int n, double t){
        series[0].clear();
        double dx = l/x;
        for(int i = 0; i<=x; i++){
            series[0].add(dx*i*100, getUxt(n, dx*i, t));
        }
    }
    public static void createSummU1(double dx, double t, double e){
        dataset.removeAllSeries();
        series = new XYSeries[1];
        series[0] = new XYSeries("Sum");
        ns = new double[(int)Math.round(Math.floor(x))+1];
        for(int j = 0; j<x; j++){
            //series[0].add(dx*j*100, getUxt1(e, dx*j, t));
            getUxt1(dx*j, t, e);
            ns[j] = currentN;
        }        
        int fullN = 0;
        for(int i = 0; i <= x; i++){
            fullN += ns[i];
        }
        int quantityNs = ns.length;
        averageN = (int)Math.round(fullN/quantityNs);
        for(int i = 0; i<=x; i++){
            series[0].add(dx*i*100, getUxt(averageN, dx*i, t));
        }
        if(dataset.getSeriesCount() != 0){
            dataset.removeAllSeries();
        }
        dataset.addSeries(series[0]);
        legend = cp.getChart().getLegend();
        
    }
    public static void updateSummU1(double dx, double t, double e){
        series[0].clear();
        ns = new double[(int)Math.round(Math.floor(x))+1];
        for(int i = 0; i<=x; i++){
            //series[0].add(dx*i*100, getUxt1(e, dx*i, t));
            getUxt1(dx*i, t, e);
            ns[i] = currentN;
        }        
        
        int fullN = 0;
        for(int i = 0; i < x; i++){
            fullN += ns[i];
        }
        int quantityNs = ns.length;
        averageN = (int)Math.round(fullN/quantityNs);
        
        for(int i = 0; i<=x; i++){
            series[0].add(dx*i*100, getUxt(averageN, dx*i, t));
        }
    }
    
    
    НовыйClassFrame1(int width, int height) {
        
        this.setSize(width, height);
        
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
        slider.setMaximum(100);
        slider.setMinimum(0);
        slider.setValue(0);
        listener = (ChangeEvent event) -> {
                        
            if(!fieldp.getText().isEmpty())
                p = Double.parseDouble(fieldp.getText());
            if(ticks != Double.parseDouble(fieldticks.getText())){
                ticks = Double.parseDouble(fieldticks.getText());
                slider.setMaximum((int)Math.floor(10/ticks));
            }                        
            if(!fieldnu.getText().isEmpty())
                nu = Double.parseDouble(fieldnu.getText());
                a = p/nu;
            if(!fieldw.getText().isEmpty())
                w = Double.parseDouble(fieldw.getText());
            if(!fieldl.getText().isEmpty())
                l = Double.parseDouble(fieldl.getText());
            if(!fieldx.getText().isEmpty())
                x = Double.parseDouble(fieldx.getText());

            JSlider source = (JSlider) event.getSource();


                if(buttonB.isSelected()){
                    double dx = l/x;                                //настоящий размер деления по оси х, переменная х это количество делений 
                    if(e != (int)Double.parseDouble(fieldE.getText())){
                    //    e = (int)Double.parseDouble(fieldE.getText());
                        createSummU1(dx, ((double)source.getValue()*ticks),  e);
                    }
                    else
                        updateSummU1(dx, ((double)source.getValue()*ticks), e);

                    NLabel.setText(""+averageN);
                }
                else{
                    NLabel.setText("");
                    if(n != (int)Double.parseDouble(fieldn.getText())){
                        n = (int)Double.parseDouble(fieldn.getText());
                        createSummU(n, ((double)source.getValue()*ticks));
                    }
                    else
                        updateSummU(n, ((double)source.getValue()*ticks));
                }
            //}
            textField.setText(""+((double)source.getValue())*ticks);

            if(showLegend.isSelected()){
                cp.getChart().addLegend(legend);
            }
            else cp.getChart().removeLegend();
            a = p/nu;
        };
        ////////////////////////////////////////////////////////////////////////
        
        a = 1; w = 2*PI/3; l = 1;
        n = 10;
        int oldN = n;
        p = 1;
        nu = 1;
        ticks = 0.1;
        t = 20;
        x = 100;
        e = 0.001;
        
        ////////////////////////////////////////    
       
        dataset = new XYSeriesCollection();
        
        
        chart = ChartFactory.createXYLineChart("", "x", "y", dataset, PlotOrientation.VERTICAL, true, true,false);
        chart.setBackgroundPaint(Color.white);
        
        XYPlot plot = chart.getXYPlot();
        chart.getXYPlot().setFixedRangeAxisSpace(chart.getXYPlot().getFixedDomainAxisSpace());        
        cp = new ChartPanel(chart);

        createSummU(n, 0);        
        showCollection.setSelected(false);
        //cp.getChart().removeLegend();
        
        ////////////////////////////////////////////////////////////////////////
        textField = new JTextField();
        JLabel wLabel, lLabel, pLabel, nuLabel, nLabel, ticksLabel, xLabel, eLabel;
        lLabel = new JLabel("l = ");
        nLabel = new JLabel("n = ");
        pLabel = new JLabel("p = ");
        nuLabel = new JLabel("nu = ");
        wLabel = new JLabel("w = ");
        ticksLabel = new JLabel("ticks = ");
        xLabel = new JLabel("x = ");
        eLabel = new JLabel("e = ");
        NLabel = new JLabel("");
        fieldl.setText(""+l);
        fieldn.setText(""+n);
        fieldp.setText(""+p);
        fieldnu.setText(""+nu);
        fieldw.setText(""+w);
        fieldticks.setText(""+ticks);
        fieldx.setText(""+x);
        fieldE.setText(""+e);
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
        fields.add(xLabel);
        fields.add(fieldx);
        ////////////////////////////////////////////////////////////////////////
        

        
        checkBoxes.add(eLabel);
        checkBoxes.add(fieldE);
        checkBoxes.add(buttonB);
        checkBoxes.add(NLabel);
        //checkBoxes.add(showLegend);


        jPanel2.setLayout(new java.awt.BorderLayout());
        mainPanel.setLayout(new java.awt.BorderLayout());
        
        
        
        jPanel2.add(checkBoxes, BorderLayout.NORTH);
        jPanel2.add(slider, BorderLayout.CENTER);
        jPanel2.add(textField, BorderLayout.SOUTH);
        
        verticalSplitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cp, fields);
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(verticalSplitPanel, BorderLayout.CENTER);
        mainPanel.add(jPanel2, BorderLayout.SOUTH);                       
        slider.addChangeListener(listener);
        
        this.setLayout(new java.awt.BorderLayout());
        add(mainPanel);
        //this.pack();                
} 
    
    
    static double a, w, l, p, t, nu, ticks, x, e;
    static int n;
    static JSplitPane verticalSplitPanel;
    private static ChartPanel cp;
    static XYSeriesCollection dataset;
    static XYSeries series[];
    private JPanel mainPanel;
    private static ChangeListener listener;
    static JSlider slider;
    static JCheckBox showCollection = new JCheckBox("show all of series");
    static JCheckBox buttonB = new JCheckBox("N?");
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
    private static JTextField fieldx = new JTextField(10);
    private static JTextField fieldE = new JTextField(10);
    JLabel NLabel;
    static double[] ns;
    static int currentN;
    static int averageN;
    
    private static LegendTitle legend;
    public static final int DEFAULT_WIDTH = 1080;
    public static final int DEFAULT_HEIGHT = 1080;
    static double pi = Math.PI;
}
