package de.turing.quarkus.camel.with.wiremock.xpath;

import javax.xml.xpath.XPathFactory;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(XpathFactoryEndpoint.PATH)
@Produces(MediaType.TEXT_PLAIN)
public class XpathFactoryEndpoint {
  public static final String PATH = "xpath-factory-impl";

  @GET
  public String getXpathFactoryImplName() {
    return XPathFactory.newInstance().getClass().getCanonicalName();
  }
}
