import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.*;

public class CludeApp {
    private JPanel Main;
    private JTextField pname;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton productIDButton;
    private JTextField textName;
    private JTextField textPrice;
    private JTextField textQty;
    private JTextField textPid;

    public static void main(String[] args) {
        JFrame frame = new JFrame("CludeApp");
        frame.setContentPane(new CludeApp().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    Connection con;
    PreparedStatement pst;

    public CludeApp() {
        connect();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name,Price,Qty;
                Name = textName.getText();
                Price =textPrice.getText();
                Qty = textQty.getText();
                try
                {
                    pst =con.prepareStatement("insert into products(pname,Price,Qty)values(?,?,?)");
                    pst.setString(1, Name);
                    pst.setString(2,Price);
                    pst.setString(3,Qty);
                    pst.executeUpdate();
                    textName.setText("");
                    textPrice.setText("");
                    textQty.setText("");
                    textName.requestFocus();


                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });
    }

    private void table_load() {

    }


    public void connect()
    {
        try
        {
            Class.forName("`com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/electronics products","root","");
            System.out.println("success");

        }
        catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}



