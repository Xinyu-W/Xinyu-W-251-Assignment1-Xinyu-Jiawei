
import com.sun.jmx.mbeanserver.JmxMBeanServer;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;


public class Editor extends JFrame {
    public  JTextPane textPane = new JTextPane();
    public JFileChooser fileChooser = new JFileChooser();
    public JTextField SearchText = new JTextField(20);
    public Editor(){

        DateFormat dateFormat=DateFormat.getDateTimeInstance();
        String dateTime=dateFormat.format(System.currentTimeMillis());
        this.setTitle("Text editor           "+dateTime);

        setJMenuBar(createJMenuBar());
        Container container=getContentPane();
        container.add(textPane,BorderLayout.CENTER);
        setSize(700,700);
        setVisible(true);
        }

        private JMenuBar createJMenuBar(){
            JMenuBar menuBar=new JMenuBar();
            JMenu menuFile=new JMenu("File");
            JMenu menuView=new JMenu("View");
            JMenu menuEdior=new JMenu("Editor");
            JMenu menuAbout = new JMenu("About");
            menuFile.add(new JMenuItem(new New(textPane,fileChooser,Editor.this)));
            menuFile.add(new JMenuItem(new Open(textPane,fileChooser,Editor.this)));
            menuFile.add(new JMenuItem(new Save(textPane,fileChooser)));
            menuView.add(new JMenuItem(new Search(textPane,SearchText)));
            menuFile.add(new JMenuItem(new Exit(Editor.this)));
            menuEdior.add(new JMenuItem(new Copy(textPane,Editor.this)));
            menuEdior.add(new JMenuItem(new Cut(textPane,Editor.this)));
            menuEdior.add(new JMenuItem(new Paste(textPane,Editor.this)));
            menuBar.add(menuFile);
            menuBar.add(menuEdior);
            menuBar.add(menuView);
            menuBar.add(menuAbout);
            return  menuBar;
        }

    public static void main(String[] args) {
        new Editor();
    }

    }

