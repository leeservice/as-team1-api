package org.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class trueConfiguration extends Configuration {
<<<<<<< HEAD
  @Valid
  @NotNull
  private final SwaggerBundleConfiguration swagger = new SwaggerBundleConfiguration();

  @JsonProperty("swagger")
  public SwaggerBundleConfiguration getSwagger(){
    swagger.setResourcePackage("org.kainos.ea.controller");
    String[] schemes = {"http", "https"};
    swagger.setSchemes(schemes);
    return swagger;
  }
=======
    @Valid @NotNull
    private final SwaggerBundleConfiguration swagger = new SwaggerBundleConfiguration();
>>>>>>> c42ba9ac65a91f8ba3eb550ae719fbe249f2f073

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration getSwagger() {
        swagger.setResourcePackage("org.kainos.ea.controller");
        String[] schemes = {"http", "https"};
        swagger.setSchemes(schemes);
        return swagger;
    }
}
