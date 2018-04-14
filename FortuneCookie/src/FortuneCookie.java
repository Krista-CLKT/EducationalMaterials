/*
    See Project Notes in the Driver class.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FortuneCookie {

    //initialize frame components
    private JFrame frame;
    private JPanel panel;
    private JLabel cookie;
    private JButton fortuneButton;
    private JLabel message;

    //initialize array indexer
    private int listIndex = 0;

    //initialize list of messages
    private String[] fortunesList = new String[20];

    //method to initialize frame, panel, image, message, and button.
    public void initializeComponents() {
        frame = new JFrame("Fortune Cookie");

        //set properties of jframe
        frame.setResizable(false);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel = new JPanel();

        //initialize the label that holds the image
        cookie = new JLabel(new ImageIcon("Images/cookie.png"));

        //initialize the fortune cookie getting button
        fortuneButton = new JButton("Get My Fortune");

        //initialize the message (blank by default)
        message = new JLabel("");
    }

    //method to style components (panel, message, button)
    public void styleComponents() {
        //initialize font
        Font messageFont = new Font("Courier", Font.ITALIC, 15);
        Font buttonFont = new Font("Courier", Font.BOLD, 13);

        /*Mix your own colors using the RGB (Red, Green, Blue)
         * color model when creating a new Color object:
         */
        Color buttonBackground = new Color(205, 175, 149);
        Color panelBackground = new Color(255, 228, 190);

        //set background color of panel
        panel.setBackground(panelBackground);

        //set font style of message
        message.setFont(messageFont);

        //set font style and background color of button
        fortuneButton.setFont(buttonFont);
        fortuneButton.setBackground(buttonBackground);
        fortuneButton.setOpaque(true);
        fortuneButton.setBorderPainted(false);
    }

    //sets locations of different components
    public void setLocations() {
        //set panel layout to null to allow for easy location changes
        panel.setLayout(null);

        //set x, y, width and height of cookie
        cookie.setBounds(55, 0, 300, 275);

        //set location and props of button
        fortuneButton.setBounds(115, 350, 158, 30);

        //set location and props of message
        message.setBounds(90, 240, 225, 100);
    }

    //add components to panel
    public void addToPanel() {
        //add panel to frame
        frame.add(panel);
        panel.add(cookie);
        panel.add(fortuneButton);
        panel.add(message);
    }

    //grab String array of fortunes
    public String[] getMessages() {
        return fortunesList;
    }

    //display random array element on button press
    public void displayOnClick() {
        //utilize method to check for user interaction
        fortuneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //restart index if user has cycled through all possible messages.
                if (listIndex == getMessages().length) {
                    listIndex = 0;
                }
                message.setText("<html><p style = text-align: center>"
                        + getMessages()[listIndex] + "</p></html>");
                listIndex++;
            }
        });
    }

    //construct FortuneCookie object
    public FortuneCookie() {
        //initialize message Strings
        fortunesList[0] = "You will meet a polar bear on the 10th of July...";
        fortunesList[1] = "Sandwiches will fall from the sky.";
        fortunesList[2] = "The next person you meet will give you great joy.";
        fortunesList[3] = "You will harvest great things in your life.";
        fortunesList[4] = "Fear is your cage; break the chains.";
        fortunesList[5] = "You have the heart of a true warrior.";
        fortunesList[6] = "Santa Claus will find you on a cold summer's day.";
        fortunesList[7] = "Fear is the path to the dark side.";
        fortunesList[8] = "You will know when you are calm and at peace.";
        fortunesList[9] = "Always pass on what you have learned.";
        fortunesList[10] = "Once you start down the dark path, forever will it dominate your destiny!";
        fortunesList[11] = "You must unlearn what you have learned.";
        fortunesList[12] = "Do or do not. There is no try.";
        fortunesList[13] = "You must name your fear before you can banish it.";
        fortunesList[14] = "Liberty dies with thunderous applause.";
        fortunesList[15] = "Winter Spring, Summer and Fall. Four seasons, four loves.";
        fortunesList[16] = "Pride is not the opposite of shame, but its source.";
        fortunesList[17] = "Sharing tea with a fascinating stranger is one of life's true delights.";
        fortunesList[18] = "It's easy to do nothing...it is hard to forgive.";
        fortunesList[19] = "You have come to the crossroads of your destiny. It is time for you to choose.";

        //call relevant methods
        this.initializeComponents();
        this.addToPanel();
        this.styleComponents();
        this.setLocations();
        this.getMessages();
        this.displayOnClick();

    }

}
