package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Lightning;
import odysseus.view.Panels.LvlPlay;
import odysseus.view.controller.PLLvlExitController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;

/**
 * Player's Lightning level 1
 */
/**
 * Allows player to play a lightning level.
 * @author Kevin Valente
 *
 */
public class PlayerLLvl extends JFrame implements MouseListener {

	JPanel contentPane;
	PlayerLevelL prevFrame;
	public Lightning model;
	JTextField textField;
	
	JLabel timerCount;

	/**
	 * Create the frame.
	 */
	public PlayerLLvl(Lightning m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 905);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.addMouseListener(this);
		
//		JLabel lblTimeLeft = new JLabel("Time left:");
//		lblTimeLeft.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
//		getContentPane().add(lblTimeLeft);
		
		setSize (500, 624);
		setTitle("Sample Timer");
		getContentPane().setLayout(null);
		
		JLabel lblTimeLeft = new JLabel("Timer:");
		lblTimeLeft.setBounds(36, 51, 46, 14);
		getContentPane().add(lblTimeLeft);
		
		timerCount = new JLabel("0");
		timerCount.setBounds(75, 51, 46, 14);
		getContentPane().add(timerCount);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		
		LvlPlay panel_1 = new LvlPlay(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTimeLeft)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
							.addComponent(btnExit)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTimeLeft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		btnExit.addActionListener(new PLLvlExitController(this, model));

		// sync
		refresh();
	}
	
	public JLabel getTimerLabel() {
		return timerCount;
	}

	/**
	 * Used to synchronize with model
	 */
	public void refresh() {
		if (model != null) {
			textField.setText("" + model.getValue());
		}
	}

	/**
	 * Allows anyone to see JTextField without allowing them to modify it 
	 * @return textField and all values associated with it
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Sets the JFrame used before this one. This allows the
	 * application to open up the previous JFrame when called.
	 * @param one JFrame to be set as prevFrame
	 */
	public void setPreviousFrame(PlayerLevelL one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public PlayerLevelL getPreviousFrame() {
		return prevFrame;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}