/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package touchtyping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Che
 */
public class User {

    public enum userLevel {
        Beginner,
        Intermediate,
        Advanced
    }
    String userName = "";
    String userPassword = "";
    int userLastSpeed = 0;
    int userSpeedAvg = 0;
    Jfreechart userChart;
    userLevel userlevel;
    Settings userSettings;

    public Settings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(Settings userSettings) {
        this.userSettings = userSettings;
    }

    public User() {
    }

    public User(String username, String pass) {
        this.userName = username;
        this.userPassword = pass;
        this.userSettings = new Settings();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserLastSpeed() {
        File usersFile = new File(userName + ".data");
        if (usersFile.exists()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(userName + ".data"));
                this.userLastSpeed = Integer.parseInt(lines.get(lines.size() - 1));
                return this.userLastSpeed;
            } catch (Exception ex) {
            }
        } else {
            return this.userLastSpeed = 0;
        }
        return userLastSpeed;
    }

    public int getUserSpeedAvg() {
        File usersFile = new File(userName + ".data");
        if (usersFile.exists()) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(userName + ".data"));
                if (lines.size() >= 10) {// Calculate avg for last ten tests
                    int avg = 0;
                    for (int i = lines.size() - 10; i < lines.size(); i++) {
                        avg += Integer.parseInt(lines.get(i));
                    }
                    avg = avg / 10;
                    return avg;
                } else {
                    int avg = 0;
                    for (int i = 0; i < lines.size(); i++) {
                        avg += Integer.parseInt(lines.get(i));
                    }
                    avg = avg / lines.size();
                    return avg;
                }
            } catch (Exception ex) {
            }
        } else {
            return this.userSpeedAvg = 0;
        }
        return userSpeedAvg;
    }

    public Jfreechart getUserChart() throws IOException {
        File usersFile = new File(userName + ".data");
        if (usersFile.exists() && this.getUserSpeeds().size() >= 10) {
            this.userChart = new Jfreechart(this.getUserName(), this);
            this.userChart.setSize(700, 400);
            this.userChart.setVisible(true);
            return userChart;
        } else {
            return null;
        }

    }

    public userLevel getUserlevel() {
        int level = this.getUserSpeedAvg();
        if (level < 45) {
            this.userlevel = userlevel.Beginner;
            return this.userlevel;
        }
        if (level >= 45 && level < 70) {
            this.userlevel = userlevel.Intermediate;
            return this.userlevel;
        }
        if (level >= 70) {
            this.userlevel = userlevel.Advanced;
            return this.userlevel;
        }
        return userlevel;
    }

    public List<String> getUserSpeeds() throws IOException {
        File userfile = new File(userName + ".data");
        if (userfile.exists()) {
            List<String> speed = Files.readAllLines(Paths.get(userName + ".data"));
            return speed;
        } else {
            //JOptionPane.showMessageDialog(rootPane, "You dont have any chart Yet");
            return null;
        }
    }

    public void saveUserResult(String res) {
        try {
            FileWriter fw = new FileWriter(userName + ".data", true);
            fw.write(res);
            fw.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserLastSpeed(int userLastSpeed) {
        this.userLastSpeed = userLastSpeed;
    }

    public void setUserSpeedAvg(int userSpeedAvg) {
        this.userSpeedAvg = userSpeedAvg;
    }

    public void setUserChart(Jfreechart userChart) {
        this.userChart = userChart;
    }

    public void setUserlevel(userLevel userlevel) {
        this.userlevel = userlevel;
    }

}
