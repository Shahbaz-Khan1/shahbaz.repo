package com.imageOperation;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImageEncrypt {
   
	public static void operate(int key) {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		fileChooser.getSelectedFile();
		File file = fileChooser.getSelectedFile();
		// file input stream reader
		
		try {
			FileInputStream fis = new FileInputStream( file) ;
			byte []data = new byte[fis.available()];
			
			fis.read(data);
			int i = 0 ;
			for(byte b:data) {
				System.out.println(b);
				data[i] =  (byte) (b^key) ;
				i++ ;
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		
		catch(Exception e) {
			
			
		}
	
	}
	public static void main(String[] args) {
		
	JFrame f =new JFrame();
	f.setTitle("Image Operation");
	f.setSize(400,400);
	// for locate in centre ;
	f.setLocationRelativeTo(null);
	// for easily close the window 
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// for run test the window
	f.setVisible(true);
	
	Font font = new Font("Roboto",Font.BOLD,25);
	//creating button 
	
	JButton button = new JButton();
	button.setText("Open Image");
	button.setFont(font);
	// for call the function
	
	
	//creating textField
	JTextField textField = new JTextField();
	textField.setFont(font);
	button.addActionListener(e->{
		System.out.println("Button clicked");
		String text = textField.getText();
		int temp = Integer.parseInt(text);
		operate(temp);
	});
	
	f.setLayout(new FlowLayout());
	f.add(button);
	f.add(textField);
	}

}
