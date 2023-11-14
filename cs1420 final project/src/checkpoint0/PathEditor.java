package checkpoint0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PathEditor extends JPanel implements Runnable, MouseListener, ActionListener
{
    BufferedImage background;
    JMenuItem clearItem, saveItem, loadItem;
    Path path;


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new PathEditor());
    }

    @Override
    public void run()
    {
        try
        {
            path = new Path();
            background = javax.imageio.ImageIO.read(new File("background.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        JFrame f = new JFrame("Path Editor 2023");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 'this' is our Runnable object, but it is also our JPanel.
        f.setContentPane(this);
        this.setMinimumSize(new Dimension(600, 600));
        this.setPreferredSize(new Dimension(600, 600));


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        clearItem = new JMenuItem("Clear");
        fileMenu.add(clearItem);
        clearItem.addActionListener(this);

        loadItem = new JMenuItem("Load");
        fileMenu.add(loadItem);
        loadItem.addActionListener(this);

        saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.addActionListener(this);

        f.setJMenuBar(menuBar);
        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);
        this.addMouseListener(this);
    }

    public void paint (Graphics g)
    {
        g.drawImage(background, 0, 0, null);

        Color d = new Color (100, 0, 0);
        g.setColor(d);
        for (int i = 0; i < path.getNumberOfPoints() - 1; i++)
        {
            g.drawLine(path.getPoint(i).x, path.getPoint(i).y, path.getPoint(i+1).x, path.getPoint(i+1).y);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        path.addPoint(new Point(e.getX(), e.getY()));
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){System.out.println("x: " + e.getX() + "," + " y: " + e.getY());}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == clearItem)
        {
            path = new Path();
            repaint();
        }
        else if (e.getSource() == saveItem)
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Pick a save file:");
            int result = chooser.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File chosen = chooser.getSelectedFile();
                try {
                    PrintWriter fileOut = new PrintWriter(chosen);

                    fileOut.println(path);
                    fileOut.close();
                }
                catch (IOException ex)
                {
                    System.out.println("Could not load path.");
                }
            }
        }
        else if (e.getSource() == loadItem)
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Pick a path file:");
            int result = chooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File chosen = chooser.getSelectedFile();
                try {
                    Scanner in = new Scanner(chosen);
                    // load the path
                    path = new Path();
                    int size = Integer.parseInt(in.next());
                    for (int i = 0; i < size; i++)
                    {
                        path.addPoint(new Point(Integer.parseInt(in.next()), Integer.parseInt(in.next())));
                    }
                    repaint();
                    in.close();
                }
                catch (IOException ex)
                {
                    System.out.println("Could not load path.");
                }
            }
        }
    }
}
