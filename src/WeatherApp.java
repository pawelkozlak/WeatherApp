import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.apache.commons.io.IOUtils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherApp  implements ActionListener, FocusListener
{
	private View view;
	private JB bean;
 
    JSONParseToObject json;
    JSONParseToObject jsonForecast;
    JSONObject jArrayF;
    
    double temperatura, cisnienie, wiatr, temperaturaF, cisnienieF, wiatrF;
    int zachmurzenie, zachmurzenieF;
    
    ImageIcon icon, iconF;
    String ikona, ikonaF;

    public WeatherApp(View v, JB jb) throws IOException, JSONException
    {
    	this.view = v;
    	this.bean= jb;
    
        view.calbtn.addActionListener(this);
        view.callForecast.addActionListener(this);  
        view.txtdata.addFocusListener(this);
        
    }
 
	@Override
	public void focusGained(FocusEvent e) {	
		view.txtdata.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		
	}
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == view.calbtn) {
        	view.data = view.txtdata.getText(); 
          
            try {
            	json = new JSONParseToObject(view.data);
            	
            	bean.setTemperatura(json.getTemperature());
            	bean.setCisnienie(json.getCisnienie());
            	bean.setWiatr(json.getWiatr());
            	bean.setZachmurzenie(json.getZachmurzenie());
            	bean.setIkona(json.getIkona());

            	
            	
            	temperatura = bean.getTemperatura();
            	cisnienie = bean.getCisnienie();
            	wiatr = bean.getWiatr();
            	zachmurzenie = bean.getZachmurzenie();
            	ikona = bean.getIkona();
            	
            	            	
            	
            	view.labelOdpowiedz.setFont(new Font("Serif", Font.PLAIN, 14));
				view.labelOdpowiedz.setText("<html>temperatura: "+temperatura+"°С<br> "
				+"ciśnienie "+cisnienie+" hpa<br>"+" wiatr: "+ wiatr+" m/s<br>"
				+" zachmurzenie: "+zachmurzenie+"%");
			    
				icon = createImageIcon("images/"+ikona+".png", "ikona");
				view.labelOdpowiedz.setIcon(icon);	
				
				view.blad.setText("");
			    
			   
            } catch (JSONException | IOException e1) {
				view.blad.setText("Brak lub niepoprawna nazwa miasta!");			
			}
           
        }

    	if(e.getSource() == view.callForecast) {
        	

        	try {
        		jsonForecast = new JSONParseToObject(view.data);
        		if(view.data == null) {	throw new IOException(); }
        		String miesiac = String.format("%02d", view.model.getMonth()+1);
        		String dzien = String.format("%02d", view.model.getDay());
        		
        		String currentDate = view.model.getYear()+"-"+miesiac+"-"+dzien+" 12:00:00";
        		JSONArray jArrayF = jsonForecast.getArray();
        		
        		view.blad.setText("");
        		
        		
        		for(int i=0; i<jArrayF.length(); i++){
				String choseDate = jArrayF.getJSONObject(i).getString("dt_txt");
					if(choseDate.equals(currentDate)){
						
						bean.setTemperaturaF(jArrayF.getJSONObject(i).getJSONObject("main").getDouble("temp"));	
						bean.setCisnienieF(jArrayF.getJSONObject(i).getJSONObject("main").getDouble("pressure"));
						bean.setWiatrF(jArrayF.getJSONObject(i).getJSONObject("wind").getDouble("speed"));
						bean.setZachmurzenieF(jArrayF.getJSONObject(i).getJSONObject("clouds").getInt("all"));
						bean.setIkonaF(jArrayF.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon"));
						
						temperaturaF = bean.getTemperaturaF();
						cisnienieF = bean.getCisnienieF();
						wiatrF = bean.getWiatrF();
						zachmurzenieF = bean.getZachmurzenieF();
						ikonaF = bean.getIkonaF();
						
						
		            	view.labelOdpowiedz2.setFont(new Font("Serif", Font.PLAIN, 14));
						view.labelOdpowiedz2.setText("<html>temperatura: "+temperaturaF+"°С<br> "
						+"ciśnienie "+cisnienieF+" hpa<br>"+" wiatr: "+ wiatrF+" m/s<br>"
						+" zachmurzenie: "+zachmurzenieF+"%");
					    
						icon = createImageIcon("images/"+ikonaF+".png", "ikona");
						view.labelOdpowiedz2.setIcon(icon);	
					
					}
					
				}
        	} catch (JSONException | IOException e1) {
        		view.blad.setText("Brak lub niepoprawna nazwa miasta!");
				
			}

    	}
    }
   
 // metoda tworząca Ikone na podstawie podanej sciezki dostepu
	
 		protected ImageIcon createImageIcon(String path,
 	            String description) {
 	    	java.net.URL imgURL = getClass().getResource(path);
 			if (imgURL != null) {
 			return new ImageIcon(imgURL, description);
 			} else {
 			System.err.println("Couldn't find file: " + path);
 			return null;
 			}
 		}
    

    public static void main(String args[]) throws IOException, JSONException
    {
    	View v = new View();
    	JB jb = new JB();
    	new WeatherApp(v, jb);
    	v.setLocation(300, 150);
        v.setSize(700, 400);
        v.setVisible(true);
        v.setResizable(false);
        
        
    }



	
}