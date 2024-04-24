
package Student;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
public class window3 {
private JTextField textField;
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/project";
static final String USER = "root";
static final String PASS = "Vaithi@20";
Connection conn =null ;
Statement stmt=null ;
private JTextField total1;
public void show1() {
final JFrame f=new JFrame();
f.setTitle("ABC SCHOOL OF MANAGEMENT");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setVisible(true);
f.setSize(1000,1000);
f.getContentPane().setLayout(null);
JButton btnNewButton_5 = new JButton("HOME");
btnNewButton_5.setBounds(63, 54, 143, 54);
btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 17));
f.getContentPane().add(btnNewButton_5);
JLabel lblNewLabel = new JLabel("Enter Your Roll Number : ");
lblNewLabel.setBounds(97, 167, 266, 42);
lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
f.getContentPane().add(lblNewLabel);
textField = new JTextField();
textField.setBounds(421, 171, 249, 42);
f.getContentPane().add(textField);
textField.setColumns(10);
JButton btnNewButton = new JButton("OK");
btnNewButton.setBounds(302, 280, 149, 47);
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
f.getContentPane().add(btnNewButton);
final JLabel roll = new JLabel("ROLL NUMBER  :");
roll.setForeground(new Color(0, 0, 0));
roll.setBackground(new Color(255, 0, 255));
roll.setBounds(97, 378, 206, 36);
roll.setFont(new Font("Arial Black", Font.PLAIN, 18));
roll.setHorizontalAlignment(SwingConstants.CENTER);
f.getContentPane().add(roll);
final JLabel na = new JLabel("NAME : ");
na.setBounds(90, 432, 206, 36);
na.setHorizontalAlignment(SwingConstants.CENTER);
na.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(na);
final JLabel phy = new JLabel("PHYSISCS : ");
phy.setBounds(133, 526, 206, 36);
phy.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(phy);
final JLabel chem = new JLabel("CHEMISTRY : ");
chem.setBounds(119, 572, 206, 36);
chem.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(chem);
final JLabel comp = new JLabel("COMPUTER SCIENCE : ");
comp.setBounds(90, 618, 235, 36);
comp.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(comp);
final JLabel maths = new JLabel("MATHS : ");
maths.setBounds(145, 664, 169, 36);
maths.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(maths);
final JLabel eng = new JLabel("ENGLISH : ");
eng.setBounds(134, 710, 169, 41);
eng.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(eng);
final JLabel physiscs = new JLabel();
physiscs.setFont(new Font("Tahoma", Font.BOLD, 16));
physiscs.setBounds(421, 534, 121, 28);
f.getContentPane().add(physiscs);
final JLabel chemi = new JLabel();
chemi.setFont(new Font("Tahoma", Font.BOLD, 16));
chemi.setBounds(421, 572, 121, 21);
f.getContentPane().add(chemi);
final JLabel csc = new JLabel();
csc.setFont(new Font("Tahoma", Font.BOLD, 16));
csc.setBounds(421, 626, 121, 28);
f.getContentPane().add(csc);
final JLabel math = new JLabel();
math.setFont(new Font("Tahoma", Font.BOLD, 16));
math.setBounds(421, 664, 121, 28);
f.getContentPane().add(math);
final JLabel engl = new JLabel();
engl.setFont(new Font("Tahoma", Font.BOLD, 16));
engl.setBounds(421, 710, 121, 30);
f.getContentPane().add(engl);
final JLabel rollno = new JLabel();
rollno.setBackground(new Color(135, 206, 250));
rollno.setFont(new Font("Tahoma", Font.BOLD, 16));
rollno.setBounds(385, 386, 188, 28);
f.getContentPane().add(rollno);
final JLabel name = new JLabel();
name.setBackground(new Color(30, 144, 255));
name.setFont(new Font("Tahoma", Font.BOLD, 16));
name.setBounds(385, 440, 242, 28);
f.getContentPane().add(name);
JLabel tot = new JLabel("TOTAL : ");
tot.setBounds(608, 529, 94, 36);
tot.setFont(new Font("Arial Black", Font.PLAIN, 18));
f.getContentPane().add(tot);
total1 = new JTextField();
total1.setFont(new Font("Tahoma", Font.BOLD, 16));
total1.setBounds(746, 530, 96, 36);
f.getContentPane().add(total1);
total1.setColumns(10);
textField.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent e) {
		if(textField.getText().length()==0) {
			rollno.setText("");
			name.setText("");
			physiscs.setText("");
			chemi.setText("");
			math.setText("");
			csc.setText("");
			engl.setText("");
			total1.setText("");
		}
	}
});
roll.setVisible(false);
na.setVisible(false);
phy.setVisible(false);
chem.setVisible(false);
maths.setVisible(false);
comp.setVisible(false);
eng.setVisible(false);
rollno.setVisible(false);
name.setVisible(false);
physiscs.setVisible(false);
chemi.setVisible(false);
csc.setVisible(false);
math.setVisible(false);
engl.setVisible(false);
total1.setVisible(false);
btnNewButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
	try {
		int ro =Integer.valueOf(textField.getText());
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,"root","Vaithi@20");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT roll,name,physics,chemistry,maths,computerscience,english from stud where roll= ' " + ro + "' ";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int r = rs.getInt("roll");
		String n = rs.getString("name");
		int p = rs.getInt("physics");
		int c = rs.getInt("chemistry");
		int m = rs.getInt("maths");
		int cs = rs.getInt("computerscience");
		int en = rs.getInt("english");
		rollno.setText(String.valueOf(r));
		name.setText((n));
		physiscs.setText(String.valueOf(p));
		chemi.setText(String.valueOf(c));
		math.setText(String.valueOf(m));
		csc.setText(String.valueOf(cs));
		engl.setText(String.valueOf(en));
		int t=p+c+m+cs+en;
		total1.setText(String.valueOf(t));
		rs.close();
		stmt.close();
		conn.close();
	}catch(SQLException se){
		System.out.print(se);
	}catch(Exception exc) {	
	}
	roll.setVisible(true);
	na.setVisible(true);
	phy.setVisible(true);
	chem.setVisible(true);
	maths.setVisible(true);
	comp.setVisible(true);
	eng.setVisible(true);
	rollno.setVisible(true);
	name.setVisible(true);
	physiscs.setVisible(true);
	chemi.setVisible(true);
	csc.setVisible(true);
	math.setVisible(true);
	engl.setVisible(true);
	total1.setVisible(true);
}
});	
btnNewButton_5.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
	f.setVisible(false);
	window2 w3=new window2();
	w3.show();
}
});
}
public static void main(String args[]) {
window3 r=new window3();
r.show1();
}
}