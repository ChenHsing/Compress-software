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
		
		JLabel Label1 = new JLabel("文件路径");
		Label1.setBounds(28, 26, 72, 18);
		contentPane.add(Label1);
		
		JButton Button1 = new JButton("浏览");
		Button1.setBounds(295, 22, 72, 27);
		contentPane.add(Button1);
		
		textField = new JTextField();
		textField.setBounds(97, 23, 184, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel Label2 = new JLabel("压缩算法");
		Label2.setBounds(65, 134, 72, 18);
		contentPane.add(Label2);
		
		final JRadioButton RadioButton1 = new JRadioButton("lzw算法");
		RadioButton1.setBounds(175, 130, 157, 27);
		contentPane.add(RadioButton1);
		
		final JRadioButton RadioButton2 = new JRadioButton("哈夫曼算法");
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
		
		
	    JButton Button2 = new JButton("压缩");
		Button2.setBounds(65, 228, 113, 27);
		contentPane.add(Button2);
		
		JButton Button3 = new JButton("解压");
		Button3.setBounds(245, 228, 113, 27);
		contentPane.add(Button3);
		
		JLabel Label3 = new JLabel("压缩路径");
		Label3.setBounds(28, 57, 72, 18);
		contentPane.add(Label3);
		
		textField2 = new JTextField();
		textField2.setBounds(97, 54, 184, 24);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton Button4 = new JButton("浏览");
		Button4.setBounds(295, 53, 72, 27);
		contentPane.add(Button4);
		
		JLabel lblNewLabel = new JLabel("解压路径");
		lblNewLabel.setBounds(28, 88, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField3 = new JTextField();
		textField3.setBounds(97, 88, 184, 24);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton Button5 = new JButton("浏览");
		Button5.setBounds(295, 84, 72, 27);
		contentPane.add(Button5);
		
		Button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();          //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(new Button());        //是否打开文件选择框
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//输出相对路径
					textField2.setText(filepath);
				}
			}
		});
	
		
		Button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(new Button());        //是否打开文件选择框
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//输出相对路径
					textField.setText(filepath);
				}
			}
		});
		
		Button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(new Button());        //是否打开文件选择框
				System.out.println("returnVal="+returnVal);
 
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					System.out.println(filepath);
					System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());//输出相对路径
					textField3.setText(filepath);
				}
			}
		});
		
		
		//压缩按钮的监听和实现
		Button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(RadioButton2.isSelected()&& !textField.getText().equals("")) {
					//创建压缩对象
					Compress compress = new Compress();
					//统计文件中0-255出现的次数
					try {
						compress.countTimes(textField.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//构造哈夫曼树，并得到根节点
					HuffmNode root=compress.createTree();
					//得到哈夫曼编码
					compress.getHuffmCode(root, "");
					//压缩文件
					try {
						compress.compress(textField.getText(),
								textField2.getText());
						File file1 = new File(textField.getText());
						File file2 = new File(textField2.getText());
						double num = (double)file2.length()/(double)file1.length();
						
						DecimalFormat df = new DecimalFormat("0.000%");
						String r = df.format(num);
						JOptionPane.showMessageDialog(contentPane, "压缩成功！压缩率为"+r, "成功提示", 1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "压缩失败，该文件格式不支持压缩！", "失败提示", 1);
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
					
						JOptionPane.showMessageDialog(contentPane, "压缩成功！压缩率为"+r, "成功提示", 1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "压缩失败，该文件格式不支持压缩！", "失败提示", 1);
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
					JOptionPane.showMessageDialog(contentPane, "解压缩成功！", "成功提示", 1);
				}
				else if(RadioButton1.isSelected()&& !textField.getText().equals("")&& !textField2.getText().equals("")){
					LZWCompression lzw = new LZWCompression();
					String input = textField2.getText();
					String output = textField3.getText();
					try {
						lzw.LZW_Decompress(input, output);
						JOptionPane.showMessageDialog(contentPane, "解压缩成功！", "成功提示", 1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "解压缩失败！", "失败提示", 1);
					}
				}
			}
		});
		
		
		
		
	}
}
