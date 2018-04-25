package microservices.cloud.service.utile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StartupCompleteEvent {
	
	public void onComplete(ConfigurableApplicationContext context) throws IOException {
		
		File file = new File(System.getProperty("user.dir") + File.separator, ".startup");

		// Requests that the file or directory denoted by this abstract pathname be
		// deleted when the virtual machine terminates.
		file.deleteOnExit();

		Writer writer = new OutputStreamWriter(new FileOutputStream(file));
		
		//environment.getSystemProperties().keySet().forEach(key -> environment.getProperty(key));
		writer.write(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));

		writer.close();
		
	}

}
