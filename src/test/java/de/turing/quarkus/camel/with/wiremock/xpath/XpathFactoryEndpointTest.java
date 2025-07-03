package de.turing.quarkus.camel.with.wiremock.xpath;

import java.util.Random;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(XpathFactoryEndpoint.class)

class XpathFactoryEndpointTest {
  @SuppressWarnings("unused")
  // @formatter:off
  private static final WireMockServer WIREMOCK = new WireMockServer(WireMockConfiguration.options()
      .disableOptimizeXmlFactoriesLoading(true)
      .port(new Random().nextInt(65536)));
  // @formatter:on

  @Test
  void getXpathFactoryImpl() {
    RestAssured.unregisterParser(MediaType.TEXT_PLAIN);
    // @formatter:off
    RestAssured
        .given().accept(MediaType.TEXT_PLAIN)
        .when().get()
        .then()
            .statusCode(Response.Status.OK.getStatusCode())
            .contentType(MediaType.TEXT_PLAIN)
            .body(is("org.apache.xpath.jaxp.X-PathFactoryImpl"));
    // @formatter:on
  }
}
