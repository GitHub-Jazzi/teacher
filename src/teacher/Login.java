package teacher;

import java.awt.event.*;//ActionListener与addActionListener方法可见。
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import java.awt.*;

class Login extends JFrame{
	
	public String user="123";
	public String userpass="456";
	
	public Login() {
		Container c=getContentPane();
		
		JPanel j1=new JPanel(new GridLayout(5,1));
		JPanel j11=new JPanel(new GridLayout(1,1));
		JPanel j12=new JPanel(new GridLayout(1,1));
		JPanel j13=new JPanel(new GridLayout(1,2));
		
		j1.add(new JPanel());
		j1.add(j11);
		j1.add(j12);
		j1.add(j13);
		j1.add(new JPanel());
		
		c.add(j1);
		
		
		j11.add(new JLabel("账号："));
		JTextField jt1=new JTextField("请输入您的登录账号!",20);
		j11.add(jt1);
		j11.setLayout(new FlowLayout(1));
		JPasswordField jp1=new JPasswordField("",20);
		j12.add(new JLabel("密码："));
		j12.add(jp1);
		j12.setLayout(new FlowLayout(1));
		
		//登录：
		JButton jb1=new JButton("登录");
		j13.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				user=jt1.getText();
				//将char[]转String
				userpass=String.valueOf(jp1.getPassword());
				Conn c=new Conn();
				Connection con=c.create(user,userpass);
				try {
					Statement sql =con.createStatement();
					JOptionPane.showMessageDialog(null, "获得数据操作权限!");
					new save(sql,con);
					new delete(sql,con);
					new change2(sql,con);
					
				}
				catch(SQLException e2) {
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "获取权限失败!");
				}
			}
		});
		//重置
		JButton jb2=new JButton("重置");
		j13.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jp1.setText("");
			}
		});
		j13.setLayout(new FlowLayout(1));
		
		setTitle("欢迎来到教室管理系统!");
		setSize(700,400); 
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String []agv) {
		
		new Login();
			
	}
}
