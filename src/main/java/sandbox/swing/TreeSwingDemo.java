package sandbox.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeSwingDemo {

    public TreeSwingDemo() {
        String title = "Tree Demo Application";

        JFrame frame = new JFrame(title);
        frame.setSize(200, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var label = new JLabel();
        frame.add(label, BorderLayout.SOUTH);

        var root = new DefaultMutableTreeNode("Options");

        var tree = new JTree(root);

        var a = new DefaultMutableTreeNode("A");
        root.add(a);

        var a1 = new DefaultMutableTreeNode("A1");
        a.add(a1);

        var a2 = new DefaultMutableTreeNode("A2");
        a.add(a2);

        var b = new DefaultMutableTreeNode("B");
        root.add(b);

        var b1 = new DefaultMutableTreeNode("B1");
        b.add(b1);

        var b2 = new DefaultMutableTreeNode("B2");
        b.add(b2);

        var b3 = new DefaultMutableTreeNode("B3");
        b.add(b3);

        tree.addTreeSelectionListener((tse) -> {
            label.setText(String.format("Selection is %s", tse.getPath()));
        });

        var pane = new JScrollPane(tree);

        frame.add(pane);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TreeSwingDemo::new);
    }
}
