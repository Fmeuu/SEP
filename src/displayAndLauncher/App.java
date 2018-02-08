package displayAndLauncher;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import appCore.Afficheur;
import appCore.Canal;
import appCore.CapteurImpl;
import strategy.AlgoStrategies;
import strategy.Atomic;
import strategy.Epoque;
import strategy.Sequential;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
public class App extends JFrame implements ItemListener{

	/** The content pane. */
	private JPanel contentPane;

	/** The algo. */
	private AlgoStrategies currentAlgo;

	/** The capt impl. */
	private CapteurImpl captImpl;

	/** The c 1. */
	private Canal c1;

	/** The c 2. */
	private Canal c2;

	/** The c 3. */
	private Canal c3;

	/** The c 4. */
	private Canal c4;

	/** The algo change. */
	private boolean algoHasChanged;


	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		App app = new App();
		app.init(new Atomic());
		app.execute();
	}


	/**
	 * Execute.
	 */
	public void execute() {
		while (true) {
			if(algoHasChanged){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.init(currentAlgo);
				algoHasChanged = false;
			}
			captImpl.tick();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * Create the frame.
	 *
	 * @param algo the algo
	 */
	public void init(AlgoStrategies algo) {
		this.setTitle("Projet SEP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();

		//ATOMIC Button
		JRadioButton atomic_button = new JRadioButton("Atomic");
		atomic_button.setBounds(24, 227, 103, 23);
		contentPane.add(atomic_button);
		atomic_button.setActionCommand("atomic");
		atomic_button.setMnemonic(KeyEvent.VK_1);
		atomic_button.setSelected(true);
		

		//SEQUENTIAL Button
		JRadioButton sequential_button = new JRadioButton("Sequential");
		sequential_button.setBounds(168, 227, 109, 23);
		contentPane.add(sequential_button);
		sequential_button.setActionCommand("sequential");
		sequential_button.setMnemonic(KeyEvent.VK_2);

		//EPOQUE Button
		JRadioButton epoque_button = new JRadioButton("Epoque");
		epoque_button.setBounds(310, 227, 101, 23);
		contentPane.add(epoque_button);
		epoque_button.setActionCommand("epoque");
		epoque_button.setMnemonic(KeyEvent.VK_3);

		group.add(atomic_button);
		group.add(sequential_button);
		group.add(epoque_button);
		atomic_button.addItemListener(this);
		sequential_button.addItemListener(this);
		epoque_button.addItemListener(this);

		
		Afficheur a2 = new Afficheur("0");
		a2.setForeground(Color.RED);
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setBounds(141, 98, 46, 14);
		contentPane.add(a2);

		JLabel label = new JLabel("");
		label.setBounds(305, 21, 0, 0);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(310, 21, 0, 0);
		contentPane.add(label_1);

		Afficheur a3 = new Afficheur("0");
		a3.setForeground(Color.RED);
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setBounds(240, 98, 46, 14);
		contentPane.add(a3);

		Afficheur a4 = new Afficheur("0");
		a4.setForeground(Color.RED);
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setBounds(337, 98, 46, 14);
		contentPane.add(a4);

		Afficheur a1 = new Afficheur("0");
		a1.setForeground(Color.RED);
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setBounds(44, 98, 46, 14);
		contentPane.add(a1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(240, 45, 0, 0);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(245, 45, 0, 0);
		contentPane.add(label_3);

		JLabel display1 = new JLabel("Display 1");
		display1.setHorizontalAlignment(SwingConstants.CENTER);
		display1.setBounds(24, 65, 88, 14);
		contentPane.add(display1);

		JLabel display2 = new JLabel("Display 2");
		display2.setHorizontalAlignment(SwingConstants.CENTER);
		display2.setBounds(122, 65, 82, 14);
		contentPane.add(display2);

		JLabel display3 = new JLabel("Display 3");
		display3.setHorizontalAlignment(SwingConstants.CENTER);
		display3.setBounds(214, 65, 91, 14);
		contentPane.add(display3);

		JLabel display4 = new JLabel("Display 4");
		display4.setHorizontalAlignment(SwingConstants.CENTER);
		display4.setBounds(310, 65, 88, 14);
		contentPane.add(display4);

		if (algo instanceof Atomic){
			atomic_button.setSelected(true);
		}
		else if (algo instanceof Sequential){
			sequential_button.setSelected(true);
		}
		else if (algo instanceof Epoque){
			epoque_button.setSelected(true);
		}

		captImpl = new CapteurImpl();

		c1 = new Canal(captImpl, a1);
		c2 = new Canal(captImpl, a2);
		c3 = new Canal(captImpl, a3);
		c4 = new Canal(captImpl, a4);

		algo.setCapteur(captImpl);
		algo.addCanal(c1);
		algo.addCanal(c2);
		algo.addCanal(c3);
		algo.addCanal(c4);
		algo.configure(4);

		captImpl.setStrategies(algo);

		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * Item state changed.
	 *
	 * @param e the e
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			algoHasChanged = true;
		}
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (((JRadioButton) e.getItem()).getActionCommand().equals(
					"atomic")) {
				this.currentAlgo = new Atomic();
			}

			if (((JRadioButton) e.getItem()).getActionCommand().equals(
					"sequential")) {
				this.currentAlgo = new Sequential();
			}

			if (((JRadioButton) e.getItem()).getActionCommand()
					.equals("epoque")) {
				this.currentAlgo = new Epoque();
			}
		}
	}
}
