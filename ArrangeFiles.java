import java.io.*;

class ArrangeFiles{

// public static void moveFile(){
	
// }

public static void main(String args[]){
	// creating folders
	File videos=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/videos");
	if(videos.mkdir()){
		System.out.println(videos.getName()+" folder created");
	}else{
		System.out.println(videos.getName()+" folder not created or already present");
	}

	File audio=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/audio");
	if(audio.mkdir()){
		System.out.println(audio.getName()+" folder created");
	}else{
		System.out.println(audio.getName()+" folder not created or already present");
	}
	
	File document=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/document");
	if(document.mkdir()){
		System.out.println(document.getName()+" folder created");
	}else{
		System.out.println(document.getName()+"folder not created or already present");
	}


	//moving files to folders
	File filesInFolder=new File("C:/Users/abemore/Documents/java programs/arrangeFiles");
	String fileNames[]=filesInFolder.list();
	String videoExtn=".mp4";
	String audioExtn=".mp3";
	String docuExtn[]=new String[]{".pdf",".txt"};
	for(int i=0;i<fileNames.length;i++){
		System.out.println(fileNames[i]);
		File file=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+fileNames[i]);
		if(fileNames[i].contains(videoExtn)){
			// move to videos folder
			boolean checkMove=file.renameTo(new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+videos.getName()+"/"+fileNames[i]));
			if(checkMove){
				System.out.println(fileNames[i]+" moved to "+videos.getName());
			}else{
				System.out.println(fileNames[i]+" moved to "+videos.getName());
			}
		}else if(fileNames[i].contains(audioExtn)){
			boolean checkMove=file.renameTo(new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+audio.getName()+"/"+fileNames[i]));
			if(checkMove){
				System.out.println(fileNames[i]+" moved to "+audio.getName());
			}else{
				System.out.println(fileNames[i]+" moved to "+audio.getName());
			}
		}else{
			// for(int j=0;j<docuExtn.length;j++){
				// System.out.println(fileNames[i]+" "+fileNames[i].contains(docuExtn[0])+" "+fileNames[i].contains(docuExtn[1]));
				if(fileNames[i].contains(docuExtn[0])||fileNames[i].contains(docuExtn[1])){
					boolean checkMove=file.renameTo(new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+document.getName()+"/"+fileNames[i]));
					// System.out.println("C:/Users/abemore/Documents/java programs/arrangeFiles/"+document.getName()+"/"+fileNames[i]);
					// boolean checkMove=file.renameTo(new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+files[i]));	
			
					if(checkMove){
						System.out.println(fileNames[i]+" moved to "+document.getName());
					}else{
						System.out.println(fileNames[i]+" moved to "+document.getName());
					}
				}
			// }
		}
	}

	//report.txt
	File report=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/report.txt");
	// if(report.mkdir()){
	// 	// report.delete();//delete to clear previous data
	// 	report.createNewFile();
	// }
	// boolean checkCreate=false;
	// try{
	//  checkCreate=report.createNewFile();
	//  }
    // catch (IOException e) {
    //     e.printStackTrace();
    // }
	// if(checkCreate){
	// 	System.out.println("Created report");
	// }else{		
	// 	System.out.println("Not Created report");
	// }
	String temp="";
	File vidFiles=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+videos.getName());
	String videoFiles[]=vidFiles.list();
	for(int i=0;i<videoFiles.length;i++){
		temp+=videoFiles[i]+" "+videoExtn+" "+videos.getName()+"\n";
	}
	File audFiles=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+audio.getName());
	String audioFiles[]=audFiles.list();
	for(int i=0;i<audioFiles.length;i++){
		temp+=audioFiles[i]+" "+audioExtn+" "+audio.getName()+"\n";
	}
	
	File docFiles=new File("C:/Users/abemore/Documents/java programs/arrangeFiles/"+document.getName());
	String documentFiles[]=docFiles.list();
	for(int i=0;i<documentFiles.length;i++){
		System.out.println(documentFiles[i]);
		if(documentFiles[i].contains(docuExtn[0]))
		temp+=documentFiles[i]+" "+docuExtn[0]+" "+document.getName()+"\n";		
		else if(documentFiles[i].contains(docuExtn[1]))
		temp+=documentFiles[i]+" "+docuExtn[1]+" "+document.getName()+"\n";
	}

	System.out.println("temp "+temp);
	try{
	FileWriter reportWrite = new FileWriter("report.txt");
	reportWrite.write(temp);
	reportWrite.close();
	}catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}

}