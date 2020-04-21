package info;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Billy
 */
public class EntryCellRender extends DefaultTableCellRenderer {

    private final Color alt2 = Color.WHITE;
    private final Color alt1 = Color.WHITE;
    //private final Color alt1 = new Color(135, 187, 162);
    private final Color weekStatus = new Color(231, 247, 254);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cr = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && column == 0) {
            //if (((Boolean) value).booleanValue() == false) {
            setBackground(weekStatus);
            //} else {
            //    setBackground(colorAlternator(row));
            //}
        } else if (value != null && value.equals("15")) {
            setBackground(Color.CYAN);
        } else {
            setBackground(colorAlternator(row));
        }

        return cr;
    }

    private Color colorAlternator(int row) {
        if ((row % 2) == 0) {
            return alt1;
        } else {
            return alt2;
        }
    }
}
