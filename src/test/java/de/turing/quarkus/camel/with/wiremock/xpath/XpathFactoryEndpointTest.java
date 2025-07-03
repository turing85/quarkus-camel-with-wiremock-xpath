package de.turing.quarkus.camel.with.wiremock.xpath;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.common.truth.Truth;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(XpathFactoryEndpoint.class)

class XpathFactoryEndpointTest {
  @SuppressWarnings("unused")
  private static final WireMockServer WIREMOCK = new WireMockServer();

  static {
    WIREMOCK.start();
  }

  @Test
  void getXpathFactoryImpl() {
    // @formatter:off
    String actual = RestAssured
        .given().accept(MediaType.TEXT_PLAIN)
        .when().get()
        .then()
            .statusCode(Response.Status.OK.getStatusCode())
            .contentType(MediaType.TEXT_PLAIN)
            .extract().body().asString();
    // @formatter:on
    Truth.assertThat(actual).isEqualTo("org.apache.xpath.jaxp.XPathFactoryImpl");
  }
}
