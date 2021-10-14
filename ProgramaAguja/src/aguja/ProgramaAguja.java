package aguja;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/*
López Chaparro Kevin Manuel
Leyva González Jesús Nahel
Peñuelaz Leyva Luis Alberto
Uriarte Avelar Jesus Eduardo
*/
		
		public class ProgramaAguja extends JFrame {
			static XYSeries Val = new XYSeries("Valor");
		    public ProgramaAguja () {
		        this.setTitle( "Aguja de Buffon." );
		        this.setSize(600,350);
		        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		        this.setVisible(true);
		    }

		    public static void main (String [] args) {
		        new ProgramaAguja();
		        XYSeriesCollection dataset = new XYSeriesCollection();
			    dataset.addSeries(Val);
				JFreeChart lineChart = ChartFactory.createXYLineChart("Aguja de buffon", "Intentos", "PI", dataset);
				ChartPanel panel = new ChartPanel(lineChart);
				JFrame ventana = new JFrame("Grafica Aguja de buffon - Equipo 5");
				ventana.setSize(800, 600);
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				panel.setSize(600, 400);
				ventana.add(panel);
				ventana.setVisible(true);
		    }

		    public void paint (Graphics g) {
		        Scanner leer= new Scanner(System.in);
		        int NAgujas, x1, x2, y1, y2, s1, s2, s3, p1, p2, exitos=0;
		        double b;
		        System.out.println("Numero de agujas a lanzar: ");
		        NAgujas = leer.nextInt();

		        g.drawLine(50, 100, 500, 100);
		        g.drawLine(50, 250, 500, 250);

		        g.drawLine(50, 100, 50, 250);
		        g.drawLine(200, 100, 200, 250);
		        g.drawLine(350, 100, 350, 250);
		        g.drawLine(500,100, 500, 250);

		        for(int x=1; x<=NAgujas; x++)
		        {
		            do {
		                x1=(int)(Math.random()*(450-50+1)+50);
		                x2=(int)(Math.random()*(450-50+1)+50);
		                y1=(int)(Math.random()*(250-100+1)+100);
		                y2=(int)(Math.random()*(250-100+1)+100);
		                s1=x1-x2;
		                s2=y1-y2;
		                p1=(int)Math.pow(s1, 2);
		                p2=(int)Math.pow(s2, 2);
		                s3=p1+p2;
		            }while((int)Math.sqrt(s3)!=50);
		            g.drawLine(x1, y1, x2, y2);

		            if((x1>50 && x1<200))
		            {
		                exitos++;
		                
		            }
		            if((x1>350 && x1<500))
		            {
		                exitos++;
		            	
		            }
		            	
		            b=(double)(x*2)/exitos;
		            Val.add(x, b);
		            System.out.println("π["+x+"]= "+b);
		        }
		        System.out.println("Exitos= "+exitos);
		        
		    
		       
			
		}

}

