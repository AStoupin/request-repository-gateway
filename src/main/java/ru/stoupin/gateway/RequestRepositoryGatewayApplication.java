package ru.stoupin.gateway;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.SQLException;

@Slf4j
@EnableZuulProxy
@SpringBootApplication
@EnableJpaAuditing
public class RequestRepositoryGatewayApplication {

	public static void main(String[] args) {
		startTCPServer();
		SpringApplication.run(RequestRepositoryGatewayApplication.class, args);
	}
	public static void startTCPServer(){
		try {
			Server h2Server = Server.createTcpServer("-ifNotExists").start();
			if (h2Server.isRunning(true)) {
				log.error(h2Server.getStatus());
			} else {
				throw new RuntimeException("Could not start H2 server.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Failed to start H2 server: ", e);
		}
	}
}
