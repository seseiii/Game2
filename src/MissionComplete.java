import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MissionComplete {

    public void showMissionComplete() {
        // Create a modal dialog for the mission complete screen
        //JDialog missionCompleteDialog = new JDialog(Game1.this, true); // Use Game1.this as the parent
        JDialog missionCompleteDialog = new JDialog((Frame) null, true); // Use null for the parent window, making it modal
        missionCompleteDialog.setSize(400, 270); // Set the dialog size
        missionCompleteDialog.setLayout(null); // Use absolute positioning
        missionCompleteDialog.setUndecorated(true); // Remove the title bar
        missionCompleteDialog.setLocationRelativeTo(null); // Center relative to the screen

        // Add the mission complete image
        JLabel missionCompleteLabel = new JLabel();
        missionCompleteLabel.setBounds(0, 0, 400, 260);

        // Magdagdag ng gray na border sa gilid ng imahe
        int borderSize = 0; // Size ng border
        missionCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, borderSize));

        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/missioncomplete.png"));

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
            JOptionPane.showMessageDialog(null, "Failed to load 'missioncomplete.png': " + e.getMessage(),
                    "Image Load Error", JOptionPane.ERROR_MESSAGE);
        }

        missionCompleteDialog.add(missionCompleteLabel);

        // Add the "Continue" button overlaying the image
        JButton continueButton = new JButton("Continue");
        // Pinalaki ang width ng button at in-adjust ang x-coordinate upang manatiling naka-center
        continueButton.setBounds(150, 235, 100, 25); // Pinalaki ang size at in-adjust ang posisyon
        continueButton.setFocusPainted(false);
        Color normalColor = new Color(137, 95, 37); // Original color
        Color hoverColor = normalColor.darker();    // Darker color for hover effect
        continueButton.setBackground(normalColor);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.BOLD, 14));
        continueButton.setBorderPainted(false); // Remove button border
        continueButton.setOpaque(true);

        // Add hover effect to the button
        addHoverEffect(continueButton, normalColor, hoverColor);

        // Add action listener to handle button click
        continueButton.addActionListener(e -> {
            missionCompleteDialog.dispose(); // Close the mission complete dialog
            // You can add any further actions here when the dialog is closed (like opening the next screen)
        });

        // Add components to the label
        missionCompleteLabel.setLayout(null); // Enable absolute positioning for components inside the label
        missionCompleteLabel.add(continueButton); // Add the button to the image label

        // Ensure the dialog disposes cleanly when requested
        missionCompleteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Show the dialog
        missionCompleteDialog.setVisible(true); // Show the dialog
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
