/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffersonbienaime
 */
public class ProcessFile {
    
    InfoFile inf;

    public InfoFile getInf() {
        return inf;
    }

    public void setInf(InfoFile inf) {
        this.inf = inf;
    }

    public ProcessFile() {
    }
    
    public List<CsvDataLine> readFile(String file) throws Exception {
        final List<CsvDataLine> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String texto;
            while ((texto = reader.readLine()) != null) {
                String[] valores = texto.split(",");

                if (valores.length >= 2) {
                    CsvDataLine csvDataLine = new CsvDataLine(valores[0].replace("\\", "").replace("\"", "").trim(), valores[1].trim());
                    result.add(csvDataLine);
                }
            }
        }
        return result;
    }

    public void writeFile(String file, List<String> correctedlinks) throws Exception {
        String fileExtension = ".txt";

        try (PrintWriter wr = new PrintWriter(new FileWriter(file + fileExtension))) {
            correctedlinks.stream().forEach((correctedlink) -> {
                wr.write(correctedlink + "\n");
            });
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
//    private static void manipulateData(CsvDataLine csvDataLine) throws Exception {
//
//        //Parameter
//        String regex = "[A-Z]{1}";
//        String fileDirectory = "/Users/jeffersonbienaime/Downloads/donotopen/processed/";
//        String artist = "";
//        String album = "";
//        String track = "";
//
//        List<String> links = new ArrayList<>();
//
//        //Todo Maninupate data from csvDataLine and set objects) 
//        String link = csvDataLine.getLink();
//        //String linkReplaced = link.replace("http://www.haitianbeatz.com/multimedia/music/" + regex, "");
//        String linkReplaced = link.replace("http://www.haitianbeatz.com/multimedia/music/", "");
//
//        if (linkReplaced.contains("/")) {
//
//            String[] linkSplit = linkReplaced.split("/");
//            if (linkSplit.length >= 4) {
//                artist = artistAlbumTrackSpliter(linkSplit[1]);
//                album = artistAlbumTrackSpliter(linkSplit[2]);
//                track = artistAlbumTrackSpliter(linkSplit[3]);
//                System.out.print(artist + " + " + album + " + " + track + "\n\n");
//                links.add(link);
//            }
//        }
//        writeFile(fileDirectory + artist + album, links);
//    }

    public List<String> manipulatedData(List<CsvDataLine> csvDataLines) throws Exception {

        String artist = "";
        String album = "";
        String track = "";
        
        //final InfoFile inf2;

        List<String> links = new ArrayList<>();

        for (CsvDataLine csvDataLine : csvDataLines) {

            //Todo Maninupate data from csvDataLine and set objects) 
            String link = csvDataLine.getLink();
            //String linkReplaced = link.replace("http://www.haitianbeatz.com/multimedia/music/" + regex, "");
            String linkReplaced = link.replace("http://www.haitianbeatz.com/multimedia/music/", "");

            if (linkReplaced.contains("/")) {

                String[] linkSplit = linkReplaced.split("/");
                if (linkSplit.length >= 4) {
                    artist = artistAlbumTrackSpliter(linkSplit[1]);
                    album = artistAlbumTrackSpliter(linkSplit[2]);
                    track = artistAlbumTrackSpliter(linkSplit[3]);
                    System.out.print(artist + " + " + album + " + " + track + "\n\n");
                    final InfoFile inf2 = new InfoFile(artist, album);
                    this.inf=inf2;
                    links.add(link);
                }
            }
        }
        return links;
    }
    
    private String artistAlbumTrackSpliter(String linkSplit) {
        String artist = linkSplit;
        String[] artistSplit = artist.split("-", 2);
        if (artistSplit.length >= 2) {
            String realArtist = artistSplit[1];
            return realArtist;
        } else {

            return "";
        }
    }
    
    public void moveFiles(String source, String target) throws IOException{
        
        Path result = Files.move(Paths.get(source),Paths.get(target));
 
        if(result != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    
    
    }
    
    
}
