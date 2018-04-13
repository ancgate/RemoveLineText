/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author jeffersonbienaime
 */
public class CleanFile {

    private String filename;

    public CleanFile(String filename) {
        this.filename = filename;
    }
    
    public CleanFile() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void executeClean(String filename, String tempFile) throws IOException {

        OrgParam orgParam = new OrgParam(1, 72);

        for (int i = orgParam.getLineStart(); i <= orgParam.getLineEnd(); i++) {
            removeNthLine(filename, tempFile, 0);
        }
        for (int j = 0; j <= 6; j++) {
            removeNthLine(filename, tempFile, countLines(filename) - 1);
        }
    }

    public static void removeNthLine(String f, String tempFile, int toRemove) throws IOException {

        File tmp = File.createTempFile(tempFile, "");

        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));

        for (int i = 0; i < toRemove; i++) {
            bw.write(String.format("%s%n", br.readLine()));
        }

        br.readLine();

        String l;
        while (null != (l = br.readLine())) {
            bw.write(String.format("%s%n", l));
        }

        br.close();
        bw.close();

        File oldFile = new File(f);
        if (oldFile.delete()) {
            tmp.renameTo(oldFile);
        }
    }
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

}
