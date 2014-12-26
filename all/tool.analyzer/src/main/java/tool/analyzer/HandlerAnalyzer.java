package tool.analyzer;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

class HandlerData {
	private String name;
	private long times;
	private long time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimes() {
		return times;
	}

	public void setTimes(long times) {
		this.times = times;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String toString() {
		return name + ",times:" + times + ",avg time:" + (time / times);
	}
}

public class HandlerAnalyzer {

	public void analyze(String path) throws Exception {
		HashMap<String, HandlerData> handler2times = new HashMap<>();
		
		File dir = new File(path);

		for (String name : dir.list()) {
			if (!name.startsWith("handler.log")) {
				continue;
			}
			BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + name));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("-->");
				String[] handler2time = split[1].split(" run:");
				HandlerData old = handler2times.get(handler2time[0]);
				if (old == null) {
					old = new HandlerData();
					old.setName(handler2time[0]);
				}
				old.setTime(old.getTime() + Long.parseLong(handler2time[1]));
				old.setTimes(old.getTimes() + 1);
				handler2times.put(handler2time[0], old);
			}
			reader.close();
		}

		for (HandlerData data : handler2times.values()) {
			System.out.println(data);
		}
	}

}
