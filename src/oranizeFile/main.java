package oranizeFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class main {

	public static void main(String[] args) throws IOException {
		
		File cp_pathFile = new File("C:\\Users\\ooaaa\\Desktop\\002-≥Ï¿Ω");
		String[] folderList = cp_pathFile.list();
		System.out.println(folderList);
		
		int index = 0;
		for(String tmp : folderList) {
			File srcDir = new File("C:\\Users\\ooaaa\\Desktop\\002-≥Ï¿Ω\\"+tmp);
			
			System.out.println("start " + index);
			
			if(tmp.contains("2022")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2022\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2021")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2021\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2020")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2020\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2019")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2019\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2018")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2018\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2017")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2017\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2016")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2016\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2015")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2015\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			else if(tmp.contains("2014")) {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\2014\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}else {
				File destDir = new File("C:\\Users\\ooaaa\\Desktop\\copy\\else\\"+tmp);
				Files.copy(srcDir.toPath(), destDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			
			index++;
		}
		
	}

}
