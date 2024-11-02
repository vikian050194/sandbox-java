package sandbox.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TableSwingDemo {

    public TableSwingDemo() {
        String title = "Table Demo Application";

        String[] columns = {"Name", "Extension", "ID#"};

        Object[][] data = {
            {"Gail", "4567", "865"},
            {"Ken", "234", "2323"},
            {"Viviane", "873", "5634"},
            {"Melanie", "27", "346"},
            {"Anne", "456", "67"},
            {"John", "76", "3456"},
            {"Matt", "3457", "865"},
            {"Claire", "227", "2678"},
            {"Erwin", "25", "823455"},
            {"Ellen", "245", "246"},
            {"Jennifer", "26", "45757"},
            {"Ed", "577", "2357"},
            {"Helen", "346", "879978"}
        };

        JFrame frame = new JFrame(title);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var table = new JTable(data, columns);

        var pane = new JScrollPane(table);

        frame.add(pane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableSwingDemo::new);
    }
}
