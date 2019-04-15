package fr.benoit.conference.endpoint;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@ApplicationScoped
@Health
public class MemoryUsage implements HealthCheck {
	public HealthCheckResponse call() {
		return HealthCheckResponse.builder()
			.name("memory")
			.up()
			.withData("freeMemory", Runtime.getRuntime().freeMemory())
			.withData("totalMemory", Runtime.getRuntime().totalMemory())
			.build();
	}
}
