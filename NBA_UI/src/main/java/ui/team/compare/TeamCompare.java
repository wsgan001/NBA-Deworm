package ui.team.compare;

import java.awt.Graphics;
import java.awt.Image;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import service.impl.ServiceFactoryImpl;
import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.home.HomeUI;
import ui.util.MyLabel;

public class TeamCompare extends JPanel{
	private PanelConfig pcfg;
	private HomeUI frame;
	private Image bg;
	
	private String name1;
	private String name2;
	
	private MyLabel nameLb1;
	private MyLabel nameLb2;
	
	private MyLabel chart1;
	private MyLabel chart2;
	private MyLabel chart3;
	


	public TeamCompare(HomeUI frame) {
		this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
				.get(this.getClass().getName());
		this.frame = frame;
		this.bg = pcfg.getBg();
		// 设置布局管理器为自由布局
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(pcfg.getW(), pcfg.getH());
		this.setLocation(pcfg.getX(), pcfg.getY());
		// 初始化组件
	
		this.initComponent();
		this.repaint();

	}
	
	private void initComponent(){
		initLabels();
		initChart();
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(bg, 0, 0, pcfg.getW(), pcfg.getH(), null);
	}
	
	private void initLabels(){
		nameLb1 = new MyLabel(pcfg.getLabels().element("name1"));		
		add(nameLb1);
		
		nameLb2 = new MyLabel(pcfg.getLabels().element("name2"));
		add(nameLb2);
		
		
	}
	
	private void initChart(){
		chart1 = new MyLabel(pcfg.getLabels().element("chart1"));
		chart2 = new MyLabel(pcfg.getLabels().element("chart2"));
		chart3 = new MyLabel(pcfg.getLabels().element("chart3"));
		
		add(chart1);
		add(chart2);
		add(chart3);
		
		
	}
	
	public void changeData(String name1,String name2){
		ArrayList<Integer> field =new ArrayList<>();
		nameLb1.setText(name1);
		nameLb2.setText(name2);
		System.out.println(name1);
		System.out.println(name2);
		
		ImageIcon radar = null;
		ImageIcon basic = null;
		ImageIcon advance = null;
		try {
		radar = ServiceFactoryImpl.getInstance().getStatsService().getPlayerCompareRadar(name1, name2, "13-14", 1);
		basic = ServiceFactoryImpl.getInstance().getStatsService().getPlayerAdvancedCompareBarChart(name1, name2, "Career", field, 1);
		advance = ServiceFactoryImpl.getInstance().getStatsService().getPlayerBasicCompareBarChart(name1, name2, "Career", field, 1);
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		chart1.setImage(radar);
		//chart2.setImage(basic);
		//chart3.setImage(advance);

	}
}