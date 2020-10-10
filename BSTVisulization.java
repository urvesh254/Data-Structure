import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class BSTVisulization extends JFrame implements ActionListener,KeyListener
{
	Node root;

	//Node Structure
	class Node{
		JLabel data;
		Node left;
		Node right;
		Node(int info){
			data=new JLabel(info+"",SwingConstants.CENTER);
			data.setFont(new Font("Arial",Font.BOLD,20));
			data.setBorder(BorderFactory.createLineBorder(Color.black));
			data.setOpaque(true);
			data.setBackground(Color.green);
		}
	}

	//Points structure
	class Points{
		int x1=0,x2=0,y2=0,y1=0;
		Points(int x1,int y1,int x2,int y2){
			this.x1=x1;
			this.x2=x2;
			this.y2=y2;
			this.y1=y1;
		}
	}

	private JButton btnAdd;
	private JTextField tf;
	private int X=300,Y=75;
	private ArrayList<Points> p = new ArrayList<>();
	private Graphics2D g2;

	public void paint(Graphics g){
		super.paintComponents(g);
      		
		g2 = (Graphics2D)g;        
		g2.setStroke(new BasicStroke(3.0f));
		
		for(Points pts:p)
      		g2.drawLine(pts.x1+7, pts.y1+30, pts.x2+3, pts.y2+10);

      	// g2.drawLine(x1+7, y1+30, x2+3, y2+10);
     	// x1 = label.getX()+7
     	// y1 = label.getY()+30
	}

	public BSTVisulization(){
		setLayout(null); // layout

		//For geting data.
		tf=new JTextField("");
		tf.setFont(new Font("Arial",Font.BOLD,20));
		tf.setBounds(900,20,150,30);
		tf.addKeyListener(this);
		add(tf);

		//Add Button
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("Arial",Font.BOLD,20));
		btnAdd.setBounds(1070,20,100,30);
		btnAdd.addActionListener(this);
		add(btnAdd);

		// g=getGraphics();
		// g.drawLine(10, 10, 100, 100);

		setTitle("Binary Search Tree Visulization"); //Title Frame
		setResizable(false);
		setSize(1200, 700); 		//frame size
		setLocationRelativeTo(null);
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Override method.
	public void actionPerformed(ActionEvent evt){
		try{
			String data=tf.getText();
			if(!data.isEmpty()){
				add(Integer.parseInt(data));
				tf.setText("");
			}
			tf.requestFocusInWindow();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Please Enter Integer.");
			}
	}

	public void keyTyped(KeyEvent evt){
		if(evt.getKeyChar()=='\n'){
			try{
				String data=tf.getText();
				if(!data.isEmpty()){
					add(Integer.parseInt(data));
					tf.setText("");
				}
				tf.requestFocusInWindow();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Please Enter Integer.");
			}
		}
	}
  	public void keyPressed(KeyEvent evt){}
  	public void keyReleased(KeyEvent evt){}

	//Add element in BST.
	public void add(int info){
		Node newNode=new Node(info);
		if(root==null){
			root=newNode;
			newNode.data.setBounds(600,10,40,40);
		}
		else{
			Node curr=root,pre=root;
			int temp;
			X=300;
			while(curr!=null){
				pre=curr;
				temp=Integer.parseInt(curr.data.getText());
				if(info==temp){
					JOptionPane.showMessageDialog(null,info+" is already exist.");
					return;
				}
				else if(temp>info){
					curr=curr.left;
				}
				else{
					curr=curr.right;
				}
				X/=2;
			}
			X*=2;
			temp=Integer.parseInt(pre.data.getText());
			int x=pre.data.getX();
			int y=pre.data.getY();
			if(temp>info){
				pre.left=newNode;
				newNode.data.setBounds(x-X,y+Y,40,40);
				// x1=x;y1=y+20;x2=x-X+20;y2=y+Y+20;
				p.add(new Points(x,y+20,x-X+20,y+Y+20));
			}
			else{
				pre.right=newNode;
				newNode.data.setBounds(x+X,y+Y,40,40);
				// x1=x+40;y1=y+20;x2=x+X+20;y2=y+Y+20;
				p.add(new Points(x+40,y+20,x+X+20,y+Y+20));
			}
		}
		paint(getGraphics());
		add(newNode.data);
		validate();
		repaint();
	}

	public static void main(String arg[])
	{
		new BSTVisulization();
	}
}