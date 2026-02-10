import java.util.Date;

class CloudFile {
	private String filename;
	private String userId;
	private int accessCount;
	private Date lastAccessTime;
	
	public CloudFile(String filename, String userId) {
		this.filename = filename;
		this.userId = userId;
		this.accessCount = 0;
		this.lastAccessTime = null;
	}

	public void recordAccess() {
		this.accessCount++;
		this.lastAccessTime = new Date();
	}

	public void generateAccessReport() {
	
		System.out.println("Filename: " + this.filename);
		System.out.println("User ID: " + this.userId);
		System.out.println("Access Count: " + this.accessCount);
		if (this.lastAccessTime != null) {
			System.out.println("Last Access Time: " + this.lastAccessTime);

			System.out.println("Last Access Time: Never accessed");
		}
		
	}
}

class CloudFileLogger {
	public static void main(String[] args) {
		CloudFile file1 = new CloudFile("document.pdf", "user001");
		CloudFile file2 = new CloudFile("image.jpg", "user002");
		CloudFile file3 = new CloudFile("video.mp4", "user001");
		
		file1.recordAccess();
		file1.recordAccess();
		file1.recordAccess();
		file2.recordAccess();
		file3.recordAccess();
		file3.recordAccess();
		
		file1.generateAccessReport();
		System.out.println();
		file2.generateAccessReport();
		System.out.println();
		file3.generateAccessReport();
	}
}