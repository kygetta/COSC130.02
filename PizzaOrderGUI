import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.ArrayList;
//Author: Kylie Hall
//Start: 4/13/21
//End:4/15/21

//Code Description:  This code will create a window where they will order a pizza. This window will allow the user to select toppings and one crust type for a pizza. After the user has selected at least one of each and press the order button, the window will close and the order will print in the console.


public class Main extends JFrame implements ActionListener{

private JTextField Pizza;
//TextField creates the visible typing box
private JCheckBox Toppings[];
//Initialized Checkboxes
private String choices[] = {"mushrooms", "Pepperoni", "Pineapple", "Onion", "Ham", "green peppers", "sausage", "extra cheese"};
//Creates choices array used for toppings checkboxes

String CrustType = " "; //initializes crusttype

//These are all the different crust types initialized as radio buttons.
private JRadioButton thin;
private JRadioButton hand;
private JRadioButton pan;
private JRadioButton stuffed;

//Creates a buttongroup for the crusts so that only one is able to be chosen
private ButtonGroup Crust;

//initialized the order button as a JButton
private JButton OrderButton;
//Creates the arraylist for toppings.
ArrayList<String> ToppingType = new ArrayList<String>();

//These are two JLabels used to label each of the options
JLabel label = new JLabel("Toppings:");
JLabel label2 = new JLabel("Crust:");

//MethodDescription: This method essentially adds everything to the window while also calling for ActionListener and Item Listener.
public Main(){
  super("Pizza Ordering Form");
  setLayout(new FlowLayout()); //Makes sure everything doesn't get pasted ontop of each other.

  MyHandler m = new MyHandler();// initialize MyHandler

  //Change label colors so they are easier for the user to see.
label2.setForeground(Color.red);
label.setForeground(Color.red);

//Creates size of frame
  Pizza = new JTextField(25);
//adds the TextField
  add(Pizza);

//adds the first label before the toppings are listed.
add(label, BorderLayout.WEST);
//initializes toppings array of checkboxes with the length of choices.length in main
  Toppings = new JCheckBox[choices.length];

  //This adds the elements into each index of checkbox.
  for(int i=0;i<choices.length;i++){
    Toppings[i] = new JCheckBox(choices[i]);
    add(Toppings[i]);

//Creates an item listener which will be used to find when the user selects a topping in the next method.
    Toppings[i].addItemListener(m);
  }

//Creates the OrderButton with the text as "Order!"
      OrderButton = new JButton("Order!");

//Creates each type of crust as a radiobutton
  thin = new JRadioButton("thin");
  hand = new JRadioButton("hand");
  pan = new JRadioButton("pan");
  stuffed = new JRadioButton("stuffed");

//Add itemlistener for each radiobutton
  thin.addItemListener(m);
  hand.addItemListener(m);
  pan.addItemListener(m);
  stuffed.addItemListener(m);

//Add actionlistener for the order button which will be used to print out the users order in this actionlistener method
      OrderButton.addActionListener(this);

//add the crust type label before the crusts are added to the window.      
add(label2, BorderLayout.WEST);

//Add crust types to the window
  add(thin);
  add(hand);
  add(pan);
  add(stuffed);
add(OrderButton);

//Creates crust as buttongroup that can only be selected one at a time.
  Crust = new ButtonGroup();
  //adds each crust type into the button group.
  Crust.add(thin);
  Crust.add(hand);
  Crust.add(pan);
  Crust.add(stuffed);

}

//MethodDescription: This method keeps track of each crust type and topping type(s) as the user selects them. The crust type is stored as a string and the toppings are stored in an arraylist.
  private class MyHandler implements ItemListener{
    public void itemStateChanged(ItemEvent event){


//These if statents will find if the user selected a JRadioButton. If it is chosen, then the String CrustType will equal that crust type.
      if((event.getSource() == thin) && thin.isSelected()){
        CrustType = "thin";
      //CrustType will be thin crust

      }else if((event.getSource() == hand) && hand.isSelected()){
        CrustType = "hand";
      //CrustType will be hand tossed crust

      }else if((event.getSource() == pan) && pan.isSelected()){
        CrustType = "pan";
      //CrustType will be pan cooked crust

      }else if((event.getSource() == stuffed) && stuffed.isSelected()){
        CrustType = "stuffed";
      //CrustType will be stuffed crust
      }

    //The series of if statements below will go through each place of the array Toppings and if at this place it is selected, then the text at this index will be added to an arraylist called toppingtype 
     if((event.getSource() == Toppings[0]) && Toppings[0].isSelected()){
        ToppingType.add(Toppings[0].getText());
        //Adds mushrooms into the arraylist
      }
      else if(event.getSource() == Toppings[1] && Toppings[1].isSelected()){
        ToppingType.add(Toppings[1].getText());
        //adds pepperoni into the arraylist
      }
      else if(event.getSource() == Toppings[2] && Toppings[2].isSelected()){
        ToppingType.add(Toppings[2].getText());
        //adds pineapple into the arraylist
      }
      else if(event.getSource() == Toppings[3] && Toppings[3].isSelected()){
        ToppingType.add(Toppings[3].getText());
        //adds onion into the arraylist
      }
      else if(event.getSource() == Toppings[4] && Toppings[4].isSelected()){
        ToppingType.add(Toppings[4].getText());
        //adds ham into the arraylist
      }
      else if(event.getSource() == Toppings[5] && Toppings[5].isSelected()){
        ToppingType.add(Toppings[5].getText());
        //adds green peppers into the arraylist
      }
      else if(event.getSource() == Toppings[6] && Toppings[6].isSelected()){
        ToppingType.add(Toppings[6].getText());
        //adds sausage into the arraylist
      }
      else if(event.getSource() == Toppings[7] && Toppings[7].isSelected()){
        ToppingType.add(Toppings[7].getText());
        //adds extra cheese into the arraylist
      }
        }
  }
      
      //MethodDescription: This method sets up all of the important functions of the window.
      public static void main (String args []){
        Main cb = new Main();//New instance of main
        
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the window to exit on close of the window
        cb.setSize(350,200);
        //sets the size/dimensions of the window
        cb.setVisible(true);
        //sets the window as visible to the user.

      }


//MethodDescription: This method will print out the users order and close the window.(This method is triggered after the OrderButton is pressed.)
    public void actionPerformed(ActionEvent arg0){
      
      //If the user has chosen at least one crust type and at least one topping then print the order.
      //If the user hasn't met these requirements, the order button will not trigger anything in this method until they choose at least one of each.
      if( ToppingType.size()>0 && CrustType.length()>1){
      System.out.println("YOUR ORDER:" + "\n" + "A " + CrustType + " crust pizza with these toppings: " + ToppingType);
        //Prints the order with crust type and topping(s)
      System.exit(0); //This will close the window.

    }
      }
}
