import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MissionFailed {

    public void showMissionFailed() {
        // Create a modal dialog for the mission complete screen
        //JDialog missionFailedDialog = new JDialog(Game1.this, true); // Use Game1.this as the parent
        JDialog missionFailedDialog = new JDialog((Frame) null, true); // Use null for the parent window, making it modal
        missionFailedDialog.setSize(400, 270); // Set the dialog size
        missionFailedDialog.setLayout(null); // Use absolute positioning
        missionFailedDialog.setUndecorated(true); // Remove the title bar
        missionFailedDialog.setLocationRelativeTo(null); // Center relative to the screen

        // Add the mission complete image
        JLabel missionCompleteLabel = new JLabel();
        missionCompleteLabel.setBounds(0, 0, 400, 260);

        // Magdagdag ng gray na border sa gilid ng imahe
        int borderSize = 0; // Size ng border
        missionCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, borderSize));

        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/failed.png"));

            // I-adjust ang size ng imahe upang hindi matakpan ang border
            int imageWidth = 400 - (2 * borderSize);
            int imageHeight = 270 - (2 * borderSize);
            Image scaledImage = originalIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

            // Gumawa ng ImageIcon mula sa scaled image
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Itakda ang icon ng label at i-center ito
            missionCompleteLabel.setIcon(scaledIcon);
            missionCompleteLabel.setHorizontalAlignment(JLabel.CENTER);
            missionCompleteLabel.setVerticalAlignment(JLabel.CENTER);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load 'failed.png': " + e.getMessage(),
                    "Image Load Error", JOptionPane.ERROR_MESSAGE);
        }

        missionFailedDialog.add(missionCompleteLabel);

        // Add the "Continue" button overlaying the image
        JButton backButton = new JButton("OK");
        // Pinalaki ang width ng button at in-adjust ang x-coordinate upang manatiling naka-center
        backButton.setBounds(160, 235, 70, 25); // Pinalaki ang size at in-adjust ang posisyon
        backButton.setFocusPainted(false);
        Color normalColor = new Color(137, 95, 37); // Original color
        Color hoverColor = normalColor.darker();    // Darker color for hover effect
        backButton.setBackground(normalColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBorderPainted(false); // Remove button border
        backButton.setOpaque(true);

        // Add hover effect to the button
        addHoverEffect(backButton, normalColor, hoverColor);

        // Add action listener to handle button click
        backButton.addActionListener(e -> {
            missionFailedDialog.dispose(); // Close the mission complete dialog
            // You can add any further actions here when the dialog is closed (like opening the next screen)
        });

        // Add components to the label
        missionCompleteLabel.setLayout(null); // Enable absolute positioning for components inside the label
        missionCompleteLabel.add(backButton); // Add the button to the image label
        // Ensure the dialog disposes cleanly when requested
        missionFailedDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Show the dialog
        missionFailedDialog.setVisible(true); // Show the dialog
    }

    // Helper method to add hover effect to buttons
    private void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(normalColor);
            }
        });
    }
}
