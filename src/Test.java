import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Test {
  public static void main(String args[]) {
	  Calendar calendar = Calendar.getInstance();
	  System.out.println(calendar.get(calendar.DAY_OF_MONTH));
	  System.out.println(calendar.get(calendar.MONTH));
	  System.out.println(calendar.get(calendar.YEAR));
	  
	  String dzien = String.format("%02d", calendar.get(calendar.MONTH));
	  System.out.println(dzien);
  }
}
