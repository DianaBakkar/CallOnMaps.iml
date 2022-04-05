import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;


public class GUI extends Fns implements ActionListener {
    //Buttons,Labels and Textfields
    static JButton Word_Swap=new JButton("Word Swap");
    static JButton Line_Swap=new JButton("Line Swap");
    static JTextField L1LS=new JTextField(15);
    static JTextField L2LS=new JTextField(15);
    static JTextField L1WS=new JTextField(15);
    static JTextField L2WS=new JTextField(15);
    static JTextField W1=new JTextField(15);
    static JTextField W2=new JTextField(15);
    static JFileChooser chooser=new JFileChooser();
    static String myPath;


    public GUI(JPanel panel,JFrame frame,GridBagConstraints gbc){
        //panel and frame config
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridBagLayout());
        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("File Processing Application");
        frame.pack();
        frame.setVisible(true);

    }




    public static void main(String[] args) {

        GridBagConstraints gbc=new GridBagConstraints();
        JPanel panel=new JPanel();
        JFrame frame=new JFrame();
        GUI gui=new GUI(panel,frame,gbc);



        gui.addLabel("Line Swap:", panel,20,2,2,2,gbc,0,1 );



        gui.addLabel("Line 1", panel,20,0,1,1,gbc,0,2 );
        gui.addTextField( panel,20,0,1,1,gbc,1,2, gui.L1LS );

        gui.addLabel("Line 2", panel,20,0,1,1,gbc,0,3 );
        gui.addTextField( panel,20,0,1,1,gbc,1,3, gui.L2LS );

        gui.addButton( panel,40,4,1,1,gbc,1,4, gui.Line_Swap);

        gui.addLabel("Word Swap:", panel,20,2,2,2,gbc,0,5 );

        gui.addLabel("Line 1", panel,20,0,1,1,gbc,0,6 );
        gui.addTextField(panel,20,0,1,5,gbc,1,6 , gui.L1WS);

        gui.addLabel("Word 1", panel,20,0,1,20,gbc,2,6 );
        gui.addTextField(panel,20,0,1,1,gbc,3,6, gui.L2WS );


        gui.addLabel("Line 2", panel,20,0,1,1,gbc,0,7 );
        gui.addTextField( panel,20,0,1,1,gbc,1,7, gui.W1 );

        gui.addLabel("Word 2", panel,20,0,1,20,gbc,2,7 );
        gui.addTextField( panel,20,0,1,1,gbc,3,7 ,gui.W2);

        gui.addButton( panel,40,4,1,1,gbc,1,8, gui.Word_Swap);



        Line_Swap.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Fns fns =new Fns();

                        JFileChooser fileChooser=new JFileChooser();
                        int response=fileChooser.showOpenDialog(null);
                        if(response==JFileChooser.APPROVE_OPTION){
                           myPath=fileChooser.getSelectedFile().getAbsolutePath();
                        }
                        try{

                            HashMap<Integer,String[]> map= fns.Separator(myPath);
                            int i=Integer.parseInt(L1LS.getText());
                            int j=Integer.parseInt(L2LS.getText());
                            HashMap<Integer,String[]> map1=fns.lineChanger(i,j,map);
                            fns.fileChanger(map1,myPath);
                        }
                        catch(IOException exception){
                            System.out.println(exception.getMessage());

                        }
                        
                    }
                }
        );

        Word_Swap.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent k) {
                        Fns fns1 = new Fns();
                        JFileChooser fileChooser1 = new JFileChooser();
                        int response = fileChooser1.showOpenDialog(null);
                        if (response == fileChooser1.APPROVE_OPTION) {
                            myPath = fileChooser1.getSelectedFile().getAbsolutePath();
                            try {
                                HashMap<Integer,String[]> map= fns1.Separator(myPath);
                                int i=Integer.parseInt(L1WS.getText());
                                int j=Integer.parseInt(L2WS.getText());
                                int g=Integer.parseInt(W1.getText());
                                int f=Integer.parseInt(W2.getText());
                                HashMap<Integer,String[]> map1= fns1.wordChanger(i,j,g,f,map);
                                fns1.fileChanger(map1,myPath);



                            } catch (IOException exception1) {

                                System.out.println(exception1.getMessage());

                            }
                        }
                    }
                }
        );





    }

    //Methods for coordinates setup, and jpannel configuration
    private void addButton(  JPanel panel, int top, int left,int bottom,int right,GridBagConstraints gbc,int x,int y,JButton button) {
        Insets i = new Insets(top, left, bottom, right);
        gbc.insets = i;
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(button, gbc);
    }
    private void addLabel( String name, JPanel panel, int top, int left,int bottom,int right,GridBagConstraints gbc,int x,int y) {
        Insets i = new Insets(top, left, bottom, right);
        gbc.insets = i;
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(new JLabel(name) , gbc);
    }
    private void addTextField(  JPanel panel, int top, int left,int bottom,int right,GridBagConstraints gbc,int x,int y,JTextField textField) {
        Insets i = new Insets(top, left, bottom, right);
        gbc.insets = i;
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(textField, gbc);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
