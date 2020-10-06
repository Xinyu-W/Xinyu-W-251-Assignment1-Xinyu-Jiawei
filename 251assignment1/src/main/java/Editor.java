
import com.sun.jmx.mbeanserver.JmxMBeanServer;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Editor extends JFrame {
    public  JTextPane textPane = new JTextPane();
    public JFileChooser fileChooser = new JFileChooser();

    public Editor(){
        super("text editor");
        Action[] actions={
                new New(textPane,fileChooser,Editor.this),
                new Open(textPane,fileChooser,Editor.this),
                new Save(textPane,fileChooser),
                new Search()
//                new CopyAction(),new CutAction(),
//                new PasteAction()
        };
        setJMenuBar(createJMenuBar(actions));

        Container container=getContentPane();
        container.add(textPane,BorderLayout.CENTER);
        setSize(700,700);
        setVisible(true);
        }
        private JMenuBar createJMenuBar(Action[] actions){
            JMenuBar menuBar=new JMenuBar();
            JMenu menuFile=new JMenu("File");
            JMenu menuEdior=new JMenu("Editor");
            JMenu menuAbout = new JMenu("About");
            menuFile.add(new JMenuItem(actions[0]));
            menuFile.add(new JMenuItem(actions[1]));
            menuFile.add(new JMenuItem(actions[2]));
            menuBar.add(menuFile);
            menuBar.add(menuAbout);
            menuBar.add(menuEdior);
            return menuBar;
        }

    public static void main(String[] args) {
        new Editor();
    }

    }

