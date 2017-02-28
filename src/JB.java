import java.util.Calendar;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

//getters and setters

public class JB {
	private JTextField txtdata;
	private JButton calbtn;
    private JButton callForecast;
    private JLabel tytul;
    private JLabel labelPytanie;
    private JLabel labelOdpowiedz;
    private JLabel labelOdpowiedz2;
    private JLabel blad;
    private JPanel myPanel;
    private JPanel line1;
    private JPanel line2;
    private JPanel line3;
    private JPanel line4;
    private JPanel gridPanel;
    
    private double temperatura;
    private double cisnienie;
    private double wiatr;
    private double temperaturaF;
    private double cisnienieF;
    private double wiatrF;
    
    private int zachmurzenie;
    private int zachmurzenieF;
    
    private ImageIcon icon;
    private ImageIcon iconF;
    
    private String ikona;
    private String ikonaF;
    
    private UtilDateModel model;
    private Properties prop;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private String data;
    private Calendar calendar;
    private String day; 
    private String month;
    private int year;
	
	
	public JTextField getTxtdata() {
		return txtdata;
	}
	public void setTxtdata(JTextField txtdata) {
		this.txtdata = txtdata;
	}
	public JButton getCalbtn() {
		return calbtn;
	}
	public void setCalbtn(JButton calbtn) {
		this.calbtn = calbtn;
	}
	public JButton getCallForecast() {
		return callForecast;
	}
	public void setCallForecast(JButton callForecast) {
		this.callForecast = callForecast;
	}
	public JLabel getTytul() {
		return tytul;
	}
	public void setTytul(JLabel tytul) {
		this.tytul = tytul;
	}
	public JLabel getLabelPytanie() {
		return labelPytanie;
	}
	public void setLabelPytanie(JLabel labelPytanie) {
		this.labelPytanie = labelPytanie;
	}
	public JLabel getLabelOdpowiedz() {
		return labelOdpowiedz;
	}
	public void setLabelOdpowiedz(JLabel labelOdpowiedz) {
		this.labelOdpowiedz = labelOdpowiedz;
	}
	public JLabel getLabelOdpowiedz2() {
		return labelOdpowiedz2;
	}
	public void setLabelOdpowiedz2(JLabel labelOdpowiedz2) {
		this.labelOdpowiedz2 = labelOdpowiedz2;
	}
	public JLabel getBlad() {
		return blad;
	}
	public void setBlad(JLabel blad) {
		this.blad = blad;
	}
	public JPanel getMyPanel() {
		return myPanel;
	}
	public void setMyPanel(JPanel myPanel) {
		this.myPanel = myPanel;
	}
	public JPanel getLine1() {
		return line1;
	}
	public void setLine1(JPanel line1) {
		this.line1 = line1;
	}
	public JPanel getLine2() {
		return line2;
	}
	public void setLine2(JPanel line2) {
		this.line2 = line2;
	}
	public JPanel getLine3() {
		return line3;
	}
	public void setLine3(JPanel line3) {
		this.line3 = line3;
	}
	public JPanel getLine4() {
		return line4;
	}
	public void setLine4(JPanel line4) {
		this.line4 = line4;
	}
	public JPanel getGridPanel() {
		return gridPanel;
	}
	public void setGridPanel(JPanel gridPanel) {
		this.gridPanel = gridPanel;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getCisnienie() {
		return cisnienie;
	}
	public void setCisnienie(double cisnienie) {
		this.cisnienie = cisnienie;
	}
	public double getWiatr() {
		return wiatr;
	}
	public void setWiatr(double wiatr) {
		this.wiatr = wiatr;
	}
	public double getTemperaturaF() {
		return temperaturaF;
	}
	public void setTemperaturaF(double temperaturaF) {
		this.temperaturaF = temperaturaF;
	}
	public double getCisnienieF() {
		return cisnienieF;
	}
	public void setCisnienieF(double cisnienieF) {
		this.cisnienieF = cisnienieF;
	}
	public double getWiatrF() {
		return wiatrF;
	}
	public void setWiatrF(double wiatrF) {
		this.wiatrF = wiatrF;
	}
	public int getZachmurzenie() {
		return zachmurzenie;
	}
	public void setZachmurzenie(int zachmurzenie) {
		this.zachmurzenie = zachmurzenie;
	}
	public int getZachmurzenieF() {
		return zachmurzenieF;
	}
	public void setZachmurzenieF(int zachmurzenieF) {
		this.zachmurzenieF = zachmurzenieF;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public ImageIcon getIconF() {
		return iconF;
	}
	public void setIconF(ImageIcon iconF) {
		this.iconF = iconF;
	}
	public String getIkona() {
		return ikona;
	}
	public void setIkona(String ikona) {
		this.ikona = ikona;
	}
	public String getIkonaF() {
		return ikonaF;
	}
	public void setIkonaF(String ikonaF) {
		this.ikonaF = ikonaF;
	}
	public UtilDateModel getModel() {
		return model;
	}
	public void setModel(UtilDateModel model) {
		this.model = model;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public JDatePanelImpl getDatePanel() {
		return datePanel;
	}
	public void setDatePanel(JDatePanelImpl datePanel) {
		this.datePanel = datePanel;
	}
	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}
	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	


}
