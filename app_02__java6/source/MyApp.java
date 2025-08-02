import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("チェック付き TODO リスト");

        // パネルとレイアウト
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 入力欄と追加ボタン
        final JTextField inputField = new JTextField();
        JButton addButton = new JButton("追加");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // TODO 項目を入れるパネル（縦に並べる）
        final JPanel todoPanel = new JPanel();
        todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));

        // スクロールできるようにする
        JScrollPane scrollPane = new JScrollPane(todoPanel);

        // 追加ボタンの処理
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = inputField.getText().trim();
                if (!task.isEmpty()) {
                    JCheckBox checkBox = new JCheckBox(task);
                    todoPanel.add(checkBox);
                    todoPanel.revalidate(); // UI 再構成
                    inputField.setText("");
                }
            }
        });

        // 削除ボタン
        JButton deleteButton = new JButton("チェックした項目を削除");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Component[] components = todoPanel.getComponents();
                ArrayList<Component> toRemove = new ArrayList<Component>();

                for (int i = 0; i < components.length; i++) {
                    Component comp = components[i];
                    if (comp instanceof JCheckBox) {
                        JCheckBox cb = (JCheckBox) comp;
                        if (cb.isSelected()) {
                            toRemove.add(cb);
                        }
                    }
                }

                for (int i = 0; i < toRemove.size(); i++) {
                    todoPanel.remove(toRemove.get(i));
                }

                todoPanel.revalidate();
                todoPanel.repaint();
            }
        });

        // パネル構成
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(deleteButton, BorderLayout.SOUTH);

        // フレーム設定
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
