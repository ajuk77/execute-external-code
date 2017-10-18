package com.cs.ajinkya.execute_external_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		List<String> cmd = new ArrayList<String>();
		cmd.add("python");
		cmd.add("hello.py");

		System.out.println("Command :" + cmd.toString());

		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.directory(new File("F:" + File.separator + "Ajinkya" + File.separator + "Study" + File.separator
				+ "SummerInternship-2018" + File.separator));
		Process p = pb.start();

		String line = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String newLine;
		try {
			while ((newLine = input.readLine()) != null) {
				line = newLine;
				System.out.println("Executing the code: " + line);
			}
			System.out.println("Last line of python executor");

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				input.close();
		}

		int returnCode = 0;
		try {
			returnCode = p.waitFor();
		} catch (InterruptedException e) {
			System.out.println("Interrupted while waiting for return value" + e.getMessage());
			returnCode = -1;
		}

	}
}
