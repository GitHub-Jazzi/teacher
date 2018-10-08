package teacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//ActionListener与addActionListener方法可见。
import java.sql.*;


class change2 extends JFrame{
	ResultSet res;
	
	public change2(Statement sql,Connection con) {
		Container c=getContentPane();
		
		JPanel j1=new JPanel(new GridLayout(2,1));
		
		JPanel j11=new JPanel(new GridLayout(1,1));
		JPanel j12=new JPanel(new GridLayout(1,1));

		
		j1.add(j11);
		j1.add(j12);

		c.add(j1);
		
		
		j11.add(new JLabel("请输入要修改的教师工号："));
		JTextField jt11=new JTextField("",20);
		j11.add(jt11);
		j11.setLayout(new FlowLayout(1));
		
		
		
		//登录：
		JButton jb1=new JButton("查询并修改");
		j12.setLayout(new FlowLayout(1));
		j12.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String str=jt11.getText();
				
				try {
					res=sql.executeQuery("select * from teacher where id="+str);
					if(!res.next()) {
						JOptionPane.showMessageDialog(null, "找不到此数据!");
					}
					else {
						change ch=new change(sql,con,str);
						change2.this.dispose();
					}
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "查询失败！");
				}
			}
		});
		
		setTitle("修改页面");
		setSize(400,200); 
		setVisible(true);
		
	}
	
}
public class change extends JFrame{
	public change(Statement sql,Connection con,String id) {
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
		JTextField jt11=new JTextField("您无法修改此数据",20);
		jt11.setEditable(false);
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
		JButton jb1=new JButton("一键修改");
		j17.setLayout(new FlowLayout(1));
		j17.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name=jt12.getText();
				String age=jt13.getText();
				String gender=jt14.getText();
				String classes=jt15.getText();
				String tell=jt16.getText();
				try {
					
					sql.executeUpdate("update teacher set name="+name+
							",age="+age+",gender="+gender+",classes="+classes+
							",tell="+tell+" where id="+id);
					
					JOptionPane.showMessageDialog(null, "修改数据库成功！");
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "修改数据库失败！");
				}
			}
		});
		
		setTitle("修改页面");
		setSize(400,400); 
		setVisible(true);
	}
}
