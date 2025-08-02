import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyCustomButton extends JComponent {
    // 自作のUIコンポーネント
    // * JButtonの代わりに使うカスタムボタン
    private String label;
    private boolean hovered = false;
    private boolean pressed = false;
    private Runnable onClick;

    public MyCustomButton(String label, Runnable onClick) {
        this.label = label;
        this.onClick = onClick;

        // マウスイベントを自分で処理する（既存のJButtonなどは使わない）
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                hovered = false;
                pressed = false;
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                if (pressed && hovered && onClick != null) {
                    onClick.run();
                }
                pressed = false;
                repaint();
            }
        });

        setPreferredSize(new Dimension(120, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // カスタムUIクラスでの画面への描画は、 "Graphics2Dクラス" を使う
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 背景
        if (pressed) {
            g2.setColor(Color.DARK_GRAY);
        } else if (hovered) {
            g2.setColor(Color.GRAY);
        } else {
            g2.setColor(Color.LIGHT_GRAY);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        // ラベル
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(label);
        int textHeight = fm.getHeight();
        g2.drawString(label, (getWidth() - textWidth) / 2, (getHeight() + textHeight / 2) / 2);
    }
}
