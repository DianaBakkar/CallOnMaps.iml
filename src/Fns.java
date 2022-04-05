import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Fns {

    //Indexes the words and lines in the file by adding them to a hashmap of String arrays
    public HashMap<Integer,String[]> Separator(String file) throws IOException {

            FileReader fileReader =
                    new FileReader(file);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            List<String> lines = new ArrayList<String>();
            String line;
            while((line=bufferedReader.readLine()) != null){
                lines.add(line);
            }
            String[] data = lines.toArray(new String[]{});

            String singleData[];
            HashMap<Integer,String[]> map=new HashMap<Integer, String[]>();
            for(int i=0;i< data.length;i++){
                singleData=data[i].split(" ");
                    map.put(i,singleData);
            }

        return map;
    }

    //Swaps Lines
    public HashMap<Integer,String[]>lineChanger(int i, int j, HashMap<Integer,String[]> map){
        String[] temp= map.get(j);
        map.put(j, map.get(i));
        map.put(i,temp);
        return map;
    }

    //Swaps Words
    public HashMap<Integer,String[]> wordChanger(int i,int j,int k,int l,HashMap<Integer,String[]> map){
        String[] temp1=map.get(i);
        String[] temp2=map.get(k);
        String temp11=temp1[j];
        String temp22=temp2[l];
        temp1[j]=temp22;
        temp2[l]=temp11;
        map.put(i,temp1);
        map.put(k,temp2);
        return map;
    }
    //updates the file with the applied changes
    public void fileChanger(HashMap<Integer,String[]> map,String file) throws IOException {

        PrintWriter deleter=new PrintWriter(file);
        deleter.print("");
        deleter.close();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);


        for(Integer key: map.keySet()){
            String[] values=map.get(key);
            pw.println(Arrays.stream(values).collect(Collectors.joining(" ")));
            pw.flush();
        }

            pw.close();
            bw.close();
            fw.close();

        }
    }

