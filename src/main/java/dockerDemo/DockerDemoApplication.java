package dockerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@SpringBootApplication
public class DockerDemoApplication {
	static String apiapp(){
		String token = "cdd93879-edb7-4435-9150-58123dad58ba";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-CMC_PRO_API_KEY","Bearer"+ token);

		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> result =  restTemplate.exchange(uri, HttpMethod.GET,request,String.class);

		String json = result.getBody();
		System.out.println(json);

		String s = "y" ;
		return  s;

	}
	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
		apiapp();
	}

}
