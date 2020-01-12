package game;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AppRunner extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppRunner frame = new AppRunner();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AppRunner() throws IOException {
    	setTitle("Bones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 481, 409);
        setMinimumSize(getBounds().getSize());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnMove = new JButton("STEP");
        btnMove.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnMove.setBounds(10, 323, 102, 23);
        contentPane.add(btnMove);
                
        JLabel imgLabel = new JLabel("");
        imgLabel.setHorizontalAlignment(SwingConstants.LEFT);
        imgLabel.setBounds(137, 95, 120, 120);
        contentPane.add(imgLabel);
                
        JLabel imgLabel2 = new JLabel("");
        imgLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        imgLabel2.setBounds(137, 226, 120, 120);
        contentPane.add(imgLabel2);
        
        JLabel lblScore1 = new JLabel("PLAYER");
        lblScore1.setBounds(179, 11, 45, 14);
        contentPane.add(lblScore1);
        
        JLabel lblScore2 = new JLabel("COMPUTER");
        lblScore2.setBounds(314, 11, 93, 14);
        contentPane.add(lblScore2);
        
        JLabel imgLabel3 = new JLabel("");
        imgLabel3.setBounds(287, 95, 120, 120);
        contentPane.add(imgLabel3);
        
        JLabel imgLabel4 = new JLabel("");
        imgLabel4.setBounds(287, 226, 120, 120);
        contentPane.add(imgLabel4);
        
        JLabel lblPlayer = new JLabel("0");
        lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblPlayer.setBounds(166, 36, 58, 28);
        contentPane.add(lblPlayer);
        
        JLabel lblCpu = new JLabel("0");
        lblCpu.setHorizontalAlignment(SwingConstants.CENTER);
        lblCpu.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblCpu.setBounds(314, 36, 58, 28);
        contentPane.add(lblCpu);
               
        btnMove.addActionListener(new ActionListener() {
            int playerScore = 0;
            int cpuScore = 0;
        	int round = 0;
        	public void actionPerformed(ActionEvent e) {
            	Random r = new Random();
                int score1 = r.nextInt(6) + 1;
                int score2 = r.nextInt(6) + 1;
                int score3 = r.nextInt(6) + 1;
                int score4 = r.nextInt(6) + 1;
                String path1 = "C:\\Study Java\\Work Home\\BonesApp1\\BonesApp\\img\\" + score1 + ".png";
            	String path2 = "C:\\Study Java\\Work Home\\BonesApp1\\BonesApp\\img\\" + score2 + ".png";
            	String path3 = "C:\\Study Java\\Work Home\\BonesApp1\\BonesApp\\img\\" + score3 + ".png";
            	String path4 = "C:\\Study Java\\Work Home\\BonesApp1\\BonesApp\\img\\" + score4 + ".png";
            	try {
                Image img1 = ImageIO.read(new File(path1));
                Image img2 = ImageIO.read(new File(path2));
                Image img3 = ImageIO.read(new File(path3));
                Image img4 = ImageIO.read(new File(path4));
            	imgLabel.setIcon(new ImageIcon(img1.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_AREA_AVERAGING)));
                imgLabel2.setIcon(new ImageIcon(img2.getScaledInstance(imgLabel2.getWidth(), imgLabel2.getHeight(), Image.SCALE_AREA_AVERAGING)));
                imgLabel3.setIcon(new ImageIcon(img3.getScaledInstance(imgLabel3.getWidth(), imgLabel3.getHeight(), Image.SCALE_AREA_AVERAGING)));
                imgLabel4.setIcon(new ImageIcon(img4.getScaledInstance(imgLabel4.getWidth(), imgLabel4.getHeight(), Image.SCALE_AREA_AVERAGING)));
            	}
            	catch (Exception e2) {
					// TODO: handle exception
				}
                round++;
                btnMove.setText("STEP (" + round + ")");
            	if (round <= 6) {
            		playerScore += (score1 + score2);
            		cpuScore += (score3 + score4);
            	
            		lblPlayer.setText(Integer.toString(playerScore));
            		lblCpu.setText(Integer.toString(cpuScore));
            	} 
            	if (round == 6 && (playerScore < cpuScore)) {
            		JOptionPane.showMessageDialog(null, "COMPUTER WIN!");
            		btnMove.setEnabled(false);
            	}
            	if (round == 6 && (playerScore > cpuScore)) {
            		JOptionPane.showMessageDialog(null, "PLAYER WIN!");
            		btnMove.setEnabled(false);
            	}
            	if (round == 6 && (playerScore == cpuScore)) {
            		JOptionPane.showMessageDialog(null, "DRAW!");
            		btnMove.setEnabled(false);
            	}
            	
            }
        });
        
    }
}