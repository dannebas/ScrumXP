package info;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Billy
 */
public class EntryCellRenderPublic extends DefaultTableCellRenderer {

    private final Color alt2 = Color.WHITE;
    private final Color alt1 = Color.WHITE;
    private final Color weekStatus = new Color(231, 247, 254);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cr = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && column == 0) {

            setBackground(weekStatus);

        } else if (value != null && column != 0) {
            if (CalendarPublic.getMeetingsArray() == null || CalendarPublic.getMeetingsArray().isEmpty()) {
                setBackground(Color.GREEN);
            } else {
                for (String aString : CalendarPublic.getMeetingsArray()) {
                    if (value != null && value.toString().equalsIgnoreCase(aString)) {
                        setBackground(Color.YELLOW);
                    } else if (value != null && !value.toString().equalsIgnoreCase(aString)) {
                        setBackground(Color.GREEN);
                    }
                }
            }
        } else {
            setBackground(colorAlternator(row));
            setBackground(Color.WHITE);
        }
        if (value != null && (value.equals(" ") || value.equals(""))) {
            setBackground(Color.WHITE);
        } else if (value != null && column != 0) {
            if (CalendarPublic.getMeetingsArray() == null || CalendarPublic.getMeetingsArray().isEmpty()) {
                //
            } else {
                for (String aString : CalendarPublic.getMeetingsArray()) {
                    if (value != null && value.toString().equalsIgnoreCase(aString)) {
                        setBackground(Color.YELLOW);
                    }
                }
            }
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
