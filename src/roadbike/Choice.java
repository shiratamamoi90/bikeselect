package roadbike;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Choice extends JDialog{

	String[] source;
	String bi = null;
	ArrayList<String> biarray = new ArrayList<String>();
	String[] bikeinfo;
	private JPanel cp;
	private JLabel lb;
	private JList list;
	private JScrollPane sp;
	private StringBuffer sb;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Choice(JFrame fr, String[] source) {
		super(fr);
		this.source = source;

		getContentPane().setLayout(new FlowLayout());

		setTitle("RESULT");
		setSize(500, 600);
		setVisible(true);

		cp = new JPanel();
		getContentPane().add(cp);

		sb = new StringBuffer();
		sb.append("<html><body>");
		for(int i = 0; i < source.length; i++) {
			sb.append(source[i]);
			sb.append("<br>");
		}
		sb.append("</body></html>");

		lb = new JLabel();
		lb.setText(sb.toString());
		lb.setBounds(20, 20, 150, 200);
		getContentPane().add(lb);

		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/bike",
					"root",
					"tufTrek7110"
					);

			//ps = con.prepareStatement("SELECT * FROM bikeinfo");
			ps = con.prepareStatement(selectbike(source));

			rs = ps.executeQuery();

			while(rs.next()) {
				bi = rs.getString("name");
				bi += "|" + rs.getString("year");
				biarray.add(bi);
			}

			ps.close();
			rs.close();

			bikeinfo = biarray.toArray(new String[0]);

			list = new JList();
			list.setListData(bikeinfo);

			sp = new JScrollPane();
			sp.getViewport().setView(list);
			sp.setOpaque(true);
			sp.setBounds(1700, 20, 200, 200);
			sp.setPreferredSize(new Dimension(200, 100));
			getContentPane().add(sp);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	String selectbike(String[] source) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sbwhere = new StringBuffer();
		String s = null;
		int x = 0, y = 0;

		sb.append("SELECT * FROM bikeinfo");
		sbwhere.append(" where");

		for(int i = 1; i < source.length; i++) {
			System.out.println(source[i]);
			if(source[i] == null || source[i].equals("")) {
			} else if(source[i].equals("Neither")) {
			} else {
				if(i == 1) sbwhere.append(" gender = '");
				if(i == 2) sbwhere.append(" style = '");
				if(i == 3) sbwhere.append(" type = '");
				if(i == 4) sbwhere.append(" material = '");
				if(i == 5) sbwhere.append(" maker = '");
				if(i == 9) sbwhere.append(" cost<" + source[9]);
				if(i == 10) sbwhere.append(" cost>" + source[10]);
				sbwhere.append(source[i]);
				sbwhere.append("' and");
				x++;
				y = 1;
			}
		}

		if(y != 0) {
			sbwhere.delete(sbwhere.length()-4, sbwhere.length());
		}

		if(x != 0) {
			sb.append(sbwhere);
		}

		sb.append(";");
		s = sb.toString();

		System.out.println(x);
		System.out.println(s);
		return s;
	}

}