package ucsal.cauzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestaoDeEspacoFisicoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(GestaoDeEspacoFisicoApplication.class, args);
		Menu menu = new Menu(context);
		menu.startMenu();
		}
		
	}