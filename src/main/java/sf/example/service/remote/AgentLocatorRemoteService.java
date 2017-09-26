package sf.example.service.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/agentLocator")
/**
 * A simple invocation of a remote webservice.
 */
public class AgentLocatorRemoteService {
	@RequestMapping(value = "/agents", method = RequestMethod.GET)
	@ApiOperation("Find agents")
	public List<Agent> findAgents(@RequestParam(required = true, defaultValue = "61704") int zipCode,
			@RequestParam(required = true, defaultValue = "40.4772644") double lat,
			@RequestParam(required = true, defaultValue = "-88.93180819999998") double lon) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			// Not pretty, but the service seems to require all these parameters
			// and in Java it's just easier to use a String.
			String requestString = "{\"type\":\"postalCode\",\"postalCode\":\"" + zipCode + "\",\"latitude\":" + lat + ",\"longitude\":"
					+ lon
					+ ",\"customerDistancePreference\":\"100\",\"customerLanguagePreference\":\"\",\"firstName\":\"\",\"lastName\":\"\",\"requiredProducts\":\"\"}";

			HttpPost post = new HttpPost("https://www.statefarm.com/agent/locateAgencyOffices/bySearchType");
			post.setHeader("Content-Type", "application/json");
			post.setEntity(new StringEntity(requestString));

			HttpResponse response = httpClient.execute(post);
			String body = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

			JsonElement element = new Gson().fromJson(body, JsonElement.class);

			return parseAgentNames(element.getAsJsonObject());
		} catch (IOException e) {
			throw new SearchException("Could not find agents.", e);
		}
	}

	private List<Agent> parseAgentNames(JsonObject topLevelJsonObject) {
		List<Agent> agents = new ArrayList<Agent>();

		for (JsonElement agentOffice : topLevelJsonObject.get("locatedOfficeList").getAsJsonArray()) {
			JsonObject agentOfficeObject = agentOffice.getAsJsonObject();
			
			Agent agent = new Agent();
			agent.setName(getAttr(agentOfficeObject, "nameOfAgency"));
			agent.setEmailAddress(getAttr(agentOfficeObject, "emailAddress"));

			JsonObject address = agentOfficeObject.get("businessAddress").getAsJsonObject();
			agent.setAddress(getAttr(address, "streetAddressLine1") + "\n" + getAttr(address, "streetAddressLine2") + "\n"
					+ getAttr(address, "city") + ", " + getAttr(address, "postalState") + " " + getAttr(address, "postalCode"));

			JsonObject phone = agentOfficeObject.get("displayPhoneNumber").getAsJsonObject();
			agent.setPhoneNumber(getAttr(phone, "areaCode") +"-"+ getAttr(phone, "linePrefix") +"-"+ getAttr(phone, "lineSuffix"));
			
			
			agents.add(agent);
		}

		return agents;
	}

	private String getAttr(JsonObject jsonObject, String attr) {
		return jsonObject.get(attr).getAsString();
	}
}
