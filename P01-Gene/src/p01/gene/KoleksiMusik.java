/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p01.gene;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Afkar
 */
public class KoleksiMusik extends AbstractTableModel {
 List<Musik> list = new ArrayList<>();
 
 @Override
 public int getRowCount() {
 return list.size();
 }
 
 @Override
 public int getColumnCount() {
 return 2;
 }
 @Override
synchronized
 public Object getValueAt(int rowIndex, int columnIndex) {
     return switch (columnIndex) {
         case 0 -> list.get(rowIndex).getFileName();
         case 1 -> list.get(rowIndex).getFileSize();
         default -> "";
     };
 }
 @Override
 public String getColumnName(int column) {
     return switch (column) {
         case 0 -> "JUDUL LAGU";
         case 1 -> "UKURAN";
         default -> "";
     };
 }
 
 public void add(Musik m){
list.add(m); 
fireTableRowsInserted(getRowCount(),getColumnCount());
 }
 
 public void set(int i , Musik m){
 list.set(i, m);
 fireTableDataChanged();
 }
 
 public void clear(){
 list.clear();
 fireTableDataChanged();
 }
 
 public void remove(int row){
 list.remove(row);
 fireTableRowsDeleted(row, row);
 }
 
 public Musik get(int row){
 return (Musik) list.get(row);
 }
 
}
