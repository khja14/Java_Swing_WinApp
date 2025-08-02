import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("カスタムボタンの例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(null);

        JLabel label = new JLabel("まだ押されていません");
        label.setBounds(50, 30, 200, 30);
        frame.add(label);

        // 押して！ボタン
        MyCustomButton customButton = new MyCustomButton("押して！", () -> {
            label.setText("ボタンが押されました！");
        });
        customButton.setBounds(80, 80, 120, 40);
        frame.add(customButton);

        // リセットボタン
        MyCustomButton resetButton = new MyCustomButton("リセット", () -> {
            label.setText("まだ押されていません");
        });
        resetButton.setBounds(80, 140, 120, 40);
        frame.add(resetButton);

        frame.setVisible(true);
    }
}
