package com.audio;

import javax.swing.JOptionPane;

class UI {
    static void run(String file) {
        MusicPlayer stillmatic = new MusicPlayer(file);
        Object[] options = {"Play", "Stop", "Exit"};

        String artist = file.split("_")[0].substring(1);
        String song = file.split("_")[1].split("\\.")[0];

        int option = -1;
        boolean quit = false;
        while (!quit) {
            option = JOptionPane.showOptionDialog(null, artist + " - " + song, "Music Player", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (option == 0) {
                stillmatic.restart();
            } else if (option == 1) {
                stillmatic.stop();
            } else if (option == 2) {
                stillmatic.stop();
                quit = true;
            }
        }

        stillmatic.close();
    }
}
