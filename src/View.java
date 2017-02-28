import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class View extends JFrame {

	JB bean = new JB();
	
	JTextField txtdata;
	JButton calbtn;
	JButton callForecast;
	JLabel tytul;
    JLabel labelPytanie;
    JLabel labelOdpowiedz;
    JLabel labelOdpowiedz2;
    JLabel blad;
    JPanel myPanel;
    JPanel line1;
    JPanel line2;
    JPanel line3;
    JPanel line4;
    JPanel gridPanel;
    
 
    UtilDateModel model;
    Properties prop;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    String data;
    Calendar calendar;
    String day;
    String month;
    int year;
    
    
    
    
    
   
	public View() throws IOException {
		
	// wszystkie komponenty odpowiedzialne za WIDOK
	// zagnieżdżone FlowLayout  -> GridLayout -> BorderLayout
		
		bean.setCalbtn(new JButton("Sprawdź pogodę    "));
		calbtn = bean.getCalbtn();
		
		bean.setCallForecast(new JButton("<html><center>Sprawdź prognoze<br>na najbliższe<br>5 dni</center></html>"));
		callForecast = bean.getCallForecast();
		
		bean.setModel(new UtilDateModel());
		model = bean.getModel();
		
		
    	bean.setProp(new Properties());
    	prop = bean.getProp();
    	
		
    	prop.put("text.today", "Today");
    	prop.put("text.month", "Month");
        prop.put("text.year", "Year");
    	
        bean.setDatePanel(new JDatePanelImpl(model,prop));
        datePanel = bean.getDatePanel();
        
        
    	
        
        bean.setDatePicker(new JDatePickerImpl(datePanel, new DateLabelFormatter()));
        datePicker = bean.getDatePicker();
        
      
    	
        bean.setCalendar(Calendar.getInstance());
        calendar = bean.getCalendar();
        
        
        bean.setDay(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));
        day = bean.getDay();
        
        
        bean.setMonth(String.format("%02d", calendar.get(Calendar.MONTH)));
        month = bean.getMonth();
        
        
        bean.setYear(calendar.get(Calendar.YEAR));
        year = bean.getYear();
     
        
        
        model.setDate(year, Integer.parseInt(month), Integer.parseInt(day));
    	model.setSelected(true);
    	
    	
    	
    	BufferedImage myImage = ImageIO.read(new File("images/backGround.jpg"));
    	JFrame myJFrame = new JFrame("Image pane");
    	myJFrame.setContentPane(new JPanelWithBackground(myImage));
    	
    	bean.setMyPanel(new JPanelWithBackground(myImage));
    	myPanel = bean.getMyPanel();
    	
    	
        
    	add(myPanel);
    	
        
        String p = "<html>Wpisz nazwe miasta<br> które Cie interesuje</html>";
        
        bean.setTytul(new JLabel("Weather Application"));
        tytul = bean.getTytul();
        
        
    	tytul.setFont(new Font("Arial Black", Font.BOLD, 18));
        
        bean.setLabelPytanie(new JLabel(p));
        labelPytanie = bean.getLabelPytanie();
        
        labelPytanie.setFont(new Font("Serif", Font.BOLD, 18));
        
        bean.setLabelOdpowiedz(new JLabel());
        labelOdpowiedz = bean.getLabelOdpowiedz();
        
        
        bean.setLabelOdpowiedz(new JLabel());
        labelOdpowiedz2 = bean.getLabelOdpowiedz();
        
        
        
        bean.setBlad(new JLabel());
        blad = bean.getBlad();
       
        
        myPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        bean.setLine1(new JPanelWithBackground(myImage));
        line1 = bean.getLine1(); 
        line1.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        bean.setLine2(new JPanelWithBackground(myImage));
        line2 = bean.getLine2();
        line2.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        bean.setLine3(new JPanelWithBackground(myImage));
        line3 = bean.getLine3();
        line3.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        bean.setLine4(new JPanelWithBackground(myImage));
        line4 = bean.getLine4();
        line4.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        
        bean.setGridPanel(new JPanelWithBackground(myImage));
        gridPanel = bean.getGridPanel();
        gridPanel.setLayout(new GridLayout(0,1));
        
        gridPanel.add(line1);
        gridPanel.add(line2);
        gridPanel.add(line3);
        gridPanel.add(line4);
        
        
        
        
        bean.setTxtdata(new JTextField("Wpisz nazwę miasta", 18));
        txtdata = bean.getTxtdata();
         
        
        line1.add(tytul);
        
        line2.add(calbtn);
        line2.add(bean.getTxtdata());
        line2.add(labelOdpowiedz);
        
        line3.add(callForecast);
        line3.add(datePicker);
        line3.add(labelOdpowiedz2);
        
        line4.add(blad);
        myPanel.add(gridPanel, BorderLayout.CENTER);
	}
	 
		

}