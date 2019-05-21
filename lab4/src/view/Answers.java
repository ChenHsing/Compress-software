package view;


import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import function.Compress;
import function.Decompress;
import function.HuffmNode;
import function.LZWCompression;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Answers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Answers frame = new Answers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Answers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("�ļ�·��");
		Label1.setBounds(28, 26, 72, 18);
		contentPane.add(Label1);
		
		JButton Button1 = new JButton("���");
		Button1.setBounds(295, 22, 72, 27);
		contentPane.add(Button1);
		
		textField = new JTextField();
		textField.setBounds(97, 23, 184, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel Label2 = new JLabel("ѹ���㷨");
		Label2.setBounds(65, 134, 72, 18);
		contentPane.add(Label2);
		
		final JRadioButton RadioButton1 = new JRadioButton("lzw�㷨");
		RadioButton1.setBounds(175, 130, 157, 27);
		contentPane.add(RadioButton1);
		
		final JRadioButton RadioButton2 = new JRadioButton("�������㷨");
		RadioButton2.setBounds(175, 178, 157, 27);
		contentPane.add(RadioButton2);
		
		if(RadioButton1.isSelected()) {
			RadioButton1.setSelected(true);
			RadioButton2.setSelected(false);
		}
		else {
			RadioButton1.setSelected(false);
			RadioButton2.setSelected(true);
		}
		
		RadioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadioButton1.setSelected(true);
				RadioButton2.setSelected(false);

			}
		});
		
		RadioButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadioButton2.setSelected(true);
				RadioButton1.setSelected(false);

			}
		});
		
		
	    JButton Button2 = new JButton("ѹ��");
		Button2.setBounds(65, 228, 113, 27);
		contentPane.add(Button2);
		
		JButton Button3 = new JButton("��ѹ");
		Button3.setBounds(245, 228, 113, 27);
		contentPane.add(Button3);
		
		JLabel Label3 = new JLabel("ѹ��·��");
		Label3.setBounds(28, 57, 72, 18);
		contentPane.add(Label3);
		
		textField2 = new JTextField();
		textField2.setBounds(97, 54, 184, 24);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton Button4 = new JButton("���");
		Button4.setBounds(295, 53, 72, 27);
		contentPane.add(Button4);
		
		JLabel lblNewLabel = new JLabel("��ѹ·��");
		lblNewLabel.setBounds(28, 88, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField3 = new JTextField();
		textField3.setBounds(97, 88, 184, 24);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton Button5 = new JButton("���");
		Button5.setBounds(295, 84, 72, 27);
		contentPane.add(Button5);
		
		Button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();          //����ѡ����
				chooser.setMultiSelectionEnabled(true);             //��Ϊ��ѡ
				int returnVal = chooser.showOpenDialog(new Button());        //�Ƿ���ļ�ѡ���
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //��������ļ�����
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //��ȡ����·��
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//������·��
					textField2.setText(filepath);
				}
			}
		});
	
		
		Button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();             //����ѡ����
				chooser.setMultiSelectionEnabled(true);             //��Ϊ��ѡ
				int returnVal = chooser.showOpenDialog(new Button());        //�Ƿ���ļ�ѡ���
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //��������ļ�����
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //��ȡ����·��
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//������·��
					textField.setText(filepath);
				}
			}
		});
		
		Button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();             //����ѡ����
				chooser.setMultiSelectionEnabled(true);             //��Ϊ��ѡ
				int returnVal = chooser.showOpenDialog(new Button());        //�Ƿ���ļ�ѡ���
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //��������ļ�����
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //��ȡ����·��
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//������·��
					textField3.setText(filepath);
				}
			}
		});
		
		
		//ѹ����ť�ļ�����ʵ��
		Button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(RadioButton2.isSelected()&& !textField.getText().equals("")) {
					//����ѹ������
					Compress compress = new Compress();
					//ͳ���ļ���0-255���ֵĴ���
					try {
						compress.countTimes(textField.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//����������������õ����ڵ�
					HuffmNode root=compress.createTree();
					//�õ�����������
					compress.getHuffmCode(root, "");
					//ѹ���ļ�
					try {
						compress.compress(textField.getText(),
								textField2.getText());
						File file1 = new File(textField.getText());
						File file2 = new File(textField2.getText());
						double num = (double)file2.length()/(double)file1.length();
						
						DecimalFormat df = new DecimalFormat("0.000%");
						String r = df.format(num);
						JOptionPane.showMessageDialog(contentPane, "ѹ���ɹ���ѹ����Ϊ"+r, "�ɹ���ʾ", 1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "ѹ��ʧ�ܣ����ļ���ʽ��֧��ѹ����", "ʧ����ʾ", 1);
						e1.printStackTrace();
					}
					
				}else if(RadioButton1.isSelected()&&!textField.getText().equals("")&&!textField2.getText().equals("")){
					LZWCompression lzw = new LZWCompression();
					String input = textField.getText();
					String output = textField2.getText();
					try {
						lzw.LZW_Compress(input,output);
						File file1 = new File(textField.getText());
						File file2 = new File(textField2.getText());
						double num =(double) file2.length()/(double)file1.length();
						DecimalFormat df = new DecimalFormat("0.000%");
						String r = df.format(num);
					
						JOptionPane.showMessageDialog(contentPane, "ѹ���ɹ���ѹ����Ϊ"+r, "�ɹ���ʾ", 1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "ѹ��ʧ�ܣ����ļ���ʽ��֧��ѹ����", "ʧ����ʾ", 1);
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		Button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(RadioButton2.isSelected()&& !textField.getText().equals("")&& !textField2.getText().equals("")){
					Decompress d = new Decompress();
					d.decompress(textField2.getText(),
							textField3.getText());
					JOptionPane.showMessageDialog(contentPane, "��ѹ���ɹ���", "�ɹ���ʾ", 1);
				}
				else if(RadioButton1.isSelected()&& !textField.getText().equals("")&& !textField2.getText().equals("")){
					LZWCompression lzw = new LZWCompression();
					String input = textField2.getText();
					String output = textField3.getText();
					try {
						lzw.LZW_Decompress(input, output);
						JOptionPane.showMessageDialog(contentPane, "��ѹ���ɹ���", "�ɹ���ʾ", 1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "��ѹ��ʧ�ܣ�", "ʧ����ʾ", 1);
					}
				}
			}
		});
		
		
		
		
	}
}
