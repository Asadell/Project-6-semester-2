package com.partials;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class cTable extends JTable{
    
    public cTable(TableModel dm){
        super(dm);
        setFont( new Font("Poppins Regular", Font.PLAIN, 20) );
        getTableHeader().setFont( new Font("Poppins Bold", Font.PLAIN, 18) );
        getTableHeader().setBackground( new Color(180, 132, 108) );
        getTableHeader().setForeground( Color.WHITE );
        getTableHeader().setBorder(null);
        setBorder(null);
        setRowHeight(30);
        getTableHeader().setReorderingAllowed(false);
        setShowVerticalLines(false);
        setShowHorizontalLines(false);
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setDragEnabled(true);
        setSelectionBackground(new Color(180, 132, 108));
        setSelectionForeground(Color.WHITE);
        
        
//        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
}
