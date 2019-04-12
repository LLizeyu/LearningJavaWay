package lbm.util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 使表格中字体居中
 * @author 2017060105017 李泽宇
 *
 */
public class SetTableColumnCenter {
	public SetTableColumnCenter(JTable table) {		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);   
		table.setDefaultRenderer(Object.class, r);	
	}
}
