package Student;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class window1 {
public static void show() {
final JFrame f=new JFrame();
f.setTitle("ABC SCHOOL OF MANAGEMENT");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JButton b1=new JButton();
b1.setBackground(new Color(100, 149, 237));
b1.setFont(new Font("Tahoma", Font.BOLD, 28));
b1.setText("STUDENT");
b1.setBounds(141, 185, 185, 78);
   f.getContentPane().add(b1);
   f.setVisible(true);
   JLabel l=new JLabel("LOGIN ");
   l.setHorizontalAlignment(SwingConstants.CENTER);
   l.setFont(new Font("Arial", Font.BOLD, 26));
   l.setBounds(10,61,449,54);
   
   f.getContentPane().add(l);
   b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    //f.setVisible(false);
    window2 w1=new window2();
    w1.show();
    }
   });
   
}

public static void main(String[] args) {
show();
}
}