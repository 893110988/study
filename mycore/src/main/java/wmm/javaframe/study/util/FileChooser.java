package wmm.javaframe.study.util;

/**
 * Created by wangmm on 2017/2/10.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileChooser extends JFrame implements ActionListener{
    /*JButton open=null;
    public static void main(String[] args) {
        new FileChooser();
    }
    public FileChooser(){
        open=new JButton("open");
        this.add(open);
        this.setBounds(400, 200, 100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(this);
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        if(file.isDirectory()){
            System.out.println("文件夹:"+file.getAbsolutePath());
        }else if(file.isFile()){
            System.out.println("文件:"+file.getAbsolutePath());
            JavaSwing.jTextField.setText(file.getAbsolutePath());
            String newPath=file.getAbsolutePath();
            newPath=newPath.replaceAll(jfc.getSelectedFile().getName(),"-"+jfc.getSelectedFile().getName());
            JavaSwing.jTextField2.setText(newPath);
        }
        System.out.println(jfc.getSelectedFile().getName());

    }

}
