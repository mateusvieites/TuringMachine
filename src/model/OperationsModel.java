package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Commands;

public class OperationsModel extends AbstractTableModel{

	private List<Commands> data = new ArrayList<>();
	private String[] colum = {"it","symbol","next","value","direction"};
	private int line; 

	private ArrayList linhas = new ArrayList();
	

    @Override
    public String getColumnName(int column) {
        return colum[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    

    @Override
    public int getColumnCount() {
        return colum.length;
    }
    
    public int getLines() {
    	return this.line;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
    	switch(coluna){
            case 0:
            	return data.get(linha).getIt();
            case 1:
            	return data.get(linha).getSymbol();
            case 2:
            	return data.get(linha).getNext();
            case 3:
            	return data.get(linha).getValue();
            case 4:
            	return data.get(linha).getDirection();
        }
        
        return null;
        
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
    	switch(coluna){
	        case 0:
	        	data.get(linha).setIt(Integer.parseInt((String) valor));
	        	break;
	        case 1:
	        	data.get(linha).setSymbol((char) Integer.parseInt((String) valor));
	        	break;
	        case 2:
	        	data.get(linha).setNext(Integer.parseInt((String) valor));
	        	break;
	        case 3:
	        	data.get(linha).setValue((char) Integer.parseInt((String) valor));
	        	break;
	        case 4:
	        	data.get(linha).setDirection((char) Integer.parseInt((String) valor));
	        	break;
    	}
    	this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Commands p){
    	line++;
        this.data.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
    	line--;
    	if(line < 0) {
    		line = 0;
    	}
        this.data.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void clearTable() {
		int size = getRowCount();
		this.data.clear();
        fireTableRowsDeleted(0,size);
	}
    
    public void addLinha(){ 
      	 this.data.add(new Commands());
         this.fireTableDataChanged();
      }
		
}
