import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Simple extends JFrame implements ActionListener {
	JPanel     contentPane;
	JTextField txtValue;
	JButton    btnDown, btnUp;
	int        value = 0;
	
	public Simple() {
		setSize(300, 100);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());
		
		btnDown = new JButton("Down");
		contentPane.add(btnDown);
		
		txtValue = new JTextField("" + value, 5);
		txtValue.setEditable(false);
		contentPane.add(txtValue);
		
		btnUp = new JButton("Up");
		contentPane.add(btnUp);
		
		btnDown.addActionListener(this);
		btnUp.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDown) {
			value--;
			txtValue.setText("" + value);
		} else if (e.getSource() == btnUp) {
			value++;
			txtValue.setText("" + value);
		}		
	}

}
