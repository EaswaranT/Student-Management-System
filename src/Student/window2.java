package Student;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
public class window2 {
private JTextField textField;
private JTextField textField_1;

public void show() {
final JFrame f=new JFrame();
f.setTitle("ABC SCHOOL OF MANAGEMENT");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);

JLabel lblNewLabel = new JLabel("LOGIN ID:");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
lblNewLabel.setBounds(31, 92, 171, 58);
f.getContentPane().add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
lblNewLabel_1.setBounds(10, 228, 160, 46);
f.getContentPane().add(lblNewLabel_1);
final JButton btnNewButton = new JButton("OK");
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton.setBounds(197, 364, 131, 33);
   f.setVisible(true);
    f.getContentPane().add(btnNewButton);
    btnNewButton.setEnabled(false);
   
textField = new JTextField();
textField.setBounds(212, 118, 96, 19);
f.getContentPane().add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(212, 248, 96, 19);
f.getContentPane().add(textField_1);
textField_1.setColumns(10);
JButton btnNewButton_1 = new JButton("BACK");
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton_1.setBounds(10, 22, 124, 46);
f.getContentPane().add(btnNewButton_1);
textField_1.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased(KeyEvent e) {
if(textField_1.getText().contentEquals("abc@123")) {
btnNewButton.setEnabled(true);
}
}
});
    btnNewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    f.setVisible(false);
    window3 w1=new window3();
    w1.show1();
    }
   });
    btnNewButton_1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    f.setVisible(false);
    window1.show();
    }
   });
}
public static void main(String args[]) {
	window2 q=new window2();
	q.show();
}
}
