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
    private int antal;
    //private final Color alt1 = new Color(135, 187, 162);
    private final Color weekStatus = new Color(231, 247, 254);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cr = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.antal = this.antal + 1;
        ACalendar.getMeetingsArray();
        System.out.println("hej");

        if (value != null && column == 0) {

            setBackground(weekStatus);

        } else if (value != null && column != 0) {
            for (String aString : ACalendar.getMeetingsArray()) {
                /*if (aString.startsWith("0")) {
                    System.out.println(aString + " DENHÄR STRÄNGEN BLIR:");
                    aString = aString.substring(1, 2);
                    System.out.println(aString + " FÖRKORTAD STRING");
                }*/
                if (value != null && value.toString().contains(aString)) {
                    setBackground(Color.YELLOW);
                    continue;
                } else if (value != null && !value.toString().contains(aString)) {
                    setBackground(Color.GREEN);
                }
            }

        } else {
            setBackground(colorAlternator(row));
            setBackground(Color.WHITE);
        }

        if (value != null && (value.equals(" ") || value.equals(""))) {
            setBackground(Color.WHITE);
        } else if (value != null && column != 0) {
            for (String aString : ACalendar.getMeetingsArray()) {
                /*if (aString.startsWith("0")) {
                    System.out.println(aString + " DENHÄR STRÄNGEN BLIR:");
                    aString = aString.substring(1, 2);
                    System.out.println(aString + " FÖRKORTAD STRING");
                }*/
                if (value != null && value.toString().contains(aString)) {
                    setBackground(Color.YELLOW);
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
