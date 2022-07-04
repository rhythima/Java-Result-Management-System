import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DB
{
Frame f;
TextField t1,t2,t3;
Button b1;
DB()
{
f=new Frame("My JDBC Code");
t1=new TextField();
t2=new TextField();
t3=new TextField();
b1=new Button("Save");
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
try
{
int rno=Integer.parseInt(t1.getText());
String name=t2.getText();
float marks=Float.parseFloat(t3.getText());

//load driver
Class.forName("com.mysql.cj.jdbc.Driver");
//establish connection
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/bca_4th?user=root&password=rhythima@1234");
//prepare query
String query="insert into students values(?,?,?)";
PreparedStatement st=cn.prepareStatement(query);
st.setInt(1,rno);
st.setString(2,name);
st.setFloat(3,marks);
//execute query
st.executeUpdate();
//close connection
cn.close();
javax.swing.JOptionPane.showMessageDialog(null,"Data Saved");
}
catch(Exception e1)
{
javax.swing.JOptionPane.showMessageDialog(null,e1.getMessage());
}
}
});
f.setLayout(new GridLayout(4,1));
f.add(t1);
f.add(t2);
f.add(t3);
f.add(b1);
f.setSize(400,400);
f.setVisible(true);
}
public static void main(String ar[])
{
DB d1=new DB();
}
}
