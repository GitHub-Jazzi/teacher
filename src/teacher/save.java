package teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//ActionListener与addActionListener方法可见。
import java.sql.*;


public class save extends JFrame{
	ResultSet res;
	public save(Statement sql,Connection con) {
		Container c=getContentPane();
		
		JPanel j1=new JPanel(new GridLayout(7,1));
		
		JPanel j11=new JPanel(new GridLayout(1,1));
		JPanel j12=new JPanel(new GridLayout(1,1));
		JPanel j13=new JPanel(new GridLayout(1,1));
		JPanel j14=new JPanel(new GridLayout(1,1));
		JPanel j15=new JPanel(new GridLayout(1,1));
		JPanel j16=new JPanel(new GridLayout(1,1));
		JPanel j17=new JPanel(new GridLayout(1,1));
		
		j1.add(j11);
		j1.add(j12);
		j1.add(j13);
		j1.add(j14);
		j1.add(j15);
		j1.add(j16);
		j1.add(j17);

		c.add(j1);
		
		
		j11.add(new JLabel("教室工号："));
		JTextField jt11=new JTextField("",20);
		j11.add(jt11);
		j11.setLayout(new FlowLayout(0));
		
		j12.add(new JLabel("教师姓名："));
		JTextField jt12=new JTextField("",20);
		j12.add(jt12);
		j12.setLayout(new FlowLayout(0));
		
		j13.add(new JLabel("教师年龄："));
		JTextField jt13=new JTextField("",20);
		j13.add(jt13);
		j13.setLayout(new FlowLayout(0));
		
		j14.add(new JLabel("教师性别："));
		JTextField jt14=new JTextField("",20);
		j14.add(jt14);
		j14.setLayout(new FlowLayout(0));
		
		j15.add(new JLabel("所授课程："));
		JTextField jt15=new JTextField("",20);
		j15.add(jt15);
		j15.setLayout(new FlowLayout(0));
		
		j16.add(new JLabel("联系方式："));
		JTextField jt16=new JTextField("",20);
		j16.add(jt16);
		j16.setLayout(new FlowLayout(0));
		
		
		//登录：
		JButton jb1=new JButton("一键录入");
		j17.setLayout(new FlowLayout(1));
		j17.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id=jt11.getText();
				String name=jt12.getText();
				String age=jt13.getText();
				String gender=jt14.getText();
				String classes=jt15.getText();
				String tell=jt16.getText();

				try {
					sql.executeUpdate("insert teacher(id,name,age,"
							+ "gender,classes,tell)values( '"
							+id+"','"+name+"','"+age+"','"+gender+"','"+classes+"','"+tell+
							"')");
					JOptionPane.showMessageDialog(null, "录入数据库成功！");
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "插入数据库失败！");
				}
			}
		});
		
		setTitle("录入页面");
		setSize(400,400); 
		setVisible(true);
	}
}
