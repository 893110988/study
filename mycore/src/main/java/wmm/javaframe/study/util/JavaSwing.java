package wmm.javaframe.study.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by wangmm on 2017/2/8.
 */
public class JavaSwing extends JFrame implements ActionListener {
    public static JTextField jTextField;
    public static JTextField jTextField2;

    public String pathExcel;

    public JavaSwing(){
        setTitle("繁到简");
        setLookAndFeel();
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout();

        setLayout(flowLayout);
        JButton open=new JButton("点击选择要转换的文件");
        this.add(open);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(new FileChooser());
        jTextField = new JTextField(10);
        JLabel jLabel1 = new JLabel("原路径" , JLabel.RIGHT);
        add(jLabel1);
        add(jTextField);

        jTextField2 = new JTextField(10);
        JLabel jLabel2 = new JLabel("输出路径" , JLabel.RIGHT);
        add(jLabel2);
        add(jTextField2);
        JButton button1 = new JButton("开始");
        add(button1);
        button1.addActionListener(this);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent actionEvent){
        try {
                ExcelUtils.readAndWrite(jTextField.getText(), jTextField2.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel("som.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        JavaSwing application1 = new JavaSwing();
    }
}

