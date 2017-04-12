package lv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Cocaine!" );
        int maximum=0;
        App app=new App();
        
        try {
        	CSVReader reader = new CSVReader(new FileReader("data.csv"),',');
        	CSVWriter writer = new CSVWriter(new FileWriter("data2.scv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
        	List<String[]>myEntries=reader.readAll();
        	//maximum=app.max(4,5);
        	for (String[] string : myEntries){
                Vector<String> out = new Vector<String>() ;
        		List<String> list2 = Arrays.asList(string);
        		CollectionUtils.select(list2, new Predicate<String>(){

					public boolean evaluate(String arg0) {
						if (Integer.parseInt(arg0) > 50){
						return false;
						}
						else{
							return true;
						}
					}
        			
        		}, out) ;
        		System.out.println("OUT :" + out) ;
                String[] vout=out.toArray(new String[0]);
                
                writer.writeNext(vout);
        		for (String nb : string){
        			maximum=app.max(maximum,Integer.parseInt(nb));
        			System.out.println("Nombre lu: "+Integer.parseInt(nb));
        		}
        	}
        	System.out.println("maximum: "+maximum);
            reader.close();
            writer.close();
        } catch (IOException e){
        	System.out.println("Erreur d ouverture fichier");
        }
    }
    public int max(int a, int b){
    	return a > b ? a: b;
    	//return a;
    }
}
