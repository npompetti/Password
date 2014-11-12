package password_box;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;

import password_box.password_engine.*;

public class password_gui {
	
	String password;

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					password_gui window = new password_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public password_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel pwrd_lbl = new JLabel("Enter Password");
		pwrd_lbl.setBounds(6, 46, 104, 16);
		frame.getContentPane().add(pwrd_lbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 40, 148, 28);
		frame.getContentPane().add(passwordField);
		
		JButton ok_btn = new JButton("Okay");
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = false;
				char[] pw = passwordField.getPassword();
				System.out.println(pw);
				
				check = password_engine.checkpassword(pw);
				
				if(check == true){
					JOptionPane.showMessageDialog(frame, "That Is The Correct Password!"
							, "Congratulations", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Try Again", "Error", JOptionPane.ERROR_MESSAGE, null);
					passwordField.setText("");
				}
				
			
				
			}
		});
		ok_btn.setBounds(156, 74, 65, 29);
		frame.getContentPane().add(ok_btn);
		
		JButton help_btn = new JButton("Help");
		help_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "You can get the password by searching this example's source code for the string correctPassword\n"
						+ " Or look at the section How to Use Password Fields in the components section of The Java\n"
						+ " Tutorial.");
			}
		});
		help_btn.setBounds(233, 74, 65, 29);
		frame.getContentPane().add(help_btn);
	}
}
