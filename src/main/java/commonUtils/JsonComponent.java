package commonUtils;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonComponent {
	public static JSONObject getJsonObject(String strJsonObjectName) {
		try {
			Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "TestData", strJsonObjectName);
			JSONObject JSONFileData = (JSONObject) new JSONParser().parse(new FileReader(path + ".json"));
			return JSONFileData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public static JSONObject getJsonData(String strDataElementName, String strFileName) {
		Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "TestData", strFileName);
		try {
			JSONObject JSONFileData = (JSONObject) new JSONParser().parse(new FileReader(path + ".json"));
			JSONObject joTestData = (JSONObject) JSONFileData.get(strDataElementName);
			return joTestData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}