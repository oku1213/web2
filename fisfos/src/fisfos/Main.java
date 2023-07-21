package fisfos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		//fos(FileOutputStream)
		try(
				FileOutputStream fos = new FileOutputStream("memo.txt");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
				BufferedWriter bw = new BufferedWriter(osw);
				){
			bw.write("こんにちは");
			bw.newLine();
			bw.write("さようなら");
			bw.newLine();
			System.out.println("Done");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//fis(FileInputStream)
		try(
				FileInputStream fis = new FileInputStream("memo.txt");
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);				
			}
			System.out.println("終了");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
