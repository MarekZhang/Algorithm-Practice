package algo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGraph{

    private Scanner scanner;

    public ReadGraph(Graph graph, String filename){
        readFile(filename);
        
        try{
            int n = scanner.nextInt();
            if(n < 0)
                throw new IllegalArgumentException("the number of Vertices must be nonnegative");
            assert n == graph.V();

            int m = scanner.nextInt();
            if(m < 0)
                throw new IllegalArgumentException("the number of edges must be nonnegative");
            assert m == graph.E();

            for(int i = 0; i < m; i++){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < n;
                assert w >= 0 && w < n;
                graph.addEdge(v, w);
            }
        }
        catch(InputMismatchException e){
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
        
    }

    public void readFile(String filename){
        assert filename != null;
        try{
            File file = new File(filename);
            if(file.exists()){
                FileInputStream ips = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(ips), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else
                throw new IllegalArgumentException(filename + "doesn't exist.");
            }
            catch (IOException ioe) {
                throw new IllegalArgumentException("Could not open " + filename, ioe);
            }
    }
}