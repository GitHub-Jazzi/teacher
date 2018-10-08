package teacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//ActionListener与addActionListener方法可见。
import java.sql.*;


public class delete extends JFrame{
	ResultSet res;
	public delete(Statement sql,Connection con) {
		Container c=getContentPane();
		
		JPanel j1=new JPanel(new GridLayout(2,1));
		
		JPanel j11=new JPanel(new GridLayout(1,1));
		JPanel j12=new JPanel(new GridLayout(1,1));

		
		j1.add(j11);
		j1.add(j12);

		c.add(j1);
		
		
		j11.add(new JLabel("请输入要删除的教师工号："));
		JTextField jt11=new JTextField("",20);
		j11.add(jt11);
		j11.setLayout(new FlowLayout(1));
		
		
		
		//登录：
		JButton jb1=new JButton("一键删除");
		j12.setLayout(new FlowLayout(1));
		j12.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String str=jt11.getText();
				try {
					sql.executeUpdate("delete from teacher where id='"+str+"'");
					JOptionPane.showMessageDialog(null, "成功删除数据！");
				}
				catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, "删除数据失败！");
				}
			}
		});
		
		setTitle("删除页面");
		setSize(400,200); 
		setVisible(true);
	}
}

