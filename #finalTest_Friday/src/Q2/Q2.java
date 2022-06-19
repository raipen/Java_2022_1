package Q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Q2 extends JFrame implements ActionListener, Runnable
{
    // implement your code.
    public static HashMap<Integer, String> studName;
    public static HashMap<Integer, Color> studColor;
    public static JPanel seat;
    private JButton startBtn;

    public static void main(String[] args)
    {
        // implement your code.
        Q2 attendance = new Q2();
        attendance.setVisible(true);
    }

    public Q2()
    {
        super("Attendence");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try
        {
            Scanner f = new Scanner(new FileInputStream("./Q2_data.txt"));

            studName = new HashMap<>();
            studColor = new HashMap<>();

            String name, color;
            int seat;
            Color theColor;

            while (f.hasNextLine())
            {
                name = f.next();
                color = f.next();
                seat = f.nextInt();

                switch (color)
                {
                    case "red":
                        theColor = Color.RED;
                        break;
                    case "blue":
                        theColor = Color.BLUE;
                        break;
                    case "green":
                        theColor = Color.GREEN;
                        break;
                    default:
                        theColor = Color.BLACK;
                }

                studName.put(seat, name);
                studColor.put(seat, theColor);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);
        JLabel welcome = new JLabel("Welcome to Java Programming class!");
        top.add(welcome);
        add(top, BorderLayout.NORTH);

        seat = new JPanel();
        seat.setLayout(new GridLayout(1, 10));

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.WHITE);
        startBtn = new JButton("Let's start!");
        startBtn.addActionListener(this);
        bottom.add(startBtn);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        for (int i = 0; i < 10; i++)
        {
            g.setColor(Color.BLACK);
            g.drawString(studName.get(i), 10 + (79 * i), 69);
            g.setColor(studColor.get(i));
            g.fillRect(5 + (79 * i), 70, 79, 79);

        }
    }

    public void run()
    {
        repaint();
        try
        {
            Thread.sleep(100);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == startBtn)
        {
            runnn();
        }
    }

    public void runnn()
    {
        thr[] t = new thr[10];
        for (int i = 0; i < 10; i++)
        {
            t[i] = new thr(studName, studColor, i);
            Thread th = new Thread(t[i]);
            th.start();
        }
    }

    public class thr implements Runnable
    {
        public HashMap<Integer, String> name;
        public HashMap<Integer, Color> color;
        int key;

        public thr(HashMap<Integer, String> n, HashMap<Integer, Color> c, int k)
        {
            name = n;
            color = c;
            key = k;
        }

        public void run()
        {

        }

        public void paint(Graphics g)
        {
            //super.paint(g);
            g.setColor(Color.BLACK);
            g.drawString(studName.get(key), 10 + (79 * key), 69);
            g.setColor(studColor.get(key));
            g.fillRect(5 + (79 * key), 70, 79, 79);
        }
    }
}



