/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author jeffersonbienaime
 */
public class RemoveLineTXT {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {

        
        String tempFile = "/Users/jeffersonbienaime/Downloads/donotopen/working/";
        String processedDirectory = "/Users/jeffersonbienaime/Downloads/donotopen/processed/";
        String archiveDirectory ="/Users/jeffersonbienaime/Downloads/donotopen/archive/";
        String workingDirectory ="//Users/jeffersonbienaime/Downloads/donotopen/working/";
        
        
       
        CleanFile cf = new CleanFile();
        ProcessFile pf = new ProcessFile();
        
        try (Stream<Path> paths = Files.walk(Paths.get(workingDirectory))) {
               paths.filter(Files::isRegularFile)
                    .forEach(x -> {
                   try {
                       cf.executeClean(x.toString(),tempFile);
                       pf.writeFile(processedDirectory + x.hashCode() + LocalDateTime.now().toString(),pf.manipulatedData(pf.readFile(x.toString())));
                       //pf.writeFile(processedDirectory + pf.getInf().getArtist() + pf.getInf().getAlbum(),pf.manipulatedData(pf.readFile(x.toString())));
                       pf.moveFiles(x.toString(), archiveDirectory + x.getName(x.getNameCount()-1) + ".processed" + LocalDateTime.now().toString());
                   } catch (IOException ex) {
                       Logger.getLogger(RemoveLineTXT.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (Exception ex) {
                       Logger.getLogger(RemoveLineTXT.class.getName()).log(Level.SEVERE, null, ex);
                   }
               });   
        }
    
    }

}
