package roadbike;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame implements ActionListener{

	private JPanel cp;
	private JTextField name;
	private JButton button;
	private ArrayList<JLabel> lb_right = new ArrayList<JLabel>();
	private ArrayList<JLabel> lb_left = new ArrayList<JLabel>();
	private JList list_gender,
					 list_ride,
					 list_bike,
					 list_material,
					 list_maker,
					 list_height;
	private JScrollPane sp_gender,
							  sp_ride,
							  sp_bike,
							  sp_material,
							  sp_maker,
							  sp_height;
	private JTextField leg;
	private JTextField arm;
	private JTextField max_cost;
	private JTextField min_cost;

	private String[] set_text_left = {"YOUR NAME",
											"YOUR GENDER",
											"RIDE STYLE",
											"BIKE TYPE",
											"BIKE MATERIAL",
											"BIKE MAKER"};
	private int[] set_posi_left = {10, 60, 150, 240, 360, 450};

	private String[] set_text_right = {"YOUR HEIGHT",
													"YOUR LEG",
													"YOUR ARM",
													"MAX COST",
													"MIN COST"};
	private int[] set_posi_right = {10, 130, 180, 230, 280};

	private String[] source = new String[11];

	private String[] data_gender = {"Neither",
												"men",
												"women"};

	private String[] data_ride = {"Neither",
											"Race",
											"LongRide",
											"Gravel",
											"Pottering",
											"DownHill",
											"XrossCountry",
											"Trail",
											"Enduro"};

	private String[] data_bike = {"Neither",
											"AeroRoad",
											"LightWeightRoad",
											"MultiRoad",
											"EnduranceRoad",
											"CrossBike",
											"PIST",
											"BMX",
											"MTBDoubleSas",
											"MTBSingleSas",
											"MiniBero",
											"MiniBeroRoad",
											"e-Boad",
											"e-Cross",
											"e-MTB"};

	private String[] data_material = {"Neither",
												"chromoly",
												"titanium",
												"aluminum",
												"carbon"};

	private String[] data_maker = {"Neither",
												//アメリカ
												"TREK",
												"SPECIALIZED",
												"CANNONDALE",
												"FUJI",
												"FELT",
												"MARIN",
												"ALL-CITY",
												"BLUE",
												//イタリア
												"BIANCHI",
												"GIOS",
												"PINARELLO",
												"COLNAGO",
												"CINELLI",
												"DEROSA",
												"WILIER",
												"KUOTA",
												"BASSO",
												"CARRERA",
												"DedacciaiSTRADA",
												"BOOTKEG",
												"BOTTECCHIA",
												"CASATI",
												//フランス
												"LOOK",
												"TIME",
												"LAPIERRE",
												//ドイツ
												"CANYON",
												"CUBE",
												"FOCUS",
												"CORRATEC",
												"CENTURION",
												//スイス
												"SCOTT",
												"BMC",
												//ベルギー
												"RIDLEY",
												//イギリス
												"RALEIGH",
												"FACTOR",
												//スペイン
												"ORBEA",
												"BH",
												//カナダ
												"CERVELO",
												"ARGON18",
												//台湾
												"GIANT",
												"LIV",
												"MERIDA",
												"GUSTO",
												//日本
												"ANCHOR",
												"YONEX",
												"KHODAABLOOM",
												"BOMA",
												"ARAYA",
												"AVEDIO",
												"BE-ALL",
												"CALAMITA",
												"CHERUBIM"};

	private String[] data_height = { "Neither",
												"140~145",
												"145~150",
												"150~155",
												"155~160",
												"160~165",
												"165~170",
												"170~175",
												"175~180",
												"180~185",
												"185~190"};

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setTitle("BIKE CHOICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		setResizable(false);
		cp = new JPanel();
		cp.setBorder(new EmptyBorder(5, 5, 5, 5));
		cp.setLayout(null);
		//cp.setBackground(new Color(30, 144, 255, 100));
		setContentPane(cp);

		name = new JTextField();
		name.setBounds(20, 30, 200, 20);
		getContentPane().add(name);

		leg = new JTextField();
		leg.setBounds(250, 150, 200, 20);
		getContentPane().add(leg);

		arm = new JTextField();
		arm.setBounds(250, 200, 200, 20);
		getContentPane().add(arm);

		max_cost = new JTextField();
		max_cost.setBounds(250, 250, 200, 20);
		getContentPane().add(max_cost);

		min_cost = new JTextField();
		min_cost.setBounds(250, 300, 200, 20);
		getContentPane().add(min_cost);;

		for(int i = 0; i < set_text_left.length; i++) {
			lb_right.add(new JLabel(set_text_left[i]));
			lb_right.get(i).setBounds(20, set_posi_left[i], 100, 20);
			lb_right.get(i).setHorizontalTextPosition(JLabel.RIGHT);
			getContentPane().add(lb_right.get(i));
		}

		for(int i = 0; i < set_text_right.length; i++) {
			lb_left.add(new JLabel(set_text_right[i]));
			lb_left.get(i).setBounds(250, set_posi_right[i], 100, 20);
			lb_left.get(i).setHorizontalTextPosition(JLabel.RIGHT);
			getContentPane().add(lb_left.get(i));
		}

		list_gender = set_list(sp_gender, data_gender, 20, 80, 200, 60);

		list_ride = set_list(sp_ride, data_ride, 20, 170, 200, 60);

		list_bike = set_list(sp_bike, data_bike, 20, 260, 200, 90);

		list_material = set_list(sp_material, data_material, 20, 380, 200, 60);

		list_maker = set_list(sp_maker, data_maker, 20, 470, 200, 120);

		list_height = set_list(sp_height, data_height, 250, 30, 200, 90);

		cp.setLayout(new BorderLayout());
		button = new JButton("CHOICE");
		button.addActionListener(this);
		getContentPane().add(button, BorderLayout.SOUTH);
	}

	public JList set_list(JScrollPane sp, String[] data, int x, int y, int w, int h) {
		JList list = new JList();
		list.setListData(data);

		sp = new JScrollPane();
		sp.getViewport().setView(list);
		sp.setOpaque(true);
		sp.setBounds(x, y, w, h);
		sp.setPreferredSize(new Dimension(200, 100));
		getContentPane().add(sp);

		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = name.getText();

		if(s.equals("")) {
			source[0] = "GUEST";
		} else {
			source[0] = s;
		}

		source[1] = (String)list_gender.getSelectedValue();
		source[2] = (String)list_ride.getSelectedValue();
		source[3] = (String)list_bike.getSelectedValue();
		source[4] = (String)list_material.getSelectedValue();
		source[5] = (String)list_maker.getSelectedValue();
		source[6] = (String)list_height.getSelectedValue();
		source[7] = (String)leg.getText();
		source[8] = (String)arm.getText();
		source[9] = (String)max_cost.getText();
		source[10] = (String)min_cost.getText();

		new Choice(this, source);
	}

}
