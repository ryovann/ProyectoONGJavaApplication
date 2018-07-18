package grafica.window;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {
	
	public TableModel(Object[][] rows,Object[] cells){
		super(rows,cells);
	}
	public boolean isCellEditable (int row, int column)
	   {
	       // Aquí devolvemos true o false según queramos que una celda
	       // identificada por fila,columna (row,column), sea o no editable
	     
	       return false;
	   }
}
