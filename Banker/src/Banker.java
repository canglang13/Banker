import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.*;


public class Banker extends JFrame implements ActionListener{
	private int p,r;
	private int[][] maxNeed;
	private int[][] allocation;
	private int[] available;
	private int[][] need;
	private int[] work;
	private boolean[] finish;
	private int waysCount=0;
	private LinkedList<Integer> way=new LinkedList<Integer>();
	private Vector ways=new Vector();
	
	private JPanel jp1=new JPanel();private JPanel jp2=new JPanel();private JPanel jp3=new JPanel();private JPanel jp4=new JPanel();private JPanel jp5=new JPanel();
	private JTable tab1=new JTable();private JTable tab2=new JTable();private JTable tab3=new JTable();JTable tab4=new JTable();JTable tab5=new JTable();
	private JScrollPane jsp1=new JScrollPane();JScrollPane jsp2=new JScrollPane();JScrollPane jsp3=new JScrollPane();JScrollPane jsp4=new JScrollPane();JScrollPane jsp5=new JScrollPane();
	private JButton but1=new JButton("设置数据");
	private JButton but2=new JButton("安全序列");
	private JButton but3=new JButton("申请资源");
	private JButton but=new JButton("确定");
	private JLabel lab1=new JLabel("进程数量：");
	private JLabel lab2=new JLabel("资源种数：");
	private JLabel lab3=new JLabel("剩余资源");
	private JLabel lab4=new JLabel("最大资源需求量");
	private JLabel lab6=new JLabel("资源申请");
	private JLabel lab5=new JLabel("已分配资源量");
	private JTextField text1=new JTextField();
	private JTextField text2=new JTextField();
	Vector colName1=new Vector();Vector row1=new Vector();Vector rowData1 = new Vector();
	Vector colName2=new Vector();Vector row2=new Vector();Vector rowData2 = new Vector();
	Vector colName3=new Vector();Vector row3=new Vector();Vector rowData3 = new Vector();
	Vector colName4=new Vector();Vector row4=new Vector();Vector rowData4 = new Vector();
	Vector colName5=new Vector();Vector row5=new Vector();Vector rowData5 = new Vector();
	Banker(String s){
		super(s);
		initialize();
	}
	
	public void initialize() {
		r=0;p=0;
		this.setBounds(100, 100, 708, 429);
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp1.setBounds(10, 10, 49, 194);this.add(jp1);
		jp2.setBounds(69, 10, 302, 194);this.add(jp2);
		jp3.setBounds(384, 10, 302, 194);this.add(jp3);
		jp4.setBounds(45, 238, 296, 52);this.add(jp4);
		jp5.setBounds(379, 238, 296, 52);this.add(jp5);
		but.setBounds(184, 349, 66, 31);this.add(but);but.addActionListener(this); 
		but1.setBounds(282, 345, 121, 39);this.add(but1);but1.addActionListener(this); 
		but2.setBounds(427, 345, 121, 39);this.add(but2);but2.addActionListener(this); 
		but3.setBounds(565, 345, 121, 39);this.add(but3);but3.addActionListener(this); 
		lab1.setBounds(32, 340, 66, 18);this.add(lab1);
		lab2.setBounds(32, 368, 66, 16);this.add(lab2);
		lab3.setBounds(159, 285, 66, 31);lab4.setBounds(143, 199, 121, 31);lab5.setBounds(482, 199, 121, 31);
		this.add(lab3);this.add(lab4);this.add(lab5);
		lab6.setBounds(495, 285, 66, 31);this.add(lab6);
		text1.setBounds(108, 337, 66, 21);this.add(text1);text1.setColumns(10);
		text2.setBounds(108, 368, 66, 21);this.add(text2);text2.setColumns(10);
		//this.add(lab3);this.add(lab4);this.add(lab5);
		this.setVisible(true);
		
	}
	
	public void setTable() {
		//Vector colName1=new Vector();Vector row1=new Vector();Vector rowData1 = new Vector();
		rowData1.removeAllElements();colName1.removeAllElements();
		rowData2.removeAllElements();colName2.removeAllElements();
		rowData3.removeAllElements();colName3.removeAllElements();
		rowData4.removeAllElements();colName4.removeAllElements();
		colName1.add("进程");
		for(int i=1;i<=p;i++) {
			row1.add("P"+String.valueOf(i));
			rowData1.add(row1.clone());
			row1.clear();
		}
		tab1=new JTable(rowData1,colName1);
		tab1.putClientProperty("terminateEditOnFocusLost", true);
		jsp1=new JScrollPane(tab1);
		jp1.setLayout(new BorderLayout());
		jp1.add(jsp1,BorderLayout.CENTER);
		
		//Vector colName2=new Vector();Vector row2=new Vector();Vector rowData2 = new Vector();
		for (int i=1;i<=r;i++) {
			colName2.add("R"+String.valueOf(i));
		}
		for(int i=1;i<=p;i++) {
			for(int j=1;j<=r;j++) {
				row2.add("");
			}
			rowData2.add(row2.clone());
			row2.clear();
		}
		tab2=new JTable(rowData2,colName2);
		tab2.putClientProperty("terminateEditOnFocusLost", true);
		jsp2=new JScrollPane(tab2);
		jp2.setLayout(new BorderLayout());
		jp2.add(jsp2,BorderLayout.CENTER);
		//Vector colName3=new Vector();Vector row3=new Vector();Vector rowData3 = new Vector();
		for (int i=1;i<=r;i++) {
			colName3.add("R"+String.valueOf(i));
		}
		for(int i=1;i<=p;i++) {
			for(int j=1;j<=r;j++) {
				row3.add("");
			}
			rowData3.add(row3.clone());
			row3.clear();
		}
		tab3=new JTable(rowData3,colName3);
		tab3.putClientProperty("terminateEditOnFocusLost", true);
		jsp3=new JScrollPane(tab3);
		jp3.setLayout(new BorderLayout());
		jp3.add(jsp3,BorderLayout.CENTER);
		
		//Vector colName4=new Vector();Vector row4=new Vector();Vector rowData4 = new Vector();
		for (int i=1;i<=r;i++) {
			colName4.add("R"+String.valueOf(i));
		}
		for(int j=1;j<=r;j++) {
			row4.add("");
		}
		rowData4.add(row4.clone());
		row4.clear();
		tab4=new JTable(rowData4,colName4);
		tab4.putClientProperty("terminateEditOnFocusLost", true);
		jsp4=new JScrollPane(tab4);
		jp4.setLayout(new BorderLayout());
		jp4.add(jsp4,BorderLayout.CENTER);
		
		colName5.add("进程编号");
		for (int i=1;i<=r;i++) {
			colName5.add("R"+String.valueOf(i));
		}
		for(int j=1;j<=r+1;j++) {
			row5.add("");
		}
		rowData5.add(row5.clone());
		row5.clear();
		tab5=new JTable(rowData5,colName5);
		tab5.putClientProperty("terminateEditOnFocusLost", true);
		jsp5=new JScrollPane(tab5);
		jp5.setLayout(new BorderLayout());
		jp5.add(jsp5,BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public void setData() {
		maxNeed=new int[p][r];
		allocation=new int[p][r];
		available=new int[r];
		need=new int[p][r];
		work=new int[r];
		finish=new boolean[p];
		
		
		for(int i=0;i<p;i++) {
			for(int j=0;j<r;j++) {
				maxNeed[i][j]=Integer.parseInt(tab2.getValueAt(i, j).toString());
				allocation[i][j]=Integer.parseInt(tab3.getValueAt(i, j).toString());
			}
		}
		for(int i=0;i<r;i++) {
			available[i]=Integer.parseInt(tab4.getValueAt(0, i).toString());
		}
		for(int i=0;i<p;i++) {
			for(int j=0;j<r;j++) {
				need[i][j]=maxNeed[i][j]-allocation[i][j];
			}
		}
		for(int i=0;i<r;i++) {
			work[i]=available[i];
			
		}
		for(int i=0;i<p;i++) {
			finish[i]=false;
		}
		/*for(int i=0;i<p;i++) {
			for(int j=0;j<r;j++) {
				System.out.print(maxNeed[i][j]);
				System.out.print(allocation[i][j]);
			}
		}
		for(int i=0;i<r;i++) {
			System.out.print(available[i]);
		}*/
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==but) {
			if(text1.getText().equals("")||text2.getText().equals("")) {
				new JOptionPane().showMessageDialog(null,"输入进程数和资源数");
			}
			else {
				this.p=Integer.parseInt(text1.getText());
				this.r=Integer.parseInt(text2.getText());
				setTable();
			}
		}
		if(e.getSource()==but1) {
			setData();
			waysCount=0;
			ways.clear();
			dfs(0);
			if(waysCount>0) {
				new JOptionPane().showMessageDialog(null,"系统满足安全状态");
			}
			else {
				new JOptionPane().showMessageDialog(null,"系统不满足安全状态");
			}
		}
		if(e.getSource()==but2) {
			new Sq(ways);
		}
		if(e.getSource()==but3) {
			waysCount=0;
			int pnum=Integer.parseInt(tab5.getValueAt(0, 0).toString());
			int[] rs=new int[r];
			for(int i=0;i<r;i++) {
				rs[i]=Integer.parseInt(tab5.getValueAt(0, i+1).toString());
			}
			boolean flag=true;
			for(int i=0;i<r;i++) {
				if(rs[i]>available[i]) {
					new JOptionPane().showMessageDialog(null,"请求资源数大于剩余资源数！");
					flag=false;
					break;
				}
				if(rs[i]>need[pnum-1][i]) {
					new JOptionPane().showMessageDialog(null,"请求资源数大于所需资源数！");
					flag=false;
					break;
				}
				
			}
			if (flag) {
				for (int i = 0; i < r; i++) {
					available[i] -= rs[i];
					allocation[pnum - 1][i] += rs[i];
					work[i] -= rs[i];
					need[pnum - 1][i] -= rs[i];
				}

				dfs(0);
				if (waysCount > 0) {
					new JOptionPane().showMessageDialog(null, "请求资源成功！");
					for (int i = 0; i < r; i++) {
						int temp = Integer.parseInt(tab3.getValueAt(pnum - 1, i).toString());
						tab3.setValueAt(temp + rs[i], pnum - 1, i);
						int temp1 = Integer.parseInt(tab4.getValueAt(0, i).toString());
						tab4.setValueAt(temp1 - rs[i], 0, i);
					}
					tab3.updateUI();
					tab4.updateUI();
				} else {
					new JOptionPane().showMessageDialog(null, "请求资源失败！处于非安全状态");
					for (int i = 0; i < r; i++) {
						available[i] += rs[i];
						allocation[pnum - 1][i] -= rs[i];
						work[i] += rs[i];
						need[pnum - 1][i] += rs[i];
					}
				}

			}
		}//end of but3
	}
	
	
	
	
	public void dfs(int finishCount) {
		
		
		if(finishCount>=p) {
			waysCount++;
			Vector t=new Vector();
			Iterator itera=way.iterator();
			while(itera.hasNext()) {
				//System.out.print(itera.next()+" ");
				t.add("P"+String.valueOf(itera.next())+" ");
				//System.out.print(t.get(0));
			}
			System.out.println();
			ways.add(t.clone());
			//System.out.print(ways.get(1));
			return;
		}
		for(int i=0;i<p;i++) {
			if(finish[i]) {
				continue;
			}
			boolean flag=true;
			for(int j=0;j<r;j++) {
				if(need[i][j]>work[j]) {
					flag=false;break;
				}
			}
			if(flag) {
				for(int j=0;j<r;j++) {
					work[j]+=allocation[i][j];
				}
				finish[i]=true;
				way.addLast(i+1);
				finishCount++;
				dfs(finishCount);
				
				for(int j=0;j<r;j++) {
					work[j]-=allocation[i][j];
				}
				finish[i]=false;
				finishCount--;
				way.removeLast();
			}
		}
		return ;
	}
	
	
	
	
	public static void main(String args[]) {
		new Banker("...");
	}
	
}
